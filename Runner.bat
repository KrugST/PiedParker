@ECHO OFF
::========================================
SET GITHUB_ACCOUNT=antisaga
SET WS_DIR=Workspace_github
SET REPO_NAME=PiedParker
SET APP_VERSION=1.0
SET MAIN_CLASS=core.listings
SET ARGS_01=
::========================================
::========================================
::SET GITHUB_ACCOUNT=%1
::SET WS_DIR=%2
::SET REPO_NAME=%3
::SET APP_VERSION=%4
::SET MAIN_CLASS=%5
::SET ARGS_01=%6
::========================================
IF "%JAVA_HOME%" == "" GOTO EXIT_JAVA
ECHO Java installed
IF "%M2%" == "" GOTO EXIT_MVN
ECHO Maven installed
CALL git --version > nul 2>&1
IF NOT %ERRORLEVEL% == 0 GOTO EXIT_GIT
ECHO Git installed

GOTO NEXT
:NEXT
IF NOT EXIST C:\%WS_DIR% MD C:\%WS_DIR%
IF EXIST C:\%WS_DIR%\%REPO_NAME% RMDIR /S /Q C:\%WS_DIR%\%REPO_NAME%
CD C:\%WS_DIR%
git clone https://github.com/%GITHUB_ACCOUNT%/%REPO_NAME%.git
CD %REPO_NAME%
call mvn clean package -Dvers=%APP_VERSION%
ECHO


IF NOT EXIST Test.csv GOTO NO_INPUT_FILE

ECHO Executing Java programm ...
java -jar C:\%WS_DIR%\%REPO_NAME%\target\%REPO_NAME%-%APP_VERSION%-jar-with-dependencies.jar %MAIN_CLASS% %ARG_01%

taskkill /im phantomjs.exe /f
GOTO END




:EXIT_JAVA
ECHO No Java installed
GOTO END
:EXIT_MVN
ECHO No Maven installed
GOTO END
:EXIT_GIT
ECHO No Git installed
GOTO END
:NO_WORKSPACE
ECHO %WS_DIR% is not exists
GOTO END
:NO_INPUT_FILE
ECHO iNPUT File "Test.csv" is not exists
GOTO END
:END
CD\