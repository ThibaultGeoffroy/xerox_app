<!-- Copyright (c) 2013 Xerox Corporation. All Rights Reserved.-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script language="JavaScript" type="text/javascript">
		function init()
		{
		//	alert("Inside Default.jsp");
			//alert("screensize "+strSSize);
			// alert("strSSize "+ strSSize);
			 document.forms[0].submit();				
		}		
	</script>
</head>
<body>
	<form action="DeviceConfig" method="get">
	<%@ page import="java.util.*" %>
	<html>
		<head>
			<title>Http Request Headers Example</title>
		</head>
		<body>
			<%
			
				String strSSize = "";
				Enumeration<String> strScrSize = request.getHeaders("device-ui-resolution");
				   while(strScrSize.hasMoreElements())
			       {
			           strSSize = (String) strScrSize.nextElement();
			             
			       }
			
      
				    if (strSSize == null)
			        {
			        	strSSize = "640x240";
			        
			        }
				   
							
			%>
				<textarea name="ScreenSize" id="ScreenSize" style="VISIBILITY:hidden"><%=strSSize%></textarea>

		</body>
	</html>
 
	</form>
	<script>window.onload=init();</script>
</body>
</html>