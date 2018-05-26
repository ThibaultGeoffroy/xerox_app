SET ANTPATH="C:\Apache\apache-ant-1.9.4\bin"
SET JAVAPATH="C:\Program Files\Java\jdk1.8.0_60\bin"
REM SET PARAM1="C:\Workspaces_EIP_SVN_VS2015\EIP SDK"
SET AXIS=C:\axis2-1.7.2\bin\
SET TOMCAT=C:\Tomcat

REM cd  %ANTPATH%
SET path=%JAVAPATH%
SET AXIS2_HOME=%AXIS%
SET CATALINA_HOME=%TOMCAT%

ECHO "Generation of War file for DemoApp"
ECHO %~dp0
call %ANTPATH%\ant -buildfile "%~dp0\"build.xml
REM %PARAM1%\JavaSDKSamples\Axis2_Utilities\DemoApp

REM cd "C:\Workspaces_EIP_SVN_40\JavaSDKSamples\Axis2_Utilities\DemoApp"