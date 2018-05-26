/**
* Globals.js.
* This file contains javascript globals that assist the pages.
*
* Demo program is provided as is as a code example for our partners.
*
* @version	     03/28/2009
* @author	     Adam H. Beck
* @modifications by  Rick S. Born
* 		     Steve Santacroce
*/


// Server Physical Location
var SERVER_LOCATION_PREFIX = "c:\\inetpub\\wwwroot";
var SERVER_LOGIN = "DomainName,Username,Password";
var SCAN_LOCATION = "DemoScans";
var REPOSITORY_VOLUME = "SHARE";

// Community name for MIB calls
var COMMUNITY = "public";

/*********************************************************************************************/

// Retaining and parsing of the search string at page load
var COMMAND_LINE = window.location.search;
if(COMMAND_LINE != undefined)
	COMMAND_LINE = COMMAND_LINE.substring( 1, COMMAND_LINE.length );
else
	COMMAND_LINE = "";
	
// Page location globals
var PARENT_LOC = location.hostname;
var CURRENT_PAGE = location.pathname;
var CURRENT_PAGE_NAME = CURRENT_PAGE.substring( CURRENT_PAGE.lastIndexOf( "/" ) + 1, CURRENT_PAGE.length );
var CURRENT_LOCAL_PAGE_NAME = CURRENT_PAGE_NAME.substring( 0, CURRENT_PAGE_NAME.lastIndexOf( "." ) );
var CURRENT_FOLDER_NAME = ((CURRENT_PAGE.lastIndexOf( "/" ) >= 0)?CURRENT_PAGE
					.substring( ((CURRENT_PAGE.charAt(0) == "/")?1:0), CURRENT_PAGE.lastIndexOf( "/" ) ):"");
var CURRENT_FOLDER = "/" + CURRENT_FOLDER_NAME + "/";

// Widget location
// When force is false, Demo uses device side widgets but when 
// true server side Rev 1 widgets are used to simulate the half panel on a full panel
var FORCE = false;
var WIDGET_LOCATION = ((FORCE)?"":"https://127.0.0.1/");
