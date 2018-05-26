document.getElementById( 'ModelBox' ).innerHTML = document.getElementById("DeviceModel").value;
//document.getElementById( 'DeviceModelBox' ).innerHTML = document.getElementById("DeviceModel").innerHTML;
document.getElementById( 'ColorTypeBox' ).innerHTML =  
((document.getElementById( 'Color' ).value == "color")?"Color": ((document.getElementById( 'Color' ).value == "monochrome")?"Black and White":"GrayScale"));