/**
* DemoHelper.js.
* This file contains helper functions for the Demo program.
*
* Demo program is provided as is as a code example for our partners.
*
* @version	10/12/07
* @author	Adam H. Beck
*
* @version 3.1 07/29/09
* Add getPageStyle() method. Get the screen size information from HTTP header,
* and determine which page to display base on screen size.
* @author T. Chen
*/
var g_ScreenSize;
var g_DemoAppVersion="Java DemoApp 4.0.01"
/**
* This function gets the Xerox Widget version.
*
* @return string Rev2 widget version string or "Rev 1"
*/
function getXeroxWidgetVersion()
{
	var version = "Xerox Widgets ";
	try
	{
		version += "Rev 2 Ver. " + xrxGetWidgetCodeVersion() + " " + xrxGetWidgetExtensionVersion()
				+ " / " + xrxGetWidgetDataVersion()	+ " / " + xrxGetWidgetStyleVersion();
	} catch( e )
	{
		version += "Rev 1";
	}
	return version;
}

/**
* This writes the message to the SR3 area if it exists.
*
* @param msg	message to write
* @param append	true = append
*/
function writeSR3( msg, append )
{
	if(append == undefined) append = true;
	var sr3 = document.getElementById( "xrx:StatusRegionSR3" );
	if(sr3 != null)
	{
		if(!append) sr3.innerHTML = "";
		sr3.appendChild( document.createTextNode( msg ) );
	}		
} 
 
/**
* This writes the message to the SR2 area if it exists.
*
* @param msg	message to write
* @param append	true = append
*/
function writeSR2( msg, append )
{
	if(append == undefined) append = true;
	var sr2 = document.getElementById( "xrx:StatusRegionSR2" );
	if(sr2 != null)
	{
		if(!append) sr2.innerHTML = "";
		sr2.appendChild( document.createTextNode( msg ) );
	}		
}

/**
* This writes the message to the SR1 area if it exists.
*
* @param msg	message to write
* @param append	true = append
*/
function writeSR1( msg, append )
{
	if(append == undefined) append = true;
	var sr1 = document.getElementById( "xrx:StatusRegionSR1" );
	if(sr1 != null)
	{
		if(!append) sr1.innerHTML = "";
		sr1.appendChild( document.createTextNode( msg ) );
	}		
}
/**
* This calls the Session Api exit function to exit EIP mode.
*/
function exit()
{
	xrxSessionExitApplication( "https://127.0.0.1", null );
}
		
/**
* This clicks the ASPButton hidden button to cause a post back.
*/
function sendPage()
{
	document.getElementById( 'ASPButton' ).click();
}

/**
* This clicks the ASPButton hidden button to cause a post back 
* and a transfer to the main page.
*/
function gotoMainPage()
{
	document.getElementById( 'ASPMainPage' ).click();
}

/**
* This function disables/enables a Xerox widget while taking into 
* account the differences between Rev 1 and Rev 2.
*
* @param id			ID of widget
* @param disable	true=disable widget
*/
function disable(id, disable) {
    var node = document.getElementById(id);
    if ((disable == undefined) || disable)
        node.setAttribute('disabled', "disabled");
    else
        if (node.hasAttribute('disabled'))
            node.removeAttribute('disabled');
        else
            if (node.hasAttribute('unselectable'))
                node.removeAttribute('unselectable');

    var widget;
    if (node != null)
        if (node.hasAttribute('index'))
            if ((widget = xrxWidgetObjectArray[node.getAttribute('index')]) != undefined)
                widget.regenerate();
}

/*
* Function to replace characters in a string. Replacement is global. Necessary as current 
* browser has problems with String.replace().
*
* @param text	string to modify
* @param str	string to search for
* @param rstr	replacement string
* @return modified string
*/
function replaceChars( text, str, rstr )
{
	var index = text.indexOf( str );
	var result = "";
	while(index >= 0) 
	{
		result += ((index > 0)?text.substring( 0, index ):"");
		result += rstr;
		text = text.substring( index + str.length, text.length );
		index = text.indexOf( str );
	}
	return( result + text );
}

/*
 * This function determines SCREEN_TYPE.
 * screenType = FULL if height >= 600.
 * screenType = MID if 480 <= height < 600.
 * screenType = HALF if height < 480.
 *
 * @param string Screen size
 * @return screenType
 */
 function getScreenType(screenSize)
 {
	// alert("screenSize="+ screenSize);
     var screenType = "HALF_SIZE_SCREEN"; 
     
     if (screenSize != null)
     {     
        var height = 0;
        var endIndex = screenSize.length - 1;
        var startIndex = screenSize.indexOf('x');
        if (startIndex == -1)
        {
            startIndex = screenSize.indexOf('X');
        }
     
        if (startIndex != -1)
        {
            height = screenSize.substr(startIndex+1, endIndex);
        }
     
        if (height >= 600)
        {
        	//alert("FULL_SIZE_SCREEN");
            screenType = "FULL_SIZE_SCREEN";
        }
        else if ((height < 600) && (height >= 480))
        {
        	//alert("MID_SIZE_SCREEN");
            screenType = "MID_SIZE_SCREEN";
        }
        else
        {
        	//alert("HALF_SIZE_SCREEN");
            screenType = "HALF_SIZE_SCREEN";
        }
     }
   //  screenType = "HALF_SIZE_SCREEN";
    // alert("screenType() --> cssName = " +screenType );
        return screenType;
 }

/*
 * Function to parse the search string and build the name/value pairs into a hashtable.
 *
 */
function getQueryString()
{
    var queryStrs = new Array();
    //alert("COMMAND_LINE="+ COMMAND_LINE);
    var pairs = COMMAND_LINE.split('&');
    //alert("pairs.length=" + pairs.length);
    for (var i = 0; i < pairs.length; i++)
    {
    	//alert("pairs[i]=" + pairs[i]);
        if (!pairs[i]) 
        {
          continue;
        }
      
        var seperatorIndex = pairs[i].indexOf('=');
      
        if (seperatorIndex == -1)
        {
            queryStrs[pairs[i]] = "";
        }
        else
        {
            queryStrs[pairs[i].substring(0, seperatorIndex)] = pairs[i].substr(seperatorIndex + 1);
        }
    }
            
    return queryStrs;
}

/**
* This function gets a page style css file base on UI screen size.
*
* @return string CSS file name.
*/
function getPageStyle()
{
      var screenSize = getQueryString()["ScreenSize"];
    //  screenSize="640x240";
      g_ScreenSize = screenSize;
      
     // alert("getPageStyle() --> screenSize = " +g_ScreenSize );
      var cssName = "HalfPageStyle.css";
      //var cssName = "Hello.css";
      switch (getScreenType(screenSize))
      {
        case "FULL_SIZE_SCREEN":
          cssName = "FullPageStyle.css";
          break;
        case "MID_SIZE_SCREEN":
          cssName = "MidPageStyle.css";
          break;
        case "HALF_SIZE_SCREEN":
          cssName = "HalfPageStyle.css";
          break;
        default:
          cssName = "HalfPageStyle.css";
          break;
      }
    //  cssName = "HalfPageStyle.css";
    //  alert("getPageStyle() --> cssName = " +cssName );
      return cssName;
}

function getScreenSize()
{  
	//alert("GET Screensize "+g_ScreenSize);
	return g_ScreenSize;
}

function getDemoAppVersion()
{
	return g_DemoAppVersion;
}