@echo off

rem %~2 %~1 >runbat_%date:~-4,4%%date:~-10,2%%date:~-7,2%_%time:~0,2%%time:~3,2%%time:~6,2%.log 2>&1

echo %date:~-4,4%%date:~-10,2%%date:~-7,2%_%time:~0,2%%time:~3,2%%time:~6,2% >> runbat.log
%~2 %~1 >> runbat.log 2>&1

echo %ERRORLEVEL%