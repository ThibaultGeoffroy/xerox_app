<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Scan Page</title>
<!-- Xerox Webservices Javascript Library -->
	<script src="/XeroxJavascriptLibrary/XRXWebservices.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXXmlHandler.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXSession.js" type="text/javascript"></script>
	
	<!-- Application Specific Javascript Files -->
	<script src="JS/Globals.js" type="text/javascript"></script>
	<script src="JS/Popup.js" type="text/javascript"></script>
	<script src="JS/DemoHelper.js" type="text/javascript"></script>
	
	<!-- Page Size Specific CSS File -->
	<script language="JavaScript" type="text/javascript">
	    document.write("<link href=\"" + getPageStyle() + "\" type=\"text/css\" rel=\"stylesheet\" />");
	</script>
	
	<!-- Xerox Widgets -->
	<link href="http://127.0.0.1/xrx_widgets/XRXWidgets.css" type="text/css" rel="stylesheet" />
	<script src="http://127.0.0.1/xrx_widgets/XRXWidgets.js" type="text/javascript"></script>
	<!--Page Size Specific CSS File
	<link href="CSS/HalfPageStyle.css" type="text/css" rel="stylesheet" />--> 
	
	<!-- Page Javascript -->
	<script language="JavaScript" type="text/javascript">

/****************************************  Globals  ****************************************************/

			
/****************************************  Initialize  *************************************************/
		
		/**
		* Page load function. Load widgets. Store needed info. 
		*/
		
		function init()
		{//alert(document.getElementById( 'PrintOptions' ).value);
		 //document.getElementById('ScanPrint').style.display = 'none'; 
			if(document.getElementById( 'PrintOptions' ).value =="Scan and Print")
				{
				 document.getElementById('ScanPrint').style.display = 'inline'; 
				 document.getElementById( 'SelectedProtocol').value = document.forms[0].ProtocolSelections2.value;
				// alert(document.forms[0].ProtocolSelections2.value);
				 
				}
			else
				{
				//alert("Scan");
				 document.getElementById('Scan').style.display='inline';
				 document.getElementById('ScanPrint').style.display="none";
				 document.getElementById( 'SelectedProtocol').value = document.forms[0].ProtocolSelections1.value;
			//	 alert(document.forms[0].ProtocolSelections1.value);
				}
						
			writeSR1(getDemoAppVersion());
	        xrx_load_widgets();
			writeSR3( "User: " + document.getElementById( 'Username' ).value );
			//document.getElementById( 'ServerLogin' ).value = SERVER_LOGIN;
			document.getElementById( 'ServerAddress' ).value = PARENT_LOC;
			//document.getElementById( 'ScanLocation' ).value = SCAN_LOCATION;
			//document.getElementById( 'RepositoryVolume' ).value = REPOSITORY_VOLUME;
			document.getElementById( 'Community' ).value = COMMUNITY;	
			//if(document.forms[0].ProtocolSelections.)
			//document.getElementById( 'SelectedProtocol' ).value = document.forms[0].ProtocolSelections.value;
			//alert("eipversion on startscanpage.jsp"+document.getElementById( 'EipVersion').innerHTML);
		}
		
/**************************************  Command functions  *********************************************/
	
		/**
		* If key event is the Start button, start scan otherwise ignore.
		*
		* @param e	event
		*/
		function checkKey( e )
		{
			if(e.which == 4098) startScan();
		}
		
		/**
		* Function for soft keyboard to enable only keys for a valid filename.
		*
		* @param ch	key in question
		* @return boolean	true if valid
		*/
		function validKeys( ch )
		{
			return((ch == '(') || (ch == ')') || (ch == '-') || (ch == '.') || ((ch >= '0') && (ch <= '9')) || 
					(ch == ' ') || ((ch >= 'A') && (ch <= 'Z')) || (ch == '_') || ((ch >= 'a') && (ch <= '~')));
		}
		
		/**
		* Goto to next page. 
		*/
		function startScan()
		{
			document.getElementById("DocName").value = document.forms[0].docNameText.value;
			document.getElementById("ScreenSize").innerHTML = getScreenSize();
			document.getElementById("Mode").value = "Next";
			document.mainform.submit();
		}
		
		/**
		* Goto to Main page. 
		*/
		function cancel()
		{
			document.getElementById("DocName").value = document.forms[0].docNameText.value;
			document.getElementById("ScreenSize").innerHTML = getScreenSize();
			document.getElementById("Mode").value = "Cancel";
			document.mainform.submit();
		}
		
		function Exit()
		{
		    	xrxSessionExitApplication('http://127.0.0.1', null);
		}
		 
		function  protocolSelect()
		{
			//document.getElementById( 'SelectedProtocol' ).value = document.forms[0].ProtocolSelections.value;
			if(document.getElementById( 'PrintOptions' ).value =="Scan and Print")
				{
				 document.getElementById( 'SelectedProtocol').value = document.forms[0].ProtocolSelections2.value;
				}
			else
				{
				 document.getElementById( 'SelectedProtocol').value = document.forms[0].ProtocolSelections1.value;
				}
			
			//alert(document.getElementById( 'SelectedProtocol').value);
		}
		
		
	</script>
	<style type="text/css">
	.titlepane h1 { font-size:18px; color:#FFFFFF;}
	</style>
	
<!-- *************************************  HTML  ********************************************* -->
</head>
<body>
	<form name="mainform" action="StartScanPage" method="get">
     	<!-- xrx:StatusRegionPanel --> 
		<div class="xrx:StatusRegionPanel" id="xrx:StatusRegionPanel">
			<div class="xrx:StatusRegionSR1" id="xrx:StatusRegionSR1">
				<script>document.write("EIP Demo Scan Application (" + document.getElementById( 'EipVersion').innerHTML + ")");</script>
			</div>
			<div class="xrx:StatusRegionSR2" id="xrx:StatusRegionSR2">Ready to Scan Page </div>  
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
				<div class="CancelButton" style="float:right; padding:5px 5px 0 0;">
					<input type="button" class="xrx:command" imgsize="90x38" value="Cancel" onclick="cancel()" />
				</div>
				<div class="NextButton" style="float:right; padding:5px 5px 0 0;">
					<input type="submit" class="xrx:command" imgsize="90x38" value="Next" onclick="startScan()" />
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
		<div class="xrx:ProgramAreaPanel" id="xrx:ProgramAreaPanel" >
			<div style="margin:10px 0 10px 10px;"  class="titleBox">
				<div class="titlepane" id="titlepane" style="color:white;"> Place Your Document in the Document Handler and Press the Start Button</div>	
			</div>	
			
			<div class="fullpane" id="fullpane" style="margin:10px 0px 0 10px;">
				<div class="docNameLabel startscanpage">
				Enter a Document Name (Optional) :   
				  	<input type="text" id="docNameText" name="docNameText" class="xrx:keyboardtext" onenter="validKeys" value="default" size="30">
				</div>			
				<div class="Protocolsection startscanpage" style="margin:-10px 0 0 0;">
					<div style="margin:0 0 5px 0;"><b>Select protocol for scanning :</b></div>
				  	<div class="ProtocolSelections" id="ScanPrint" style="display:none;">
						<select class="xrx:radio" name="ProtocolSelections2" id="ProtocolSelections2" onChange="protocolSelect()">
							<option selected="selected">SMB</option>
							<option disabled="disabled">FTP</option>
						</select>
					</div>
					<div class="ProtocolSelections" id="Scan" style="display:none;">
						<select class="xrx:radio" name="ProtocolSelections1" id="ProtocolSelections1" onChange="protocolSelect()">
							<option selected="selected">SMB</option>
							<option >FTP</option>
						</select>
					</div>
			 	</div>
			</div>		
		
			<textarea name="Username" id="Username" style="VISIBILITY:hidden">${Username}</textarea>
			<textarea name="DeviceModel" id="DeviceModel" style="VISIBILITY:hidden">${DeviceModel}</textarea>
			<textarea name="Color" id="Color" style="VISIBILITY:hidden">${Color}</textarea>
			<textarea name="EipVersion" id="EipVersion" style="VISIBILITY:hidden">${EipVersion}</textarea>
			<textarea name="Destination" id="Destination" style="VISIBILITY:hidden">${Destination}</textarea>
			<textarea name="DocumentType" id="DocumentType" style="VISIBILITY:hidden">${DocumentType}</textarea>
			<textarea name="ColorOptions" id="ColorOptions" style="VISIBILITY:hidden">${ColorOptions}</textarea>
			<textarea name="Orientation" id="Orientation" style="VISIBILITY:hidden">${Orientation}</textarea>
			<textarea name="PageSides" id="PageSides" style="VISIBILITY:hidden">${PageSides}</textarea>
			<textarea name="PrintOptions" id="PrintOptions" style="VISIBILITY:hidden">${PrintOptions}</textarea>
			<textarea name="SelectedProtocol" id="SelectedProtocol" style="VISIBILITY:hidden">${SelectedProtocol}</textarea>
			<textarea name="ScreenSize" id="ScreenSize" style="VISIBILITY:hidden">${ScreenSize}</textarea>
			<!--
			<textarea id="Username" name="Username" style="VISIBILITY:hidden" >${Username}&nbsp;</textarea>
			<textarea id="Password" name="Password" style="VISIBILITY:hidden" >${Password}&nbsp;</textarea>
			<textarea id="DeviceModel" name="DeviceModel" style="VISIBILITY:hidden" >${DeviceModel}&nbsp;</textarea>
			<textarea ID="EipVersion" name="EipVersion" style="VISIBILITY:hidden" >${EipVersion}&nbsp;</textarea>
			<textarea id="Color" name="Color" style="VISIBILITY:hidden" >${Color}&nbsp;</textarea>
			<textarea id="Destination" name="Destination" style="VISIBILITY:hidden" >${Destination}&nbsp;</textarea>
			<textarea id="DocumentType" name="DocumentType" style="VISIBILITY:hidden" >${DocumentType}&nbsp;</textarea>
			<textarea id="ColorOptions" name="ColorOptions" style="VISIBILITY:hidden" >${ColorOptions}&nbsp;</textarea>
			<textarea id="Orientation" name="Orientation" style="VISIBILITY:hidden" >${Orientation}&nbsp;</textarea>
			<textarea id="PageSides" name="PageSides" style="VISIBILITY:hidden" >${PageSides}&nbsp;</textarea>
			<textarea id="PrintOptions" name="PrintOptions" style="VISIBILITY:hidden" >${PrintOptions}&nbsp;</textarea>
			-->
			<textarea id="JobID" name="JobID" style="VISIBILITY:hidden" >${JobID}</textarea>
			<textarea id="DocName" name="DocName" style="VISIBILITY:hidden" >${DocName}</textarea>
			<textarea id="ServerAddress" name="ServerAddress" style="VISIBILITY:hidden" >${ServerAddress}</textarea>
			<textarea id="Community" name="Community" style="VISIBILITY:hidden" >${Community}</textarea>
			<textarea id="Mode" name="Mode" style="VISIBILITY:hidden" >${Mode}</textarea>
			<input type="button" id="ASPButton" value="Next"  style="VISIBILITY: hidden"
						 onclick="Next_Click()" />
			<input type="button" id="ASPMainPage" value="Next"  style="VISIBILITY: hidden"
						 onclick="ASPMainPageButton_Click()" />
		</div>
		<!-- End of xrx:ProgramAreaPanel -->
	</form>
	<script>window.onload=init</script>
</body>
</html>