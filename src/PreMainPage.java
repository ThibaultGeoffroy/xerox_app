//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.awt.Button;
import java.awt.TextField;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.DeviceInformation;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.DeviceInformationResponse;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.GetDeviceInformationRequest;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.GetDeviceInformationRequestE;

/**
 * Servlet implementation class PreMainPage
 */
public class PreMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreMainPage() {
        super();
        dem=new DemAppLog();
        // TODO Auto-generated constructor stub
    }

	protected String Username;
	protected TextField Password;
	protected TextField DeviceModel;
    protected TextField EipVersion;
	protected TextField Color;
	protected TextField Destination;
	protected TextField DocumentType;
	protected TextField ColorOptions;
	protected TextField Orientation;
	protected TextField PageSides;
	protected TextField PrintOptions;
	protected Button ASPButton;
	
	private String strScreenSize = "";
	private DemAppLog dem;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Premainpage.java  ");
		dem.writeAboutLogs("Info", "Entering doPost method of PreMainPage file", 2);
		request.setAttribute("Username", request.getParameter("Username"));
		request.setAttribute("Password", request.getParameter("Password"));
		request.setAttribute("DeviceModel",request.getParameter("DeviceModel"));
		request.setAttribute("EipVersion", request.getParameter("EipVersion"));
		System.out.println("Eipversion in premain.java"+request.getParameter("EipVersion"));
		request.setAttribute("Color", request.getParameter("Color"));
		request.setAttribute("Destination", request.getParameter("Destination"));
		request.setAttribute("DocumentType",  request.getParameter("DocumentType"));
		request.setAttribute("ColorOptions", request.getParameter("ColorOptions"));
		request.setAttribute("Orientation" ,request.getParameter("Orientation"));
		request.setAttribute("PageSides", request.getParameter("PageSides"));
		request.setAttribute("PrintOptions", request.getParameter("PrintOptions"));
		strScreenSize = request.getParameter("ScreenSize");
		System.out.println("ScreenSize is inside premain.java  "+request.getParameter("ScreenSize"));
		dem.writeAboutLogs("Debug", "Entering doPost method of PreMainPage file having Screen Size value: "+strScreenSize, 2);
		request.setAttribute("ScreenSize", strScreenSize);
		System.out.println("Reason is inside premain.java  "+request.getParameter("Reason"));
		request.setAttribute("Reason", request.getParameter("Reason"));
		//request.setAttribute("Reason", completedReason);
		
//		String strSSize = "";
//		Enumeration<String> strScrSize = request.getHeaders("device-ui-resolution");
//	       while(strScrSize.hasMoreElements()){
//	           strSSize = (String) strScrSize.nextElement();
//	             
//	         }
//	
//	       
//	    if (strSSize == null)
//        {
//        	strSSize = "640x240";
//        
//        }
//	    strScreenSize = strSSize;
		dem.writeAboutLogs("Info", "Exiting doPost method of PreMainPage file", 2);
        ToggleScreen(request,response);
	}
    

	private void ToggleScreen(HttpServletRequest request, HttpServletResponse response)
	{
		dem.writeAboutLogs("Info", "Entering ToggleScreen method of PreMainPage file", 2);
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
		System.out.println("Before getting screen type");
		int nScreenType = getScreenType();
		System.out.println("After getting screen type");
		String strURL = "";
		System.out.println("Screen type from Premainpage..screentype  "+nScreenType);
        switch (nScreenType)
        {
            case 1: //FULL_SIZE_SCREEN:
            	strURL = "/MainPage.jsp";//?ScreenSize=" + strScreenSize + "&Version=" + strVer;
            	dem.writeAboutLogs("Info", "Entering switch section(FULL_SIZE_SCREEN) in ToggleScreen method of PreMainPage file screensize: "+nScreenType, 2);
                break;
            case 2: //MID_SIZE_SCREEN:
            	strURL = "/MainMidPage.jsp";//?ScreenSize=" + strScreenSize + "&Version=" + strVer;
            	dem.writeAboutLogs("Info", "Entering switch section(MID_SIZE_SCREEN) in ToggleScreen method of PreMainPage file screensize: "+nScreenType, 2);
                break;
            case 3: //HALF_SIZE_SCREEN:
            	strURL = "/MainHalfPage.jsp";//?ScreenSize=" + strScreenSize + "&Version=" + strVer;
            	dem.writeAboutLogs("Info", "Entering switch section(HALF_SIZE_SCREEN) in ToggleScreen method of PreMainPage file screensize: "+nScreenType, 2);
                break;
            default:
            	strURL = "/MainHalfPage.jsp";//?ScreenSize=" + strScreenSize + "&Version=" + strVer;
            	dem.writeAboutLogs("Debug", "Entering switch section(default) in ToggleScreen method of PreMainPage file screensize: "+nScreenType, 2);
                break;                
        }
       // strURL = "/MainHalfPage.jsp";

    	try
		{
    		dem.writeAboutLogs("info", "Inside requestDispatcher of doGet method of MainPage file -> "+strURL, 2);
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher(strURL);
			reqDispatcher.forward(request, response);
	
		}
		catch(Exception ex)
		{
			dem.writeAboutLogs("Error", "Entering Catch section in ToggleScreen method of PreMainPage file with error argument: "+ex.getMessage(), 2);
			System.out.println(ex.getMessage());		
		}

    }
	private String checkClassVersion() throws IOException
	{
		dem.writeAboutLogs("Info", "Entering checkClassVersion method of PreMainPage file", 2);
		
		InputStream IS = this.getClass().getClassLoader().getResourceAsStream(getClass().getName().replace('.', '/') + ".class");

        DataInputStream dataIS = new DataInputStream(IS);

        int magic = dataIS.readInt();
        dem.writeAboutLogs("Debug", "Entering checkClassVersion method of PreMainPage file having magic value: "+magic, 2);
        if(magic != 0xcafebabe) 
        {
        	dem.writeAboutLogs("Error", "Entering exception section in checkClassVersion method of PreMainPage file with error argument: Invalid Java class ", 2);
        	throw new IOException("Invalid Java class");
        }
        int minor = dataIS.readUnsignedShort();
        int major = dataIS.readUnsignedShort();
        dataIS.close();
        dem.writeAboutLogs("Debug", "Entering checkClassVersion method of PreMainPage file having major value: "+major, 2);
        dem.writeAboutLogs("Debug", "Entering checkClassVersion method of PreMainPage file having minor value: "+minor, 2);
        dem.writeAboutLogs("Info", "Exiting checkClassVersion method of PreMainPage file", 2);
        return major + " . " + minor;
	}

	/*
     * This function determines screen type base on screen size.
     * 
     * @param String screen size
     * 
     * @return FULL_SIZE_SCREEN if screen height >= 600, MID_SIZE_SCREEN if screen 480 <= height < 600,
     *  HALF_SIZE_SCREEN if height < 480.
     */
    private int getScreenType()
    {
    	dem.writeAboutLogs("Info", "Entering getScreenType method of PreMainPage file", 2);
        int nScreenType = 1;
        System.out.println("Str Screen size "+strScreenSize);
        System.out.println("Before getting index "+strScreenSize);
        int startIndex = strScreenSize.indexOf('x') + 1;
        if(startIndex==0)
        {
        	startIndex = strScreenSize.indexOf('X') + 1;
        }
      
        System.out.println("After getting index "+startIndex);
        String heightStr = strScreenSize.substring(startIndex);
     
        int height = Integer.parseInt(heightStr);
        dem.writeAboutLogs("Debug", "Inside getScreenType method of PreMainPage file having height value: "+height, 2);
        if (height >= 600)
        {
        	nScreenType = 1; //FULL_SIZE_SCREEN
        }
        else if ((height >= 480) && (height < 600))
        {
        	nScreenType = 2; //MID_SIZE_SCREEN
        }
        else
        {
        	nScreenType = 3; //HALF_SIZE_SCREEN
        }
        dem.writeAboutLogs("Debug", "Inside getScreenType method of PreMainPage file having ScreenType value: "+nScreenType, 2);
        return nScreenType;
    }

}
