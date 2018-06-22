package com.koylubaevnt.database.datasets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Singleton класс, который читает настройки соединения из файла "database.properties"
 * и создает соединение с БД
 *  
 * @author KojlubaevNT
 *
 */
public class DBConfig {

	private final static Logger logger = Logger.getLogger(DBConfig.class);
	
	
	private Connection connection;

	public static DBConfig getInstance() {
		return DBConfigHelper.INSTANCE;
	}
	
	private static class DBConfigHelper {
		public static final DBConfig INSTANCE = new DBConfig();
	}
	
	/**
	 * Конструктор
	 */
	private DBConfig() {
		logger.debug("Начало вызова конструктора DBConfig");
		readPropertyFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties"));
		logger.debug("Конец вызова конструктора DBConfig");
	}
	
	/**
	 * Получение соединения с базой данных
	 * @return соединение с базой данных
	 */
	public Connection getConnection() {
		logger.debug("Получение соединения с базой данных");
		return connection;
	}
	
	/**
	 * Метод чтения файла свойств, использует
	 * 
	 * @param is входящий поток байт для получения данных
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void readPropertyFile(InputStream is) {
		logger.debug("Начало вызова метода readPropertyFile");
		try {
			Properties properties = new Properties();
			properties.load(is);
			String url = properties.getProperty("jdbc.url");
			String driver = properties.getProperty("jdbc.driver");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
			logger.debug("Считаны следующие свойства: [" +
					"url=\"" + url + "\", " + 
					"driver=\"" + driver +"\"," + 
					"username=\"" + username + "\"," + 
					"password=\"" + password +"\"]");
			
			logger.debug("Регистрация драйвера базы данных");
			DriverManager.registerDriver((Driver) Class.forName(driver).newInstance());
			logger.debug("Регистрация драйвера базы данных завершена. Инициализация соедниения с базой данных.");
			connection = DriverManager.getConnection(url, username, password);
		} catch (IOException | SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			logger.error("Ошибка при попытке получить настройки подключения к базе данных", e);
			connection = null;
		}
		logger.debug("Конец вызова метода readPropertyFile");
	}
	
	
}
