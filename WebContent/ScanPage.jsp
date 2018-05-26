<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scan Page</title>

<script src="/XeroxJavascriptLibrary/XRXWebservices.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXXmlHandler.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXSession.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXScan.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXUtilities.js" type="text/javascript"></script>
	
	<!-- Application Specific Javascript Files -->
	<script src="JS/Globals.js" type="text/javascript"></script>
	<script src="JS/Popup.js" type="text/javascript"></script>
	<script src="JS/DemoHelper.js" type="text/javascript"></script>
	
	<!-- Page Size Specific CSS File -->
	<script language="JavaScript" type="text/javascript">
	    document.write("<link href=\"CSS/" + getPageStyle() + "\" type=\"text/css\" rel=\"stylesheet\" />");
	</script>
	
	<!-- Xerox Widgets -->
	<link href="http://127.0.0.1/xrx_widgets/XRXWidgets.css" type="text/css" rel="stylesheet" />
	<script src="http://127.0.0.1/xrx_widgets/XRXWidgets.js" type="text/javascript"></script>
	
	<!-- Page Javascript -->
	<script language="JavaScript" type="text/javascript">

/****************************************  Globals  ****************************************************/

		var toggle = 0;
		var image;
			
/****************************************  Initialize  *************************************************/
		
		/**
		* Page load function. Load widgets. Start wait graphic. Start scan.
		*/
		function init()
		{
	//alert("inside Scanpage.jsp");
			writeSR1(getDemoAppVersion());
			xrx_load_widgets();

			document.getElementById( 'Community' ).value = COMMUNITY;
			writeSR3( "User: " + document.getElementById( 'Username' ).value );

			setTimeout( "wait()", 600000);
			
			set_display("WaitGraphic", "block");
			
			//document.getElementById( 'ScanLocation' ).value = document.getElementById( 'ScanLocation' ).value;
			//document.getElementById( 'RepositoryVolume' ).value = document.getElementById( 'RepositoryVolume' ).value;
			//document.getElementById( 'ServerLogin' ).value = document.getElementById( 'ServerLogin' ).value;
			//alert("Screensize inside scanpage.jsp "+document.getElementById( 'ScreenSize').value );
			document.getElementById("ScreenSize").innerHTML = document.getElementById( 'ScreenSize').value ;
			xrxScanInitiateScan( "http://127.0.0.1", "DemoTemplate_Test.xst", false, 
								scan_callback_success, scan_callback_failure );
			//alert("after initiatescan Scanpage.jsp")
			//alert("eipversion on scanpage.jsp"+document.getElementById( 'EipVersion').innerHTML);
			//set_display("WaitGraphic", "block");
		}
		
		/**
		* Scan completed. Parse response and get job ID. Store and start code behind
		*/
		function scan_callback_success( envelope, response )
		{
			//set_display("WaitGraphic", "block");
			var jobID = xrxScanParseInitiateScan( response );
			document.getElementById( 'titlepane' ).innerHTML = 
					"Scan JobID is " + jobID + ". Now filing ... ";
			document.getElementById( 'JobID' ).value = jobID;
		  //  alert("jobID = "+ jobID);
		    document.forms[0].submit();
			
		}
		
		/**
		* Scan failed. Inform user and return to Main page.
		*
		* @param request	request envelope of webservice call
		* @param response	webservice response in string form
		* @param status		http status code
		*/
		function scan_callback_failure( request, response, status )
		{
			//alert("inside failure");
		    if (status == "409")
		    {
		        alert("Please check if the FTPClient is enabled via the WebUI.");
		    }
		    
			popupOk( "Initate Scan Failed:\n" + response, gotoMainPage );
		}
		
		/**
		* Start wait graphic and animate it through setTimeout().
		*/
		function wait()
		{
			//alert("inside wait method");
			toggle = ((toggle + 1) % 3);
			//alert("inside wait method src toggle "+toggle);
			//alert("inside wait method src "+myImages[toggle].src);
			document.getElementById( 'WaitGraphic' ).setAttribute( 'src', myImages[toggle].src );
			setTimeout( "wait()", 600 );
			//alert("outside wait method");
		}	

		 function Exit()
		    {
		    	xrxSessionExitApplication('http://127.0.0.1', null);
		    }
		    
		 function set_display(id, displayVal) 
		    {
    			var v1 = document.getElementById(id);
   				v1.style.display = displayVal;
			}
		    
	</script>
</head>
<body>
	<form name="ScanPage" method="post" action="ScanPage">
		<div class="xrx:StatusRegionPanel" id="xrx:StatusRegionPanel">
			<div class="xrx:StatusRegionSR1" id="xrx:StatusRegionSR1">
				<script>document.write("EIP Demo Scan Application (" + document.getElementById( 'EipVersion').innerHTML + ")");</script>
			</div>
			<div class="xrx:StatusRegionSR2" id="xrx:StatusRegionSR2">
				<script>document.write("Scan Page (using Webservices Library " 
						+ xrxGetXRXWebservicesVersion() + ")");</script>
			</div> 
			<div class="xrx:StatusRegionSR3" id="xrx:StatusRegionSR3"></div>
		</div>
		<div class="xrx:StatusRegionHR1" id="xrx:StatusRegionHR1"></div>
		<div class="xrx:StatusRegionHR2" id="xrx:StatusRegionHR2"></div>
		<div class="xrx:ToolBarPanel" style="TEXT-ALIGN:left" id="xrx:ToolBarPanel">
			<div class="xrx:ToolBarTextLine1" id="xrx:ToolBarTextLine1" style="WIDTH:340px"></div>
			<div class="xrx:ToolBarTextLine2" id="xrx:ToolBarTextLine2" style="WIDTH:340px"></div>
			<div class="xrx:ToolBarTextLine3" id="xrx:ToolBarTextLine3"></div>
			<div class="btnAlign">
				<div class="ExitButton" style="float:right; padding:5px 5px 0 0;">
					<input type="button" class="xrx:command" imgsize="90x38" value="Exit"  onclick="Exit();" />
				</div>
				<div style="clear:both;">
			</div>
			</div>
		</div>
		<div class="xrx:ToolBarHR1" id="xrx:ToolBarHR1"></div>
		<div class="xrx:ToolBarHR2" id="xrx:ToolBarHR2"></div>
		<div class="xrx:ProgramAreaPanel" id="xrx:ProgramAreaPanel">
			<div class="titlepane" id="titlepane">Scanning ...</div>
			<div class="WaitGraphic">
					<img id="WaitGraphic" src="Images/scan_animation.gif" height="98" width="72" alt="Wait" />
			</div>
			 
			
			<div class="fullpane" id="fullpane">
				
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
			<textarea id="ServerLogin" name="ServerLogin" style="VISIBILITY:hidden" >${ServerLogin}</textarea>
			<textarea id="ScanLocation" name="ScanLocation" style="VISIBILITY:hidden" >${ScanLocation}</textarea>
			<textarea id="Community" name="Community" style="VISIBILITY:hidden" >${Community}</textarea>
			<textarea id="RepositoryVolume" name="RepositoryVolume" style="VISIBILITY:hidden" >${RepositoryVolume}</textarea>
			<textarea id="RepositoryFiles" name="RepositoryFiles" style="VISIBILITY:hidden" >${RepositoryFiles}</textarea>
			<textarea ID="ClientIP" name="ClientIP" style="visibility:hidden" >${ClientIP}</textarea>
			<textarea ID="FTPServerIPAddress" name="FTPServerIPAddress" style="visibility:hidden" >${FTPServerIPAddress}</textarea>
			<textarea ID="SMBServerIPAddres" name="SMBServerIPAddres" style="visibility:hidden" >${SMBServerIPAddres}</textarea>
			<textarea name="SelectedProtocol" id="SelectedProtocol" style="VISIBILITY:hidden">${SelectedProtocol}</textarea>
			<textarea id="DocName" name="DocName" style="VISIBILITY:hidden" >${DocName}</textarea>		
			<input type="button" id="subimit" imgsize="90x38" value="Next"  style="VISIBILITY: hidden"/>
			<!-- 
			<input type="button" id="ASPButton" imgsize="90x38" value="Next"  style="VISIBILITY: hidden"
						 onmousedown="Next_Click()" />
			<input type="button" id="ASPMainPage" imgsize="90x38" value="Next"  style="VISIBILITY: hidden"
						 onmousedown="Next_Click()" /> 
			 -->		
		</div>
		<!--
		<div class="popup" id="ScanAnimation" style="display:none;">
          <img src="Images/scan_animation.gif" height="100" width="152"/>
          <div id="StatusMessage"></div>
        </div>
        -->
	</form>
	<script>window.onload=init()</script>
  </body>
</html>