//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.awt.Button;
import java.awt.TextField;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Servlet implementation class MainHalfPage
 */
public class MainHalfPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainHalfPage() {
        super();
        dem=new DemAppLog();
        // TODO Auto-generated constructor stub
    }

	private String strScreenSize = "";
	private DemAppLog dem;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dem.writeAboutLogs("Info", "Entering the doGet method of MainHalfPage file", 2);
		request.setAttribute("Username", request.getParameter("Username"));
		request.setAttribute("Password", request.getParameter("Password"));
		request.setAttribute("DeviceModel",request.getParameter("DeviceModel"));
		request.setAttribute("EipVersion", request.getParameter("EipVersion"));
		request.setAttribute("Color", request.getParameter("Color"));
		request.setAttribute("Destination", request.getParameter("Destination"));
		request.setAttribute("DocumentType",  request.getParameter("DocumentType"));
		request.setAttribute("ColorOptions", request.getParameter("ColorOptions"));
		request.setAttribute("Orientation" ,request.getParameter("Orientation"));
		request.setAttribute("PageSides", request.getParameter("PageSides"));
		request.setAttribute("PrintOptions", request.getParameter("PrintOptions"));
		request.setAttribute("ScreenSize", request.getParameter("ScreenSize"));
		dem.writeAboutLogs("Info", "Exiting the doGet method of MainHalfPage file", 2);
		ToggleScreen(request,response);
        	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	}
	
	private void ToggleScreen(HttpServletRequest request, HttpServletResponse response)
	{
		dem.writeAboutLogs("Info", "Entering the ToggleScreen method of MainHalfPage file", 2);
        String strVersion = "1";
        String strVer = "";
		try 
		{
			strVersion = checkClassVersion();
			strVer = strVersion.replace(" ", "");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String strURL = "/StartScanPage.jsp";
       
        try
		{
        	dem.writeAboutLogs("info", "Inside requestDispatcher of doGet method of MainHalfPage file -> StartScanPage.jsp", 2);
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher(strURL);
			reqDispatcher.forward(request, response);
			
		}
		catch(Exception ex)
		{
			dem.writeAboutLogs("Error", "Entering Catch section in ToggleScreen method of MainHalfPage file with error argument: "+ex.getMessage(), 2);
			System.out.println(ex.getMessage());		
		}

    }
	private String checkClassVersion() throws IOException
	{
		dem.writeAboutLogs("Info", "Entering checkClassVersion method of MainHalfPage file", 2);
		InputStream IS = this.getClass().getClassLoader().getResourceAsStream(getClass().getName().replace('.', '/') + ".class");

        DataInputStream dataIS = new DataInputStream(IS);

        int magic = dataIS.readInt();
        dem.writeAboutLogs("Debug", "Entering checkClassVersion method of MainHalfPage file having magic value: "+magic, 2);
        if(magic != 0xcafebabe) 
        {
        	dem.writeAboutLogs("Error", "Entering exception section in checkClassVersion method of MainHalfPage file with error argument: Invalid Java class ", 2);
        	throw new IOException("Invalid Java class");
        }
        int minor = dataIS.readUnsignedShort();
        int major = dataIS.readUnsignedShort();
        dataIS.close();
        dem.writeAboutLogs("Debug", "Entering checkClassVersion method of MainHalfPage file having major value: "+major, 2);
        dem.writeAboutLogs("Debug", "Entering checkClassVersion method of MainHalfPage file having minor value: "+minor, 2);
        dem.writeAboutLogs("Info", "Exiting checkClassVersion method of MainHalfPage file", 2);
        return major + " . " + minor;
	}
}
