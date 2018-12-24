@echo   off 
 cd D:\ProgramData\Openoffice\program
 soffice -headless -accept=socket,host=127.0.0.1,port=8100;urp; -nofirststartwizard
 @echo   on 