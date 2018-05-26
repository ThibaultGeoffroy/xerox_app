<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Xerox Javascript Webservices Library -->

<!--	<script src="JS/XRXXmlHandler.js" type="text/javascript"></script>-->
	<!-- <script src="JS/XRXScan.js" type="text/javascript"></script> -->
	<script src="/XeroxJavascriptLibrary/XRXSession.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXWebservices.js" type="text/javascript"></script>
	  
	<!-- Application Specific Javascript Files -->
	<script src="JS/Globals.js" type="text/javascript"></script>
	<script src="JS/Popup.js" type="text/javascript"></script>
	<script src="JS/DemoHelper.js" type="text/javascript"></script>

	<!-- Page Size Specific CSS File -->	  
	<script language="JavaScript" type="text/javascript" >

	    document.write("<link href=\"CSS/" + getPageStyle() + "\" type=\"text/css\" rel=\"stylesheet\" />");

	</script>
	
	<!-- Contains the xerox backgrounds -->
    <link href="http://127.0.0.1/xrx_widgets/XRXWidgets.css" rel="stylesheet" type="text/css" />
      
    <!-- contains the functions that make up the Xerox Widgets -->
    <script src="http://127.0.0.1/xrx_widgets/XRXWidgets.js" type="text/javascript"></script>
    <!-- Page Javascript -->
	<script language="JavaScript" type="text/javascript">
		function validKeys( ch )
		{
			return((ch == '(') || (ch == ')') || (ch == '-') || (ch == '.') || ((ch >= '0') && (ch <= '9')) || 
					(ch == ' ') || ((ch >= 'A') && (ch <= 'Z')) || (ch == '_') || ((ch >= 'a') && (ch <= '~')));
		}
		function Next()
		{
			//alert("Inside AppServerDetails.jsp =" + getScreenSize());
			document.getElementById("ScreenSize").innerHTML = getScreenSize();
			//document.mainform.submit();
		//	alert("before submit");
			document.forms[0].submit();
		}
		function Exit()
		{
		    	xrxSessionExitApplication('http://127.0.0.1', null);
		}	
		function init()
		{
	        xrx_load_widgets();
			writeSR3( "User: " + document.getElementById( 'Username' ).value );
			//document.getElementById( 'ServerLogin' ).value = SERVER_LOGIN;
			document.getElementById( 'ServerAddress' ).value = PARENT_LOC;
			//alert("server address at ftp "+document.getElementById( 'ServerAddress' ));
			//document.getElementById( 'ScanLocation' ).value = SCAN_LOCATION;
			//document.getElementById( 'RepositoryVolume' ).value = REPOSITORY_VOLUME;
			document.getElementById( 'Community' ).value = COMMUNITY;
			//alert("Inside AppServerDetails.jsp");
			document.mainform.submit();			
		}
	</script>
	<!-- 
	<style>
	   .marlft
	   {
	       margin-left:50px;
	   } 
	   .width
	   {
	       width:300px;
	   }
	</style>
	 -->
</head>
<body>
   <form name="FTPApplicationServerDetails" action="FTPAppServerDetails" method="post">
     <!-- xrx:StatusRegionPanel -->
		<div class="xrx:StatusRegionPanel" id="xrx:StatusRegionPanel">
			<div class="xrx:StatusRegionSR1" id="xrx:StatusRegionSR1">
				<script>document.write("EIP Demo Scan Application (" + document.getElementById( 'EipVersion').innerHTML + ")");</script>
			</div>
			<div class="xrx:StatusRegionSR2" id="xrx:StatusRegionSR2"></div> 
			<div class="xrx:StatusRegionSR3" id="xrx:StatusRegionSR3"></div>
		</div>
		<!-- End of xrx:StatusRegionPanel -->
		
		<!-- xrx:StatusRegionHR  -->
		<div class="xrx:StatusRegionHR1" id="xrx:StatusRegionHR1"></div>
		<div class="xrx:StatusRegionHR2" id="xrx:StatusRegionHR2"></div>
		<!-- End of xrx:StatusRegionHR  -->
		
		<!-- xrx:ToolBarPanel -->
		<div class="xrx:ToolBarPanel" style="TEXT-ALIGN:left" id="xrx:ToolBarPanel">
			<div class="xrx:ToolBarTextLine1" id="xrx:ToolBarTextLine1"></div>
			<div class="xrx:ToolBarTextLine2" id="xrx:ToolBarTextLine2"></div>
			<div class="xrx:ToolBarTextLine3" id="xrx:ToolBarTextLine3"></div>
			<div class="btnAlign">
				<div class="ExitButton" style="float:right; padding:5px 5px 0 0;">
				     <input type="button" class="xrx:command" imgsize="90x38" value="Exit"  onclick="Exit();" />
		        </div>
	           	 <div class="NextButton" style="float:right; padding:5px 5px 0 0;">
				     <input type="submit" class="xrx:command" imgsize="90x38" value="Start" onclick="Next();" />
		       	 </div>
		        <div style="clear:both;">
	            </div>
		   </div>
		</div>
		<!-- End of xrx:ToolBarPanel -->
		
		<!-- xrx:ToolBarHR -->
		<div class="xrx:ToolBarHR1" id="xrx:ToolBarHR1"></div>
		<div class="xrx:ToolBarHR2" id="xrx:ToolBarHR2"></div>
		<!-- End of xrx:ToolBarHR -->
		
		<!-- xrx:ProgramAreaPanel -->
		<div class="xrx:ProgramAreaPanel" id="xrx:ProgramAreaPanel">
			<div style="margin:10px 0 10px 10px;"  class="titleBox">
				<div class="titlepane" id="titlepane" style="color:white;"> FTP Server Information</div>	
			</div>	
	    	<div class="formDesign fourthPage" id="fullpane" style="margin:10px 0px 0 10px; clear:both;">
	    	<div class="floatLeft clear btmSpace">
				<div class="box">
				    <label id="FTPApplblServerIpAddr">FTP Server IP:</label>     
				    <input type="text" id="FTPAppServerIpAddr" name="FTPAppServerIpAddr" class="xrx:keyboardtext" onenter="validKeys"/>
			    </div>
			   	<div class="box"><br>
				    <label id="FTPApplblServerDomName">Domain Name:</label>     
				    <input type="text" id="FTPAppServerDomainName" name="FTPAppServerDomainName" class="xrx:keyboardtext" onenter="validKeys"/>
			    </div>
			   	<div class="box"><br>
				    <label id="FTPApplblServerUsrName">User Name:</label>   
				    <input type="text" id="FTPAppServerUserName" name="FTPAppServerUserName" class="xrx:keyboardtext" onenter="validKeys"/>
			    </div>
			    </div>
			     <div class="floatRight topSpace">
			   	<div class="box">
				    <label id="FTPApplblServerPwd">Password:</label>   
				    <input type="password" id="FTPAppServerPassword" name="FTPAppServerPassword" class="xrx:keyboardtext" onenter="validKeys"/>
				</div>
			    <div class="box"><br>
				    <label id="FTPApplblServerSubShrFol">Document Path:</label>  
				    <input type="text" id="FTPAppServerSubSharFol" name="FTPAppServerSubSharFol" class="xrx:keyboardtext" onenter="validKeys"/>
			    </div>
			    </div>
        </div>
    		<textarea id="Username" name="Username" style="VISIBILITY:hidden" >${Username}</textarea>
			<textarea id="Password" name="Password" style="VISIBILITY:hidden" >${Password}</textarea>
			<textarea id="DeviceModel" name="DeviceModel" style="VISIBILITY:hidden" >${DeviceModel}</textarea>
			<textarea ID="EipVersion" name="EipVersion" style="VISIBILITY:hidden" >${EipVersion}</textarea>
			<textarea id="Color" name="Color" style="VISIBILITY:hidden" >${Color}</textarea>
			<textarea id="Destination" name="Destination" style="VISIBILITY:hidden" >${Destination}</textarea>
			<textarea id="DocumentType" name="DocumentType" style="VISIBILITY:hidden" >${DocumentType}</textarea>
			<textarea id="ColorOptions" name="ColorOptions" style="VISIBILITY:hidden" >${ColorOptions}</textarea>
			<textarea id="Orientation" name="Orientation" style="VISIBILITY:hidden" >${Orientation}</textarea>
			<textarea id="PageSides" name="PageSides" style="VISIBILITY:hidden" >${PageSides}</textarea>
			<textarea id="PrintOptions" name="PrintOptions" style="VISIBILITY:hidden" >${PrintOptions}</textarea>
			<textarea name="ScreenSize" id="ScreenSize" style="VISIBILITY:hidden">${ScreenSize}</textarea>
			<textarea id="JobID" name="JobID" style="VISIBILITY:hidden" >${JobID}</textarea>
			<textarea id="DocName" name="DocName" style="VISIBILITY:hidden" >${DocName}</textarea>
			<textarea id="ServerAddress" name="ServerAddress" style="VISIBILITY:hidden" >${ServerAddress}</textarea>
			<!-- <textarea id="ServerLogin" name="ServerLogin" style="VISIBILITY:hidden" >${ServerLogin}</textarea> -->
			<!-- <textarea id="ScanLocation" name="ScanLocation" style="VISIBILITY:hidden" >${ScanLocation}</textarea>-->
			<textarea id="Community" name="Community" style="VISIBILITY:hidden" >${Community}</textarea>
			<!--<textarea id="RepositoryVolume" name="RepositoryVolume" style="VISIBILITY:hidden" >${RepositoryVolume}</textarea> -->
			<textarea id="RepositoryFiles" name="RepositoryFiles" style="VISIBILITY:hidden" >${RepositoryFiles}</textarea>
			<textarea ID="ClientIP" name="ClientIP" style="visibility:hidden" >${ClientIP}</textarea>  
			<textarea name="SelectedProtocol" id="SelectedProtocol" style="VISIBILITY:hidden">${SelectedProtocol}</textarea>
	</div>
			<!-- End of xrx:ProgramAreaPanel -->
			</form>
						
	<script>window.onload=init();</script>  
</body>
</html>