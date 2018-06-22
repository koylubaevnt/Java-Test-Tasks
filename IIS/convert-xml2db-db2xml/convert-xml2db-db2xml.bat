@echo off
chcp 1251
if .%1.==.. (
	set /p commd="Enter command (init - initialize DB, sync - synchronize DB, unload - unload from DB): "
	) ELSE ( 
	set commd=%1 
	)
if .%2.==.. (
  set /p filename="Enter XML filename: "
  ) ELSE (
  set filename=%2
  )
java -jar TestTask.jar %commd% %filename%
pause