<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<script src="/XeroxJavascriptLibrary/XRXWebservices.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXXmlHandler.js" type="text/javascript"></script>
	<script src="/XeroxJavascriptLibrary/XRXSession.js" type="text/javascript"></script>
	
	 //Application Specific Javascript Files 
	<script src="JS/Globals.js" type="text/javascript"></script>
	<script src="JS/Popup.js" type="text/javascript"></script>
	<script src="JS/DemoHelper.js" type="text/javascript"></script>
	
	//Page Size Specific CSS File 
	<link href="CSS/HalfPageStyle.css" type="text/css" rel="stylesheet" />
	
	//Xerox Widgets
	<link href="http://127.0.0.1/xrx_widgets/XRXWidgets.css" type="text/css" rel="stylesheet" />
	<script src="http://127.0.0.1/xrx_widgets/XRXWidgets.js" type="text/javascript"></script>
	
	//Page Javascript
	<script language="JavaScript" type="text/javascript">

/****************************************  Globals  ****************************************************/

		var currentOption = "OptionDisplay";
		var options = new Array();
			
/****************************************  Initialize  *************************************************/

		
		function init()
		{   writeSR1(getDemoAppVersion());
		    addEvents();
		    
			if(document.getElementById( 'Color' ).value != "color")
			{
				node = document.getElementById( 'ColorOptionsSelections' );
				node.options[0].removeAttribute( 'selected' );
				node.options[0].setAttribute( 'disabled', 'disabled' );
				node.options[1].setAttribute( 'selected', 'selected' );
			}
			setOption( 'Destination' );
			setOption( 'DocumentType' );
			setOption( 'ColorOptions' );
			setOption( 'Orientation' );
			setOption( 'PageSides' );
			setOption( 'PrintOptions' );
			setupStatusDisplay();
			
			writeSR2( "Device Model " + document.getElementById( 'DeviceModel' ).value + "  /  Username: "
				+ document.getElementById( 'Username' ).value );
			writeSR3(document.getElementById( 'Reason' ).value);
			xrx_load_widgets();
		}
		
		/**
		* Add event to select if the widgets is not rev 1.
		*/
		function addEvents()
		{
			//alert("inside function addevents");
		    var version = getXeroxWidgetVersion();
		    
		    if (version != "Xerox Widgets Rev 1")
		    {
		    	//alert("inside version1");
		        document.getElementById( 'optionselection' ).setAttribute('onchange',"displayOption()");
		        document.getElementById( 'DocumentTypeSelections' ).setAttribute('onchange',"setValue('DocumentType', document.forms[0].DocumentTypeSelections.value)");
		        document.getElementById( 'ColorOptionsSelections' ).setAttribute('onchange',"setValue('ColorOptions', document.forms[0].ColorOptionsSelections.value)");
		        document.getElementById( 'OrientationSelections' ).setAttribute('onchange',"setValue('Orientation', document.forms[0].OrientationSelections.value)"); 
		        document.getElementById( 'PageSidesSelections' ).setAttribute('onchange',"setValue('PageSides', document.forms[0].PageSidesSelections.value)");
		        document.getElementById( 'PrintOptionsSelections' ).setAttribute('onchange',"setValue('PrintOptions', document.forms[0].PrintOptionsSelections.value)");
		       
		        
		    }
		    else
		    {
		    //	alert("inside version2");
    		    document.getElementById( 'optionselection' ).options[0].setAttribute('onclick', "changeOption('OptionDisplay')");
    		    document.getElementById( 'optionselection' ).options[1].setAttribute('onclick', "changeOption('Destination')");
    		    document.getElementById( 'optionselection' ).options[2].setAttribute('onclick', "changeOption('DocumentType')");
    		    document.getElementById( 'optionselection' ).options[3].setAttribute('onclick', "changeOption('ColorOptions')");
    		    document.getElementById( 'optionselection' ).options[4].setAttribute('onclick', "changeOption('Orientation')");
    		    document.getElementById( 'optionselection' ).options[5].setAttribute('onclick', "changeOption('PageSides')");
    		    document.getElementById( 'optionselection' ).options[6].setAttribute('onclick', "changeOption('PrintOptions')");
		    }
    		    
		    onclick="changeOption('OptionDisplay')";
		}
		
		/**
		* Set value for options array.
		*
		* @param id array index
		* @param val value 
		*/
		function setValue(id, val)
		{
			//alert("inside setvalue id "+id +" value"+value);
		    options[id] = val;
		}
		        
		/**
		* Set the widgets to match the stored value.
		*
		* @param inputName	name of option
		*/
		function setOption( inputName )
		{
			//alert("inside setoption "+inputName);
			var node = document.getElementById( inputName + 'Selections' );
			var value = document.getElementById( inputName ).value;
		//	alert("inside setoption  value"+value);
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
			options[inputName] = node.options[node.selectedIndex].text;
		}
		
/*********************************  Command Functions  *************************************/
		
		function displayOption()
		{	//alert("inside displayoption");
			var node = document.getElementById( 'optionselection' );
			//alert("value  ..."+node.options[node.selectedIndex].value.replace( / /g, "" ));
			changeOption( node.options[node.selectedIndex].value.replace( / /g, "" ) );
		}
		
		/**
		* Hide one option and display another.
		*
		* @param choice		name of new option to display
		*/
		function changeOption( choice )
		{//alert("changeOption "+choice);
			if(choice == "OptionDisplay") setupStatusDisplay();
		//	alert("Choice "+choice);
			//alert("currentOption "+currentOption);
			document.getElementById( currentOption + "Box" ).style.display = "none";
			document.getElementById( (currentOption = choice) + "Box" ).style.display = "block";
		}
		
		/**
		* Set the status display with the current values.
		*/
		function setupStatusDisplay()
		{
			document.getElementById( 'xrx:ToolBarTextLine1' ).innerHTML = document.getElementById("JobStatus").value;
			document.getElementById( 'StatusSelection1' ).innerHTML = options['Destination'];
			document.getElementById( 'StatusSelection2' ).innerHTML = options['DocumentType'];
			document.getElementById( 'StatusSelection3' ).innerHTML = options['ColorOptions'];
			document.getElementById( 'StatusSelection4' ).innerHTML = options['Orientation'];
			document.getElementById( 'StatusSelection5' ).innerHTML = options['PageSides'];
			document.getElementById( 'StatusSelection6' ).innerHTML = options['PrintOptions'];
		}
		
		/**
		* Store the widgets' values.
		*/
		function saveOptions()
		{
			document.getElementById( 'Destination' ).value = options['Destination'];
			document.getElementById( 'DocumentType' ).value = options['DocumentType'];
			document.getElementById( 'ColorOptions' ).value = options['ColorOptions'];
			document.getElementById( 'Orientation' ).value = options['Orientation'];
			document.getElementById( 'PageSides' ).value = options['PageSides'];
			document.getElementById( 'PrintOptions' ).value = options['PrintOptions'];
		}
		
		/**
		* Goto to next page. 
		*/
		function gotoScanPage()
		{
			saveOptions();
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
	<form action="MainHalfPage" method="get">
		<!-- xrx:StatusRegionPanel -->
		<div class="xrx:StatusRegionPanel" id="xrx:StatusRegionPanel">
			<div class="xrx:StatusRegionSR1" id="xrx:StatusRegionSR1">
				<script>document.write("EIP Demo Scan Application (" + document.getElementById( 'EipVersion').innerHTML + ")" + " MainHalfPage.jsp");</script>
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
					<input type="submit" class="xrx:command" imgsize="90x38" value="Exit" onclick="exit()" />
				</div>
				<div class="NextButton" style="float:right; padding:5px 5px 0 0;">
					<input type="submit" class="xrx:command" imgsize="90x38" value="Next" onclick="gotoScanPage()"/>
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
			<div style="margin:10px 0 10px 10px;" class="titleBox">
				<div class="titlepane" id="titlepane" style="color:white;">Please Make Your Choices:</div>	
			</div>	
			<div class="fullpane secondPage" id="fullpane" style="margin:10px 0 0 10px;">
				<div class="OptionSelections">
					<select class="xrx:select" name="optionselection" id="optionselection" size="3" title="Option Selection" width="200">
						<option selected="selected">Option Display</option>
						<option>Destination</option>
						<option>Document Type</option>
						<option>Color Options</option>
						<option>Orientation</option>
						<option>Page Sides</option>
						<option>Print Options</option>
					</select>
				</div>
				<div id="OptionDisplayBox" class="GeneralOptionBox" style="margin:0px 0 0 10px; font-size:11px;">
					<div class="GeneralLabel">Option Display</div>
					<div class="GeneralSelections OptionDisplay">
						<div class="StatusLabel1 StatusLabels">Destination:</div>
						<div id="StatusSelection1" class="StatusSelections StatusSelection1"></div>
						<div class="StatusLabel2 StatusLabels">Document Type:</div>
						<div id="StatusSelection2" class="StatusSelections StatusSelection2"></div>
						<div class="StatusLabel3 StatusLabels">Color:</div>
						<div id="StatusSelection3" class="StatusSelections StatusSelection3"></div>
						<div class="StatusLabel4 StatusLabels">Orientation:</div>
						<div id="StatusSelection4" class="StatusSelections StatusSelection4"></div>
						<div class="StatusLabel5 StatusLabels">Page Sides:</div>
						<div id="StatusSelection5" class="StatusSelections StatusSelection5"></div>
						<div class="StatusLabel6 StatusLabels">Print Options:</div>
						<div id="StatusSelection6" class="StatusSelections StatusSelection6"></div>
					</div>
				</div>
				<div id="DestinationBox" class="GeneralOptionBox"  style="DISPLAY:none; margin:0px 0 0 10px;">
					<div class="GeneralLabel">Destination</div>
					<div class="GeneralSelections">
						<select class="xrx:radioSmall" name="DestinationSelections" id="DestinationSelections">
							<option selected="selected">Scan to my PC</option>
							<option disabled="disabled">Scan to Docushare</option>
							<option disabled="disabled">Scan to Payroll</option>
						</select>
					</div>
				</div>
				<div id="DocumentTypeBox" class="GeneralOptionBox" style="DISPLAY:none; margin:0px 0 0 10px;">
					<div class="GeneralLabel">Document Type</div>
					<div class="GeneralSelections">
						<select class="xrx:radioSmall" name="DocumentTypeSelections" id="DocumentTypeSelections">
							<option selected="selected" onclick="options['DocumentType']='PDF';">PDF</option>
							<option onclick="options['DocumentType']='TIFF';">TIFF</option>
						</select>
					</div>
				</div>
				<div id="ColorOptionsBox" class="GeneralOptionBox"  style="DISPLAY:none; margin:0px 0 0 10px;">
					<div class="GeneralLabel">Color Type</div>
					<div class="GeneralSelections">
						<select class="xrx:radioSmall" name="ColorOptionsSelections" id="ColorOptionsSelections">
							<option selected="selected" onclick="options['ColorOptions']='Color';">Color</option>
							<option onclick="options['ColorOptions']='Grayscale';">Grayscale</option>
							<option onclick="options['ColorOptions']='Black and White';">Black and White</option>
						</select>
					</div>
				</div>
				<div id="OrientationBox" class="GeneralOptionBox"  style="DISPLAY:none; margin:0px 0 0 10px;">
					<div class="GeneralLabel">Orientation</div>
					<div class="GeneralSelections2">
						<select class="xrx:radioSmall" name="OrientationSelections" id="OrientationSelections">
							<option selected="selected" onclick="options['Orientation']='Portrait';">Portrait</option>
							<option onclick="options['Orientation']='Landscape';">Landscape</option>
						</select>
					</div>
				</div>
				<div id="PageSidesBox" class="GeneralOptionBox" style="DISPLAY:none; margin:0px 0 0 10px;">
					<div class="GeneralLabel">Page Side Selection</div>
					<div class="GeneralSelections">
						<select class="xrx:radioSmall" name="PageSidesSelections" id="PageSidesSelections">
							<option selected="selected" onclick="options['PageSides']='One Sided';">One Sided</option>
							<option onclick="options['PageSides']='Two Sided';">Two Sided</option>
							<option onclick="options['PageSides']='Second Side Rotation';">Second Side Rotation</option>
						</select>
					</div>
				</div>
				<div id="PrintOptionsBox" class="GeneralOptionBox" style="DISPLAY:none; margin:0px 0 0 10px;">
					<div class="GeneralLabel">Print Options</div>
					<div class="GeneralSelections2">
						<select class="xrx:radioSmall" name="PrintOptionsSelections" id="PrintOptionsSelections">
							<option selected="selected" onclick="options['PrintOptions']='Scan';">Scan</option>
							<option onclick="options['PrintOptions']='Scan and Print';">Scan and Print</option>
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
			<textarea name="JobStatus" id="JobStatus" style="VISIBILITY:hidden">${JobStatus}</textarea>
			<textarea name="ScreenSize" id="ScreenSize" style="VISIBILITY:hidden">${ScreenSize}</textarea>
 			<textarea name="Reason" id="Reason" style="VISIBILITY:hidden">${Reason}</textarea>
			<!-- <textarea name="ASPButton" >${ASPButton}&nbsp;</textarea>		
			<input type="button" id="ASPButton" value="Next"  style="VISIBILITY: hidden" onmousedown="ASPButton_Click()" />-->
		</div>
		<!-- End of xrx:ProgramAreaPanel -->
	</form>
	<script>window.onload=init();</script>
</body>

</html>