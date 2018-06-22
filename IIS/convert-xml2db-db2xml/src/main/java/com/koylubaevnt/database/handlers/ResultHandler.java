package com.koylubaevnt.database.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Функциональный интерфейс для обработки результата полученного запросом
 * 
 * @author KojlubaevNT
 *
 * @param <T> - Тип DataSet'а, который будет получен после обработки запроса 
 */
@FunctionalInterface
public interface ResultHandler<T> {
	
	/**
	 * Обработчик результата выборки
	 * 
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	T handle(ResultSet resultSet) throws SQLException;
}