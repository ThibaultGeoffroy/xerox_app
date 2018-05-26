//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/*
import com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub;
import com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.GetSessionInformationRequest;
import com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.GetSessionInformationRequestE;
import com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.SessionInformation;
import com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.SessionInformationResponse;
import com.xerox.www.webservices.office.cuisession._1.InternalServerErrorException;
import com.xerox.www.webservices.office.cuisession._1.OperationNotAllowedForRemoteClientsException;
*/

import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.DeviceInformation;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.DeviceInformationResponse;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.DeviceInformationResponseE;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.GetDeviceInformationRequest;
import com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.GetDeviceInformationRequestE;


/**
 * Servlet implementation class DeviceConfig
 */
public class DeviceConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeviceConfig() {
        super();
        dem=new DemAppLog();
        
        // TODO Auto-generated constructor stub
    }

    private static final String FMT_URL = "https://%1$s/%2$s";
	private static final String FMT_NOSSL_URL = "http://%1$s/%2$s";
	private boolean bSecured = false; 
	private String sDevice = "";
	private String sServiceURL = "";
	private String sWebserviceLocation = "webservices/office/device_configuration/1";
    private DemAppLog dem;
	private boolean getSecured() {
		return bSecured;
	}

	private void setSecured(boolean value) {
		bSecured = value;
	}
	
	private String getDevice() {
		return sDevice;
	}

	private void setDevice(String value) {
		System.out.println("device "+value);
		sDevice = value;
	}

	private String getServiceURL() {

		return sServiceURL;

	}

	private void setServiceURL(String value) {
		sServiceURL = value;
	}

	private String BuildUri(String Destination) {
		String DestinationUri = "";
		if (bSecured) {
			DestinationUri = String.format(FMT_URL, Destination,
					sWebserviceLocation);
		} else {
			DestinationUri = String.format(FMT_NOSSL_URL, Destination,
					sWebserviceLocation);
		}
		dem.writeAboutLogs("Debug", "Inside BuildUri method of DeviceConfig file having DestinationUri: "+DestinationUri, 2);
		return DestinationUri;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		System.out.println("Outside Default.jsp");		
		dem.writeAboutLogs("Info","Entering the doGet method of DeviceConfig file", 1);
		// TODO Auto-generated method stub	
		System.out.println("request.getRemoteHost()=" + request.getRemoteHost());
		System.out.println("request.getLocalHost()=" + request.getLocalAddr());
		System.out.println("request.getRemoteHost()=" + request.getRemoteAddr());
		System.out.println("request.getRemoteHost()=" + request.getLocalName());
		System.out.println("ScreenSize inside DeviceConfig"+ request.getParameter("ScreenSize"));
		request.setAttribute("ScreenSize", request.getParameter("ScreenSize"));
		dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file having RemoteHost: "+request.getRemoteHost(), 2);
		dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file having LocalAddr: "+request.getLocalAddr(), 2);
		dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file having RemoteAddr: "+request.getRemoteAddr(), 2);
		dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file having LocalName: "+request.getLocalName(), 2);
		dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file having ScreenSize: "+request.getParameter("ScreenSize"), 2);

		
		// TODO Auto-generated method stub
		setDevice(request.getRemoteHost());
		//setDevice("13.61.11.222");
		setSecured(false);
	    setServiceURL(BuildUri(getDevice()));		
	    dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file where service URL is set to: "+BuildUri(getDevice()), 2);    
		DeviceConfigurationServiceStub proxy = new DeviceConfigurationServiceStub(getServiceURL());
		DeviceConfigurationServiceStub.GetDeviceInformationRequest gdiRequest=new GetDeviceInformationRequest();
		DeviceConfigurationServiceStub.GetDeviceInformationRequestE gdiRequestE=new GetDeviceInformationRequestE();
		gdiRequestE.setGetDeviceInformationRequest(gdiRequest);
		
		DeviceConfigurationServiceStub.DeviceInformationResponseE diResponseE = proxy.getDeviceInformation(gdiRequestE);
		DeviceConfigurationServiceStub.DeviceInformationResponse diResponse = new DeviceInformationResponse();
		diResponse = diResponseE.getDeviceInformationResponse();
		DeviceInformation di = diResponse.getInformation();
		String strDeviceInfoXML = di.getDeviceInformation();
		String strClassPath=getClass().getClassLoader().getResource("").getPath(); //upto classes folder
	    String strDeviceConfigFilePath=strClassPath.substring(0,(strClassPath.length()-9))+"//logs//DeviceConfig.xml";
	    URI outputURI = null;
		try {
			outputURI = new URI(("file:///"+ strDeviceConfigFilePath.replaceAll(" ", "%20")));
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
		System.out.println("Filepath =="+strDeviceConfigFilePath);
		WriteToFile(outputURI.getPath(),strDeviceInfoXML);
		
		try 
		{
		    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		    dbf.setValidating(false);  
		    DocumentBuilder db = null;
			try 
			{
				db = dbf.newDocumentBuilder();
			} 
			catch (ParserConfigurationException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			String strDeviceValue = "";
			Document myDoc = null;
			try 
			{
				//myDoc = db.parse(new FileInputStream(new File(strDeviceConfigFilePath)));
				InputStream is = new ByteArrayInputStream(strDeviceInfoXML.getBytes());
				myDoc = db.parse(is);
				System.out.println("Successful after myDoc-------------------------");				
			} 
			catch (SAXException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			strDeviceValue = findNodeByXPath( myDoc, "/DeviceInformation/device/model");
			if (strDeviceValue == null)
				strDeviceValue = "Device Unknown";
			request.setAttribute("DeviceModel", strDeviceValue);
			dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file where model is set to: "+strDeviceValue, 2);
			
			strDeviceValue = "";			
			strDeviceValue = findNodeByXPath( myDoc, "/DeviceInformation/display/colorspace");
			if (strDeviceValue == null)
				strDeviceValue = "Color Unknown";
			request.setAttribute("Color", strDeviceValue);
			dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file where color is set to: "+strDeviceValue, 2);					
			strDeviceValue = "";
			strDeviceValue = findNodeByXPath( myDoc, "/DeviceInformation/version/eipSoftware/majorVersion");
			if (strDeviceValue == null)
				strDeviceValue = "1";
			request.setAttribute("EipVersion", strDeviceValue);
			dem.writeAboutLogs("Debug", "Inside doGet method of DeviceConfig file where Version is set to: "+strDeviceValue, 2);
		}
		catch (Exception e) 
		{
			System.out.println("error occured in DeviceConfig .java");
			System.out.println(e.getMessage());	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        @SuppressWarnings("rawtypes")
		java.util.Enumeration names = request.getHeaderNames();
        while(names.hasMoreElements())
        {
            String name = (String) names.nextElement();
        }
        
		try
		{
			System.out.println("Inside try of Demopage.jsp request Dispatcher");
			dem.writeAboutLogs("info", "Inside requestDispatcher of doGet method of DeviceConfig file -> Demopage.jsp", 2);
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/Demopage.jsp");
			reqDispatcher.forward(request, response);
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());		
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
	
	private Document getDeviceInformationAsDocument( String strDeviceInfo )
	{
		org.w3c.dom.Document doc=null;
		 dem.writeAboutLogs("Debug", "Inside getDeviceInformationAsDocument method of DeviceConfig file where DeviceInfo is: "+strDeviceInfo, 2);
		try
		{
			javax.xml.parsers.DocumentBuilderFactory factory =
			        javax.xml.parsers.DocumentBuilderFactory.newInstance();
			    factory.setNamespaceAware(true);
			    javax.xml.parsers.DocumentBuilder builder = null;
			    try {
			        builder = factory.newDocumentBuilder();
			        }
                catch (javax.xml.parsers.ParserConfigurationException ex)
                {
	             }  
			    doc = builder.parse(new ByteArrayInputStream(strDeviceInfo.getBytes("UTF-8")));
			    return doc;
		}
		catch(Exception ex)
		{ 
			dem.writeAboutLogs("Error", "Inside catch block of getDeviceInformationAsDocument method of DeviceConfig file where message is: "+ex.getMessage(), 2);
		}
		return doc;
	}
	
	private static String findNodeByXPath(Document doc, String strXPath )
	{
		// Create a XPathFactory
	    XPathFactory xFactory = XPathFactory.newInstance();
	    XPathExpression expr = null;

	    // Create a XPath object
	    XPath xpath = xFactory.newXPath();
	    
	    Node node = null;
		try {
			
			node = (Node) xpath.evaluate(strXPath, doc, XPathConstants.NODE);
		} catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	    return node.getTextContent();
	}

	private void WriteToFile(String strFilePath, String strInputXML)
	{
		dem.writeAboutLogs("Info", "Entering the WriteToFile method of DeviceConfig file", 2);
		FileOutputStream fop = null;
		File file;
		
		try
		{
 
			file = new File(strFilePath);
			fop = new FileOutputStream(file);
			dem.writeAboutLogs("Debug", "Entering the try catch section in WriteToFile method of DeviceConfig file having filepath: "+strFilePath, 2);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			// get the content in bytes
			byte[] contentInBytes = strInputXML.getBytes();
 
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
 
	
 
		} 
		catch (IOException e) 
		{
			dem.writeAboutLogs("Error", "Entering the catch section of WriteToFile method of DeviceConfig file having argument: "+e.getMessage(), 2);
			e.printStackTrace();
		}	
	
	}

}
