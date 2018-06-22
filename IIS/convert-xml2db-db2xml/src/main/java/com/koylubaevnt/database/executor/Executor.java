package com.koylubaevnt.database.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.koylubaevnt.database.handlers.ResultHandler;

/**
 * Класс выполняющий операции DML в базе данных посредством JDBC 
 * 
 * @author KojlubaevNT
 *
 */
public class Executor {
	
	private final static Logger logger = Logger.getLogger(Executor.class);
	
	private final int batchSize = 1000; //Количество запросов для выполнения в batch 
	
	/**
	 * Выполнение одной операции INSERT\UPDATE\DELETE.
	 * 
	 * @param connection соединение с базой данных
	 * @param update скрипт для выполнения
	 */
    
	public void execUpdate(Connection connection, String update) throws SQLException {
	//public void execUpdate(String update) throws SQLException {
		logger.debug("execUpdate - Выполнение операции: \"" + update + "\"");
		Statement stmt = connection.createStatement();
		stmt.execute(update);
		stmt.close();
		logger.debug("execUpdate - Операция: \"" + update + "\" выполнена");
	}
	
	/**
	 * Выполнение пакета операций INSERT\UPDATE\DELETE.
	 * При возникновении ошибки в одном из скриптов, все выполненные до него скрипты отменяются
	 * 
	 * @param connection соединение с базой данных 
	 * @param updates массив скриптов для выполнения
	 */
    public void execUpdate(Connection connection, String[] updates) {
	//public void execUpdate(String[] updates) {
		logger.debug("execUpdate (batch) - Выполнение операций: \"" + Arrays.toString(updates) + "\"");
		boolean autocomit = true;
		try (Statement stmt = connection.createStatement()) {
			autocomit = connection.getAutoCommit();
			//TODO проверить что работает такое условие
			connection.setAutoCommit(false);
			int count = 0;
			for(String update: updates){
				stmt.addBatch(update);
				if(++count % batchSize == 0) {
					stmt.executeBatch();
					logger.debug("execUpdate (batch) - Операции выполнены по достижению лимита очереди на batch");
				}
			}
			stmt.executeBatch();
			logger.debug("execUpdate (batch) - Операции выполнены");
			connection.commit();
			logger.debug("execUpdate (batch) - Операции: \"" + Arrays.toString(updates) + "\" выполнены");
		} catch (SQLException e) {
			logger.error("execUpdate (batch) - Ошибка выполнения операций. Откат изменений.", e);
			try {
				connection.rollback();
			} catch (SQLException ignore) {}
		} finally {
			try {
				connection.setAutoCommit(autocomit);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Выполнение запроса и получение требуемого объекта
	 * 
	 * @param connection соединение с базой данных
	 * @param query запрос для выборки данных
	 * @param handler обработчик конвертации ResultSet данных в объект
	 * @return объект
	 * @throws SQLException ошибка при работе с базой данных
	 */
    //* @param connection соединение с бахой данных
	public <T> T execQuery(Connection connection, String query, ResultHandler<T> handler)
	//public <T> T execQuery(String query, ResultHandler<T> handler)
			throws SQLException {
		logger.debug("execQuery - Выполнение операции: \"" + query + "\"");
		Statement stmt = connection.createStatement();
		stmt.execute(query);
		ResultSet result = stmt.getResultSet();
		logger.debug("execQuery - Конвертация данных ResultSet в Java объект");
		T value = handler.handle(result);
		result.close();
		stmt.close();
		logger.debug("execQuery - Операция: \"" + query + "\" выполнена");
		return value;
	}

}