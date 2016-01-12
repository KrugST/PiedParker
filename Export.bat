@ECHO OFF
::========================================
SET GITHUB_ACCOUNT=antisaga
SET REPO_NAME=PiedParker
SET APP_VERSION=1.0
SET MAIN_CLASS=core.listings
::========================================
git init 
git add .
git commit -m "%DATE%___%COMPUTERNAME%___%USERNAME%___%OS%"
git remote add origin https://github.com/%GITHUB_ACCOUNT%/%REPO_NAME%.git
sleep 2
git remote show origin
sleep 2
git push -u origin master
pause
