@echo off
powershell.exe -NoLogo -NoProfile -ExecutionPolicy Bypass -File "%~dp0.mvn\wrapper\mvnw.ps1" %*
exit /b %ERRORLEVEL%
