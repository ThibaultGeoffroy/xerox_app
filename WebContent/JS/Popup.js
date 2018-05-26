
// Globals
var popupDialogHolder;
var popupDialogText = ["","",""];
var popupDialogCallback;

/*
* Function to get a div dialog.
*
* @param name	node to set the border around
* @param left	(optional) left position
* @param top	(optional) top position
* @param width	(optional) width of div
* @param height	(optional) height of div
* @param zIndex	(optional) zIndex of div
*/
function getAreaHolder( name, left, top, width, height, zIndex )
{
	var area = document.getElementById( name );
	if(area == null)
	{
		area = document.createElement( "div" );
		area.setAttribute( "id", name );
		area.style.position = "absolute";
		if(left != undefined) area.style.left = left + "px";
		if(top != undefined) area.style.top = top + "px";
		if(width != undefined) area.style.width = width + "px";
		if(height != undefined) area.style.height = height + "px";
		if(zIndex != undefined) area.style.zIndex = zIndex;
		area.style.borderStyle = 'solid';
		area.style.borderColor = 'Black';
		area.style.borderWidth = 2;
		area.style.backgroundColor = "Grey";
		area.style.visibility = "hidden";
		document.body.insertBefore( area, document.body.firstChild.nextSibling );
	}
	return area;
}

/*
* Function to popup a dialog.
*
* @param callback	address of function to callback to
* @param title		title to display in Popup
* @param text		text to display under title
* @param bText		array of button names
*/
function popupQuestionBox( callback, title, text, bText )
{
	var area = getAreaHolder( 'PopupDialogHolder', Math.floor( (((screen.width > 800)?800:screen.width) - 320) / 2),
							Math.floor( (((screen.height > 540)?540:screen.height) - 170) / 2), 320, 170, 999 );
	if(area != null)
	{
		area.innerHTML = "<div "
				+ "<div><center><b>" + title + "</b></center></div><div style=\"position:absolute;left:10;top:38;width:300;height:40" 
				+ "\">" + text + "</div><div style=\"position:absolute;left:15;top:90;width:290;height:80\">" 
				+ ((bText.length == 5)?"<div style=\"position:absolute;left:0;top:0;width:54;height:15\"><center>" + (popupDialogText[0] = bText[0]) 
				+ "</center></div><div style=\"position:absolute;left:0;top:20;width:54;height:40\"><center><img id=\"DialogB0\" src=\"Images/apop_btn.gif\" "
				+ "width=\"50\" height=\"40\" onmousedown=\"popupQuestionButton(0);\"></img></center></div>":"") 
				+ ((bText.length > 1)?"<div style=\"position:absolute;left:59;top:0;width:54;height:15\"><center>" + (popupDialogText[1] = 
				((bText.length == 5)?bText[1]:bText[0])) + "</center></div><div style=\"position:absolute;left:59;top:20;width:54;height:40\"><center><img "
				+ "id=\"DialogB1\" src=\"Images/apop_btn.gif\" width=\"50\" height=\"40\" onmousedown=\"popupQuestionButton"
				+ "(1);\"></img></center></div>":"")
				+ ((bText.length != 2)?"<div style=\"position:absolute;left:118;top:0;width:54;height:15\"><center>" + (popupDialogText[2] = ((bText.length == 1)?
				bText[0]:((bText.length == 5)?bText[2]:bText[1]))) + "</center></div><div style=\"position:absolute;left:118;top:20;width:54;height:40\">"
				+ "<center><img id=\"DialogB2\" src=\"Images/apop_btn.gif\" width=\"50\" height=\"40\" "
				+ "onmousedown=\"popupQuestionButton(2);\"></img></center></div>":"")
				+ ((bText.length > 1)?"<div style=\"position:absolute;left:177;top:0;width:54;height:15\"><center>" + (popupDialogText[3] = ((bText.length == 2)?
				bText[1]:((bText.length == 5)?bText[3]:bText[2]))) + "</center></div><div style=\"position:absolute;left:177;top:20;width:54;height:40\">"
				+ "<center><img id=\"DialogB3\" src=\"Images/apop_btn.gif\" width=\"50\" height=\"40\" "
				+ "onmousedown=\"popupQuestionButton(3);\"></img></center></div>":"")
				+ ((bText.length > 3)?"<div style=\"position:absolute;left:236;top:0;width:54;height:15\"><center>" + (popupDialogText[4] = ((bText.length == 4)?
				bText[3]:bText[4])) + "</center></div><div style=\"position:absolute;left:236;top:20;width:54;height:40\"><center><img id=\"DialogB4\" "
				+ "src=\"Images/apop_btn.gif\" width=\"50\" height=\"40\" onmousedown=\"popupQuestionButton(4);\"></img>"
				+ "</center></div>":"") + "</div>";
		popupDialogCallback = callback;
		(popupDialogHolder = area).style.visibility = "visible";
	}
}

/*
* Callback point of popup that calls the user's callback.
*
* @param index	index of button names that was selected
*/
function popupQuestionButton( index )
{
	popupDialogHolder.innerHTML = "";
	popupDialogHolder.style.visibility = "hidden";
	if((popupDialogCallback != undefined) && (popupDialogCallback != null)) popupDialogCallback( popupDialogText[index] );
}

/*
* Function to put up a Yes and No dialog.
*
* @param msg		message to display
* @param callback	function point to callback to with answer
*/
function popupYesNo( msg, callback )
{
	popupQuestionBox( callback, msg, "", ["Yes","No"] );
}

/*
* Function to put up an OK dialog.
*
* @param msg		message to display
* @param callback	(optional) function point to callback to
*/
function popupOk( msg, callback )
{
	popupQuestionBox( callback, msg, "", ["OK"] );
}
