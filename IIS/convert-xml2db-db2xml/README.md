# convert-xml2db-db2xml
Test Task for job offer (Convert XML to DB and DB to XML) [19.12.2016]

Приложение позволяющее:

1. выгружать содержимое таблицы БД в XML файл;
2. синхронизировать содержимое таблицы БД по заданному XML файлу.
3. инициалиировать БД

Для запуска приложения можно использовать bat файл: convert-xml2db-db2xml.bat.

- Перед запуском необходимо сделать настройки в файлах свойств (логирование, подключение к БД).
- Далее можно выполнить скрипт по созданию БД и наполнению данными, либо запустить приложение с "ОПЕРАЦИЕЙ" = init и "ИМЯ\_XML\_ФАЙЛА"=init.xml.
- После можно проводить тестирование выгузки  и синхронизации.

В него необходимо передать 2 обязательных аргумента: **"ОПЕРАЦИЯ" "ИМЯ\_XML\_ФАЙЛА"**.

1. **"ОПЕРАЦИЯ"** может быть одной из следующих: *init* | *sync* | *unload*.

  1. init - создание базы данных. ВНИМАНИЕ! при запуске данного пункта все данные по таблице "Штатное расписание" будут утеряны безвозвратно;
  2. sync - синхронизация содержимое таблицы БД по заданному XML файлу, 
  3. unload - выгрузка содержимое таблицы БД в XML файл)
  
2. **"ИМЯ\_XML\_ФАЙЛА"** - имя XML файла, который будет исопльзоватьсядля инициализации базы данных, синхронизации данных или выгрузки данных

---
Примечания:

* В текущем проекте была выбрана БД: SQLite, т.к. она легковесная, переносимая и объем данных для данного пиложения небольшой. Настройки для подключения считываются из файла "database.properties", лежащего в корне с JAR файлом. Скрипт создания базы данных и наполнения данными прилагается: DBSQLite.sql
* Для создания и чтения XML файла используется технология DOM. Данный файл представляет из себя список узлов, где в качестве аттрибутов к узлу указаны данные для "Штатная структура".
* Для логирования используется log4j, настройки для которого задаются файлом log4j.properties (путь к которому можно указать через -Dlog4j.configuration)
* В данном проекте добавлено слишком много информации по логированию (info, debug), по идее которую можно было не добавлять... При стандартной настройке на консоль выводится информация с приортетом не выше INFO, в файл - DEBUG.

***Приложение использует особенности Java8 (Streams, FunctionalInterface), поэтому его надо запускать на VM поддерживающую Java8***
