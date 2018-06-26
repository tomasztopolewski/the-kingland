@ECHO OFF
title thekingland_v91-00-000_DEV_alpha
@ECHO Starting a script of loading application.
@ECHO Loading file 'thekingland_v91-00-000_DEV_alpha.jar'
@ECHO Processing order 'java'...
@ECHO _
@ECHO _
java -Xms512M -Xmx512M -jar thekingland_v91-00-000_DEV_alpha.jar -o true
set /p odp="$_SYSTEM> "
exit