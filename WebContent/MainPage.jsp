<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Xerox Webservices Javascript Library -->
	<script src="/XeroxJavascriptLibrary/XRXWebservices.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXXmlHandler.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXSession.js" type="text/javascript"></script>
	
	<!-- Application Specific Javascript Files -->
	<script src="JS/Globals.js" type="text/javascript"></script>
	<script src="JS/Popup.js" type="text/javascript"></script>
	<script src="JS/DemoHelper.js" type="text/javascript"></script>
	
	<!-- Page Size Specific CSS File -->
	<link href="CSS/FullPageStyle.css" type="text/css" rel="stylesheet" />
	
	<!-- Xerox Widgets -->
	<link href="http://127.0.0.1/xrx_widgets/XRXWidgets.css" type="text/css" rel="stylesheet" />
	<script src="http://127.0.0.1/xrx_widgets/XRXWidgets.js" type="text/javascript"></script>
	
	<!-- Page Javascript -->
	<script language="JavaScript" type="text/javascript">

/****************************************  Globals  ****************************************************/

			
/****************************************  Initialize  *************************************************/

	
		function init()
		{
			writeSR1(getDemoAppVersion());
			if(document.getElementById( 'Color' ).value != "color")
			{
				node = document.getElementById( 'ColorOptionsSelections' );
				node.options[0].removeAttribute( 'selected' );
				node.options[0].setAttribute( 'disabled', 'disabled' );
				node.options[1].setAttribute( 'selected', 'selected' );
			}
			//restore widgets to current setting
			document.getElementById( 'xrx:ToolBarTextLine1' ).innerHTML = document.getElementById("JobStatus").value;
			setOption( 'Destination' );
			setOption( 'DocumentType' );
			setOption( 'ColorOptions' );
			setOption( 'Orientation' );
			setOption( 'PageSides' );
			setOption( 'PrintOptions' );
			writeSR2( "Device Model " + document.getElementById( 'DeviceModel' ).value + "  /  Username: "
				+ document.getElementById( 'Username' ).value );
		//	alert("Reason  inside MainMidpage"+document.getElementById( 'Reason' ).value);
			//alert("Reason  inside premainpage"+document.getElementById( 'Reason' ).value);
			writeSR3(document.getElementById( 'Reason' ).value);
			xrx_load_widgets();
		}
		
		/**
		* Set the widgets to match the stored value.
		*
		* @param inputName	name of option
		*/
		function setOption( inputName )
		{
			var node = document.getElementById( inputName + 'Selections' );
			var value = document.getElementById( inputName ).value;
			if(value != "")
				for(var i = 0;i < node.options.length;++i)
					if(node.options[i].text == value)
					{
						node.options[i].setAttribute( 'selected', true );
						node.options[i].selected = true;
						for(var x = 0;x < node.options.length;++x)
							if((x != i) && (node.options[x].hasAttribute( 'selected' )))
								node.options[x].removeAttribute( 'selected' );
						break;
					}
			
			
		}
		
		
/**************************************  Command functions  *********************************************/
		
		/**
		* Store the widgets' values.
		*/
		function saveOptions()
		{
			document.getElementById( 'Destination' ).value = 
						document.forms[0].DestinationSelections.value;
			document.getElementById( 'DocumentType' ).value = 
						document.forms[0].DocumentTypeSelections.value;
			document.getElementById( 'ColorOptions' ).value = 
						document.forms[0].ColorOptionsSelections.value;
			document.getElementById( 'Orientation' ).value = 
						document.forms[0].OrientationSelections.value;
			document.getElementById( 'PageSides' ).value = 
						document.forms[0].PageSidesSelections.value;
			document.getElementById( 'PrintOptions' ).value = 
						document.forms[0].PrintOptionsSelections.value;
		}
		
		/**
		* Goto to next page. 
		*/
		function gotoScanPage()
		{
			saveOptions();
			//sendPage();
			document.forms[0].submit();
		}
		
		 function Exit()
		    {
		    	xrxSessionExitApplication('http://127.0.0.1', null);
		    }
		
	</script>
	
<!-- *************************************  HTML  ********************************************* -->
</head>
<body>
	<form action="MainPage" method="get">
		<!-- xrx:StatusRegionPanel -->
		<div class="xrx:StatusRegionPanel" id="xrx:StatusRegionPanel">
			<div class="xrx:StatusRegionSR1" id="xrx:StatusRegionSR1">
				<script>document.write("EIP Demo Scan Application (" + document.getElementById( 'EipVersion').innerHTML + ")" + " MainPage.jsp");</script>
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
			<div class="ExitButton" style="float:right; padding:5px 5px 0 0;">
					<input type="button" class="xrx:command" imgsize="90x38" value="Exit"  onclick="Exit();" />
				</div>
				<div class="NextButton" style="float:right; padding:5px 5px 0 0;">
					<input type="submit" class="xrx:command" imgsize="90x38" value="Next" onclick="gotoScanPage()" />
				</div>
				<div style="clear:both;"></div>	
		</div>
		<!-- End of xrx:ToolBarPanel -->
		
		<!-- xrx:ToolBarHR -->
		<div class="xrx:ToolBarHR1" id="xrx:ToolBarHR1"></div>
		<div class="xrx:ToolBarHR2" id="xrx:ToolBarHR2"></div>
		<!-- End of xrx:ToolBarHR -->
		
		<!-- xrx:ProgramAreaPanel -->
		<div class="xrx:ProgramAreaPanel" id="xrx:ProgramAreaPanel">
			<div style="margin:10px 0 10px 10px;">
				<div class="titlepane" id="titlepane" style="color:white;">Please Make Your Choices:</div>	
			</div>	
			
			<div class="fullpane secondPage" id="fullpane" style="margin:10px 0 0 0;">
				<div class="DestinationLabel"  id="DestinationLabel">Choose your Scan Workflow</div>
				<div class="DestinationSelections" id="DestinationSelectionsh">
					<select class="xrx:radio" name="DestinationSelections" id="DestinationSelections">
						<option selected="selected">Scan to my PC</option>
						<option disabled="disabled">Scan to Docushare</option>
						<option disabled="disabled">Scan to Payroll</option>
					</select>
				</div>
				<div class="DocumentTypeLabel" id="DocumentTypeLabel">Choose your Document Type</div>
				<div class="DocumentTypeSelections" id="DocumentTypeSelectionsh">
					<select class="xrx:radio" name="DocumentTypeSelections" id="DocumentTypeSelections">
						<option selected="selected">PDF</option>
						<option>TIFF</option>
					</select>
				</div>
				<div class="ColorOptionsLabel" id="ColorOptionsLabel">Choose Color Type</div>
				<div class="ColorOptionsSelections" id="ColorOptionsSelectionsh">
					<select class="xrx:radio" name="ColorOptionsSelections" id="ColorOptionsSelections">
						<option selected="selected">Color</option>
						<option>Grayscale</option>
						<option>Black and White</option>
					</select>
				</div>
				<div class="OrientationLabel" id="OrientationLabel">Choose your Orientation</div>
				<div class="OrientationSelections" id="OrientationSelectionsh">
					<select class="xrx:radio" name="OrientationSelections" id="OrientationSelections">
						<option selected="selected">Portrait</option>
						<option>Landscape</option>
					</select>
				</div>
				<div class="PageSidesLabel" id="PageSidesLabel">Choose your Page Side Selection</div>
				<div class="PageSidesSelections" id="PageSidesSelectionsh">
					<select class="xrx:radio" name="PageSidesSelections" id="PageSidesSelections">
						<option selected="selected">One Sided</option>
						<option>Two Sided</option>
						<option>Second Side Rotation</option>
					</select>
				</div>
				<div class="PrintOptionsLabel" id="PrintOptionsLabel">Print Options</div>
				<div class="PrintOptionsSelections" id="PrintOptionsSelectionsh">
					<select class="xrx:radio" name="PrintOptionsSelections" id="PrintOptionsSelections">
						<option selected="selected">Scan</option>
						<option>Scan and Print</option>
					</select>
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
			<textarea name="JobStatus" id="JobStatus" style="VISIBILITY:hidden">${JobStatus}</textarea>
			<textarea name="ScreenSize" id="ScreenSize" style="VISIBILITY:hidden">${ScreenSize}</textarea>
			<textarea name="Reason" id="Reason" style="VISIBILITY:hidden">${Reason}</textarea>
			<!-- <textarea name="ASPButton" >${ASPButton}&nbsp;</textarea>		
			<input type="button" id="ASPButton" value="Next"  style="VISIBILITY: hidden" onmousedown="ASPButton_Click()" />-->
		</div>
		<!-- End of xrx:ProgramAreaPanel -->
	</form>
	<script>window.onload=init;</script>
</body>
</html>