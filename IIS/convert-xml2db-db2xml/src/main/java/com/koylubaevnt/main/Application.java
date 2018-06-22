/**
 * 
 */
package com.koylubaevnt.main;

import org.apache.log4j.Logger;

/**
 * Класс для запуска приложения <code>TestTask</code>
 * 
 * @author KojlubaevNT
 *
 */
public class Application {

	private final static Logger logger = Logger.getLogger(Application.class);
	
	/**
	 * Главная точка входа в приложение
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
        logger.info("Начало работы программы");
		if (args.length != 2) {
			logger.info("Ошибка в командной строке.\n"
					+ "Для правильной работы необходимо передать 2 аргумента в качестве командной строки: "
					+ "\"операция имя_XML_файла\", где \n" 
					+ "операция: init|sync|unload (init - создание базы данных, sync - синхронизация данных в БД исопльзуя XML файл, unload - выгрузка данных из БД в XML файл)\n"
					+ "имя_XML_файла: имя файла используемого для инициализации базы данных, синхронизации с БД или выгрузки из БД");
			return;
		}
		Operation operation = Operation.valueOf(args[0].toUpperCase());
		String fileName = args[1];
		
		ProcessData.process(operation, fileName);
		logger.info("Конец работы программы");
	}

}
