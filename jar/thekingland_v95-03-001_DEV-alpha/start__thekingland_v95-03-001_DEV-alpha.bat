@ECHO OFF
title thekingland_v95-03-001_DEV-alpha
@ECHO Starting a script of loading application.
@ECHO Loading file 'thekingland_v95-03-001_DEV-alpha.jar'
@ECHO Processing order 'java'...
@ECHO _
@ECHO _
java -Xms512M -Xmx512M -jar thekingland_v95-03-001_DEV-alpha.jar -o true
set /p odp="$_SYSTEM> "
exit