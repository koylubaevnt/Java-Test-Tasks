package com.koylubaevnt.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.koylubaevnt.database.datasets.DBConfig;
import com.koylubaevnt.database.datasets.StaffingStructureDataSet;
import com.koylubaevnt.database.executor.Executor;
import com.koylubaevnt.database.xml.XMLDOM;

public class ProcessData {
	
	private final static Logger logger = Logger.getLogger(ProcessData.class);
	
	/**
	 * Главный метод по обработке операций над БД.
	 * Выполняет требуемые операции в БД для XML файла
	 * 
	 * @param operation Вид операции {@link Operation}
	 * @param fileName имя XML файла
	 * @throws Exception
	 */
	public static void process(Operation operation, String fileName) throws Exception {
		logger.info("Начало обработки данных");
		switch (operation) {
		case SYNC:
			sync(fileName);
			break;
		case UNLOAD:
			unload(fileName);
			break;
		case INIT:
			init(fileName);
			break;
		default:
			logger.error("Неизвестная операция для приложения: " + operation);
			throw new RuntimeException("Неизвестная операция для приложения: " + operation);
		}
		logger.info("Конец обработки данных");
	}
	
	/**
	 * Метод выполняющий операцию "синхронизации" БД с файлом XML. 
	 * 
	 * @param fileName имя XML файла
	 * @throws Exception
	 */
	private static void sync(final String fileName) throws Exception {
		logger.info("Начало синхронизации данных в XML файле \"" + fileName + "\" и базе данных");		
		final List<StaffingStructureDataSet> list;
		try {
			list = XMLDOM.read(fileName);
			logger.debug("Проверка на уникальность записей в XML файле \"" + fileName + "\" по натуральному ключу");
			Set<StaffingStructureDataSet> unique = new HashSet<>();
			for(StaffingStructureDataSet entity : list) {
				if (unique.contains(entity)) {
					logger.error("Файл XML содержит неуникальные записи по ключу: [depCode=" + entity.getDepCode() + ", depJob=" + entity.getDepJob() + "]");
					throw new RuntimeException("Файл XML содержит неуникальные записи по ключу");
				}
				unique.add(entity);
			}
			logger.info("Начало синхронизации данных в XML файле \"" + fileName + "\"и базе данных");
			try {
				final List<StaffingStructureDataSet> listEntitiesDB = getAllStaffingStructureDataSet();
				StringBuilder sb = new StringBuilder();
				logger.debug("Определяем данные для добавления в БД");				
				List<StaffingStructureDataSet> listToAddDB = list.stream().filter((e) -> !listEntitiesDB.contains(e)).collect(Collectors.toList());
				List<String> listOperations = new ArrayList<>(listToAddDB.size());
				listToAddDB.stream().forEach(e -> {
					sb.append("insert into StaffingStructure (depCode, depJob, description) values(\"")
					.append(e.getDepCode()).append("\",\"")
					.append(e.getDepJob()).append("\",\"")
					.append(e.getDescription())
					.append("\")");
					listOperations.add(sb.toString());
					sb.setLength(0);
				});
				int count = listOperations.size();
				logger.debug("Количество записей для добавления: " + count);				
				
				logger.debug("Определяем данные для удаления из БД");
				List<StaffingStructureDataSet> listToDelDB = listEntitiesDB.stream().filter((e) -> !unique.contains(e)).collect(Collectors.toList());
				if(listToDelDB.size() > 0) {
					sb.append("delete from StaffingStructure where id in(");
					listToDelDB.stream().peek(e -> sb.append(e.getId()).append(",")).count();
					sb.delete(sb.length() - 1, sb.length());
					sb.append(")");				
					listOperations.add(sb.toString());
					sb.setLength(0);
				}
				count += listToDelDB.size();
				logger.debug("Количество записей для удаления: " + listToDelDB.size());
				
				logger.debug("Определяем данные для изменения в БД");
				listEntitiesDB.stream().filter(e -> unique.contains(e))
				.forEach(e -> {
					StaffingStructureDataSet newEntity = unique.stream().collect(Collectors.toMap(p -> p, t -> t)).get(e);
					if(!newEntity.getDescription().equals(e.getDescription())) {
						sb.append("update StaffingStructure set description = \"")
						.append(newEntity.getDescription())
						.append("\" where id = ")
						.append(e.getId());
						listOperations.add(sb.toString());
						sb.setLength(0);
					};
				});
				logger.debug("Количество записей для изменения: " + (listOperations.size() - count));
				
				if(!listOperations.isEmpty()) {
					logger.info("Выполняется синхронизация");
					Executor executor = new Executor();
					Connection connection = DBConfig.getInstance().getConnection();
					String array[] = new String[listOperations.size()];
					executor.execUpdate(connection, listOperations.toArray(array));
				}
			} catch (SQLException e) {
				logger.error("Ошибка при обращении к базе данных.", e);
				throw e;
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error("Ошибка при работе с XML файлом.", e);
			throw e;
		}
		logger.info("Конец синхронизации данных в XML файле \"" + fileName + "\"и базе данных");		
		
	}

	/**
	 * Метод выполняющий операцию "выгрузки" данных из БД в файл XML. 
	 * 
	 * @param fileName имя XML файла
	 * @throws Exception
	 */
	private static void unload(String fileName) throws Exception {
		logger.info("Начало выгрузки данных из базы данных в XML файл \"" + fileName + "\"");		
		List<StaffingStructureDataSet> listEntities = new LinkedList<>();
		try {
			logger.info("Запрос данных из базы данных");
			listEntities = getAllStaffingStructureDataSet();
			try {
				logger.info("Запись данных в XML файл \"" + fileName + "\"");
				XMLDOM.write(listEntities, fileName);
			} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError
					| TransformerException e) {
				logger.error("Ошибка при записи в XML файл.", e);
				throw e;
			}
		} catch (SQLException e) {
			logger.error("Ошибка при выполнении запроса к базе данных по получению всей информации.", e);
			throw e;
		}
		logger.info("Конец выгрузки данных из базы данных в XML файл \"" + fileName + "\"");
	}
	
	/**
	 * Метод выполняющий операцию "инициализацию" БД и загрузку начальных данных ив файла XML. 
	 * 
	 * @param fileName имя XML файла
	 * @throws Exception
	 */
	private static void init(String fileName) throws Exception {
		logger.info("Начало создания объектов базы данных");
		Executor executor = new Executor();
		Connection connection = DBConfig.getInstance().getConnection();
		String[] queries = new String[4];
		queries[0] = "DROP INDEX IF EXISTS [IDX_STAFFINGSTRUCTURE_UNIQUE]";
		queries[1] = "DROP TABLE IF EXISTS StaffingStructure";
		queries[2] = "CREATE TABLE [StaffingStructure] (" +
					"[ID] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT," +
					"[DepCode] VARCHAR(20)  NULL," +
					"[DepJob] VARCHAR(100)  NULL," +
					"[Description] VARCHAR(255)  NULL)";
		queries[3] = "CREATE UNIQUE INDEX [IDX_STAFFINGSTRUCTURE_UNIQUE] ON [StaffingStructure]("+
					"[DepCode]  ASC,"+
					"[DepJob]  ASC)";
		executor.execUpdate(connection, queries);
		
		logger.info("Добавления данных в базу данных из файла \"" + fileName + "\"");
		final List<StaffingStructureDataSet> list;
		list = XMLDOM.read(fileName);
		StringBuilder sb = new StringBuilder();
		list.stream().forEach(e -> {
			sb.append("insert into StaffingStructure (depCode, depJob, description) values(\"")
			.append(e.getDepCode()).append("\",\"")
			.append(e.getDepJob()).append("\",\"")
			.append(e.getDescription())
			.append("\")");
			try {
				executor.execUpdate(connection, sb.toString());
			} catch (SQLException ex) {
				logger.error("ошибка добавления записи ы БД: " + sb.toString(), ex);
			}
			sb.setLength(0);
		});
		logger.info("Конец создания объектов базы данных");
	}
	
	/**
	 * Метод получения всех записей из БД по "Штатной структуре"
	 * 
	 * @return список сущностей "Штатная структура" List<{@link StaffingStructureDataSet}>
	 * @throws SQLException
	 */
	private static List<StaffingStructureDataSet> getAllStaffingStructureDataSet() throws SQLException {
		Executor executor = new Executor();
		Connection connection = DBConfig.getInstance().getConnection();
		String query = "select * from StaffingStructure";
		return executor.execQuery(connection, query, (ResultSet resultSet) -> {
			List<StaffingStructureDataSet> list = new LinkedList<>();
			while(resultSet.next()) {
				StaffingStructureDataSet record 
					= new StaffingStructureDataSet(
						resultSet.getInt("ID"),
						resultSet.getString("DepCode"),
						resultSet.getString("DepJob"),
						resultSet.getString("Description"));
				list.add(record);
				logger.debug("Обработка записи: " + record);
			}
			return list;
		});
	}
}
