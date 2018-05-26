<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.lang.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo Page</title>
<!-- Xerox Javascript Webservices Library -->

	<script src="/XeroxJavascriptLibrary/XRXXmlHandler.js" type="text/javascript"></script>
	<!-- <script src="JS/XRXScan.js" type="text/javascript"></script> -->
	<script src="/XeroxJavascriptLibrary/XRXSession.js" type="text/javascript"></script>
	
	<script src="/XeroxJavascriptLibrary/XRXWebservices.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXUtilities.js" type="text/javascript"></script>
	  
	<!-- Application Specific Javascript Files -->
	<script src="JS/Globals.js" type="text/javascript"></script>
	<script src="JS/Popup.js" type="text/javascript"></script>
	<script src="JS/DemoHelper.js" type="text/javascript"></script>
	
	<!-- Page Size Specific CSS File -->	  
	<script language="JavaScript" type="text/javascript" >
		//alert("window.location.href =" +window.location.href);
		//String strSize = (String)request.getAttribute("ScreenSize");
		//var strSize = request.getAttribute("ScreenSize");
		//alert("strSize=" + request.getAttribute("ScreenSize"));
	   document.write("<link href=\"CSS/" + getPageStyle() + "\" type=\"text/css\" rel=\"stylesheet\" />");
	   

	</script>

    <!-- Contains the xerox backgrounds -->
    <link href="https://127.0.0.1/xrx_widgets/XRXWidgets.css" rel="stylesheet" type="text/css" />
    
   <!--  <link href="CSS/HalfPageStyle.css" rel="stylesheet" type="text/css" />--> 
    <!-- contains the functions that make up the Xerox Widgets -->
    <script src="https://127.0.0.1/xrx_widgets/XRXWidgets.js" type="text/javascript"></script>
	
	<!-- Page Javascript -->
	<script language="JavaScript" type="text/javascript">

/****************************************  Globals  ****************************************************/
			
/****************************************  Initialize  *************************************************/
			
		/**
		* This function is called on ending of page load. It loads the Device Information
		* and the Session Information, asynchronously, and then enables the Next button.
		*/
		function init()
		{

			writeSR1(getDemoAppVersion());
			writeSR3( "Loading ..." );
			xrx_load_widgets();

			changeMargin("fullpane");
			document.getElementById( 'BrowserUserAgentBox' ).innerHTML = navigator.userAgent;
			document.getElementById( 'BrowserVersionBox' ).innerHTML = navigator.appVersion;
			document.getElementById( 'XeroxWidgetsVersionBox' ).innerHTML = getXeroxWidgetVersion();
			var index = location.pathname.lastIndexOf( "/" );
			var path = replaceChars( location.pathname.substring( 0, ((index > 0)?index:0) ), "/", "\\" );
			getDeviceInfo();			
			getUserName();
				
			
		}
		
		/**
		* This function is the callback point from the call to get the device information.
		* The device information is parsed out and displayed and the function to get the
		* Session username is called.
		*
		* @param request	request envelope of webservice call
		* @param response	webservice response in string form
		* @param status		if function called by the failure callback the http status code 
		*					is included
		*/
		function getDeviceInfo()
		{
			document.getElementById( 'DeviceModelBox' ).innerHTML = document.getElementById("DeviceModel").value;
			document.getElementById( 'ColorTypeBox' ).innerHTML =  
			((document.getElementById( 'Color' ).value == "color")?"Color": ((document.getElementById( 'Color' ).value == "monochrome")?"Black and White":"GrayScale"));
		}
		
		/**
		* This calls the javascript webservice to get the Session Information.
		*/
		function getUserName()
		{
			writeSR3( "Retrieving Session Information ...", false );
			xrxSessionGetSessionInfo( "https://127.0.0.1", successCallback2, failureCallback2 );
		}
		
		/**
		* This takes the response javascript webservice to get the Session Information.
		*
		* @param request	request envelope of webservice call
		* @param response	webservice response in string form
		*/
		function successCallback2( request, response )
		{
			var name = null;
			var data = xrxSessionParseGetSessionInfo( response );
			if(data != null)
			{
				if(xrxGetElementValue( data, "username" )!=null ||xrxGetElementValue( data, "Username" )!=null ||xrxGetElementValue( data, "UserName" )!=null ||xrxGetElementValue( data, "userName" )!=null)
					{
						if(xrxGetElementValue( data, "username" )!=null)
							name=xrxGetElementValue( data, "username" );
						else if(xrxGetElementValue( data, "Username" )!=null)
							name=xrxGetElementValue( data, "Username" )
						else if(xrxGetElementValue( data, "UserName" )!=null)
							name=xrxGetElementValue( data, "UserName" )
						else
							name=xrxGetElementValue( data, "userName" )
					}
				document.getElementById( "UsernameBox" ).innerHTML = 
					document.getElementById( "Username" ).value = ((name != null)?name:"Guest");
				
			
			}
			
		}
		
		/**
		* This takes the failure response javascript webservice to get the Session Information.
		*
		* @param request	request envelope of webservice call
		* @param response	webservice response in string form
		* @param status		http status code 
		*/
		function failureCallback2( envelope, response, status )
		{
			document.getElementById( 'UsernameBox' ).innerHTML = 
				document.getElementById( 'Username' ).value = ((name != null)?name:"Guest");
			
		}	
		
		/**
		* This prompts the user and enables the  button 
		*/
		function ready()
		{		
			writeSR3( "Ready to Continue!", false );
			disable( 'Next', false );
		}
		
		
        
        function Next_Click()
        {
        	//alert("Inside Next button of DemoPage.jsp");
        	//alert("ScreenSize at DemoPage.jsp="+getScreenSize());
			document.getElementById("ScreenSize").innerHTML = getScreenSize();
			document.forms[0].submit();
        }
    function Exit()
    {
    	xrxSessionExitApplication('http://127.0.0.1', null);
    }
		
    function changeMargin( inputName )
   { 
	   if(xrxIdentifyCurrentBrowser()=="SecondGenBrowser")
    	{
			document.getElementById( inputName ).style.marginTop = "40px";
			 
			if(getScreenSize()=="640x240")
				{  
				    //alert("inside change margin "+getScreenSize());
			        document.getElementById( inputName ).style.width="640px";
				}
        }
	
    	
    }
		
	</script>
	
<!-- *************************************  HTML  ********************************************* -->
  </head>
<body>               

	<form name="Demoform" action="PreMainPage" method="post">
		<!-- xrx:StatusRegionPanel -->
		<div class="xrx:StatusRegionPanel" id="xrx:StatusRegionPanel">
			<div class="xrx:StatusRegionSR1" id="xrx:StatusRegionSR1">
				<script>document.write("EIP Demo Scan Application (" + document.getElementById( 'EipVersion').innerHTML + ")" + " DemoPage.jsp");
				</script>
			</div>
			<div class="xrx:StatusRegionSR2" id="xrx:StatusRegionSR2">
				<script>document.write("Loading Page (using Webservices Library " 
						+ xrxGetWebservicesLibraryVersion() + ")");</script>
			</div> 
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
					<input type="button" class="xrx:command" imgsize="90x38" value="Exit" onclick="Exit();"/>
				</div>
				<div class="NextButton" style="float:right; padding:5px 5px 0 0;">
					<input type="submit" class="xrx:command" imgsize="90x38" value="Next" onclick="Next_Click();"/>
				</div>
				<div style="clear:both;"></div>
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
				<div class="titlepane" id="titlepane" style="color:white;">System Configuration</div>	
			</div>
			<div class="fullpane firstpage" id="fullpane" style="margin:10px 10px 0 10px;">
				<div class="box">
					<label class="UsernameLabel DemoLabel">Username:</label>
					<span class="UsernameBox DemoBox" id="UsernameBox"></span>
				</div>
				<div class="box">
				 	<label class="DeviceModelLabel DemoLabel">Device Model:</label>
					<span class="DeviceModelBox DemoBox" id="DeviceModelBox"></span>
				</div>	
				<div class="box">
					<label class="ColorTypeLabel DemoLabel">Color Type:</label>					
					<span class="ColorTypeBox DemoBox" id="ColorTypeBox"></span>
				 </div>	
				 <div class="box">
					<label class="BrowserUserAgentLabel DemoLabel">Browser User Agent:</label>
					<span class="BrowserUserAgentBox DemoBox" id="BrowserUserAgentBox" style="word-wrap:break-word;"></span>
				 </div>	
				 <div class="box">
					<label class="BrowserVersionLabel DemoLabel">Browser Version:</label>
					<span class="BrowserVersionBox DemoBox" id="BrowserVersionBox"></span>
				 </div>	
				 <div class="box">
					<label class="XeroxWidgetsVersionLabel DemoLabel">Xerox Widgets Version:</label>
					<span class="XeroxWidgetsVersionBox DemoBox" id="XeroxWidgetsVersionBox"></span>
				 </div>	
			</div>
		
			<textarea name="Username" id="Username" style="VISIBILITY:hidden">${Username}</textarea>
			<textarea name="DeviceModel" id="DeviceModel" style="VISIBILITY:hidden">${DeviceModel}</textarea>
			<textarea name="Color" id="Color" style="VISIBILITY:hidden">${Color}</textarea>
			<textarea name="EipVersion" id="EipVersion" style="VISIBILITY:hidden">${EipVersion}</textarea>
			<textarea name="Destination" id="Destination" style="VISIBILITY:hidden">${Destination};</textarea>
			<textarea name="DocumentType" id="DocumentType" style="VISIBILITY:hidden">${DocumentType}</textarea>
			<textarea name="ColorOptions" id="ColorOptions" style="VISIBILITY:hidden">${ColorOptions}</textarea>
			<textarea name="Orientation" id="Orientation" style="VISIBILITY:hidden">${Orientation}</textarea>
			<textarea name="PageSides" id="PageSides" style="VISIBILITY:hidden">${PageSides}</textarea>
			<textarea name="PrintOptions" id="PrintOptions" style="VISIBILITY:hidden">${PrintOptions}</textarea>
			<textarea name="ScreenSize" id="ScreenSize" style="VISIBILITY:hidden">${ScreenSize}</textarea>
			<!-- <textarea name="ASPButton" >${ASPButton}&nbsp;</textarea>-->
	</div>	
		<!-- End of xrx:ProgramAreaPanel -->
	</form>
	
	 <script>window.onload=init();</script>
	 
</body>
</html>