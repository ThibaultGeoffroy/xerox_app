<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pre Main Page</title>
<!-- Javascript Helper Files -->
	<script src="JS/Globals.js" type="text/javascript"></script>
	<script src="JS/DemoHelper.js" type="text/javascript"></script>
	
	<!-- This page is used to determine the next page -->
	<link href="CSS/FullPageStyle.css" type="text/css" rel="stylesheet" />
	
	<!-- Xerox Widgets -->
	<link href="http://127.0.0.1/xrx_widgets/XRXWidgets.css" type="text/css" rel="stylesheet" />
	<script src="http://127.0.0.1/xrx_widgets/XRXWidgets.js" type="text/javascript"></script>
	<!-- Page Javascript -->
	<script type="text/javascript">
	
		/**
		* Page load function.
		*/
		
		function init()
		{
			//document.getElementById("ScreenSize").innerHTML = getScreenSize();
			//alert("screen size inside premain init "+getScreenSize());
			//alert("Completed Reason inside Premainpage "+document.getElementById("Reason").value);
			document.forms[0].submit();
		}
		
		function getDeviceInfo()
		{
			
			document.getElementById( 'DeviceModelBox' ).innerHTML = document.getElementById("DeviceModel").value;
     		document.getElementById( 'ColorTypeBox' ).innerHTML =  
				((document.getElementById( 'Color' ).value == "color")?"Color": ((document.getElementById( 'Color' ).value == "monochrome")?"Black and White":"GrayScale"));
		}
		
	</script>
</head>
<body>
<!-- onload="gotoServlet();"> -->
	<form action="PreMainPage" method="post"> 
	<!-- method="get" id="PreMainPage" name="PreMainPage"> -->
	<!-- <div class="DeviceModelBox DemoBox" id="DeviceModelBox">${DeviceModel}</div> -->
	<div class="DeviceModelBox DemoBox" id="DeviceModelBox"></div>
	  	<!-- xrx:StatusRegionPanel -->
		<div class="xrx:StatusRegionPanel" id="xrx:StatusRegionPanel">
			<div class="xrx:StatusRegionSR1" id="xrx:StatusRegionSR1">
				
			</div>
			<div class="xrx:StatusRegionSR2" id="xrx:StatusRegionSR2">
				
			</div> 
			<div class="xrx:StatusRegionSR3" id="xrx:StatusRegionSR3"></div>
		</div>
		<!-- End of xrx:StatusRegionPanel -->
		
		<div class="xrx:StatusRegionHR1" id="xrx:StatusRegionHR1"></div>
		<div class="xrx:StatusRegionHR2" id="xrx:StatusRegionHR2"></div>
		
		<div class="xrx:ToolBarPanel" style="TEXT-ALIGN:left" id="xrx:ToolBarPanel">
			<div class="xrx:ToolBarTextLine1" id="xrx:ToolBarTextLine1"></div>
			<div class="xrx:ToolBarTextLine2" id="xrx:ToolBarTextLine2"></div>
			<div class="xrx:ToolBarTextLine3" id="xrx:ToolBarTextLine3"></div>
		</div>
		
		<div class="xrx:ToolBarHR1" id="xrx:ToolBarHR1"></div>
		<div class="xrx:ToolBarHR2" id="xrx:ToolBarHR2"></div>
		<div class="xrx:ProgramAreaPanel" id="xrx:ProgramAreaPanel"></div>
		
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
		<textarea name="ScreenSize" id="ScreenSize" style="VISIBILITY:hidden">${ScreenSize}</textarea>
		<textarea name="Reason" id="Reason" style="VISIBILITY:hidden">${Reason}</textarea>
		<!-- <input type="submit" id="submit" value="submit" onclick="Hello();"/> -->
	</form>
	<script>window.onload=init();</script>
</body>
</html>