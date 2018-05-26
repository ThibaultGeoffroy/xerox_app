//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.AxisFault;

import com.xerox.www.webservices.office.template_management._1.InvalidChecksumExceptionException;
import com.xerox.www.webservices.office.template_management._1.InvalidTemplateExceptionException;
import com.xerox.www.webservices.office.template_management._1.InvalidTemplateNameException;
import com.xerox.www.webservices.office.template_management._1.NoSuchServiceExceptionException;
import com.xerox.www.webservices.office.template_management._1.NoSuchTemplateExceptionException;
import com.xerox.www.webservices.office.template_management._1.RepositoryFullExceptionException;
import com.xerox.www.webservices.office.template_management._1.TemplateExistsExceptionException;
import com.xerox.www.webservices.office.template_management._1.UnauthorizedExceptionException;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ChecksumResponse;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ChecksumResponseE;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.DeleteTemplateRequest;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.DeleteTemplateRequestE;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.GetTemplateResponse;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.GetTemplateResponseE;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ListTemplatesRequest;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ListTemplatesRequestE;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.PutTemplateRequest;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.PutTemplateRequestE;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.TemplateChecksum;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.TemplateContent;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.TemplateEntries;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.TemplateEntriesE;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.TemplateEntry;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.TemplateName;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.VoidResponse;
import com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.VoidResponseE;

/**
 * Servlet implementation class StartScanPage
 */
public class StartScanPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartScanPage() {
        super();
        dem=new DemAppLog();
        // TODO Auto-generated constructor stub
    }
    private String sSelectedProtocol = "";
	private DemAppLog dem;
   /* private static final String FMT_URL = "https://%1$s/%2$s";
	private static final String FMT_NOSSL_URL = "http://%1$s/%2$s";
	private boolean bSecured = false; 
	private String sDevice = "";
	private String sServiceURL = "";
	private String sWebserviceLocation = "webservices/office/template_management/1/";
										 
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
		return DestinationUri;
	}
	private String BuildSimpleUri(String Destination) {
		String DestinationUri = "";
		if (bSecured) {
			DestinationUri = String.format(FMT_URL, Destination);
		} else {
			DestinationUri = String.format(FMT_NOSSL_URL, Destination);
		}
		return DestinationUri;
	}*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		dem.writeAboutLogs("Info", "Entering the doGet method of StartScanPage file", 2);
		System.out.println("Inside StartScanPage.java");
		request.setAttribute("Username", request.getParameter("Username"));	
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having Username value: "+request.getParameter("Username"), 2);
		request.setAttribute("Password", request.getParameter("Password"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having Password value: "+request.getParameter("Password"), 2);
		request.setAttribute("DeviceModel",request.getParameter("DeviceModel"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having DeviceModel value: "+request.getParameter("DeviceModel"), 2);
		request.setAttribute("EipVersion", request.getParameter("EipVersion"));
		System.out.println("Eip version on StartScanpage"+request.getParameter("EipVersion"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having EipVersion value: "+request.getParameter("EipVersion"), 2);
		request.setAttribute("Color", request.getParameter("Color"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having Color value: "+request.getParameter("Color"), 2);
		request.setAttribute("Destination", request.getParameter("Destination"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having Destination value: "+request.getParameter("Destination"), 2);
		request.setAttribute("DocumentType",  request.getParameter("DocumentType"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having DocumentType value: "+request.getParameter("DocumentType"), 2);
		request.setAttribute("ColorOptions", request.getParameter("ColorOptions"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having ColorOptions value: "+request.getParameter("ColorOptions"), 2);
		request.setAttribute("Orientation" ,request.getParameter("Orientation"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having Orientation value: "+request.getParameter("Orientation"), 2);
		request.setAttribute("PageSides", request.getParameter("PageSides"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having PageSides value: "+request.getParameter("PageSides"), 2);
		request.setAttribute("PrintOptions", request.getParameter("PrintOptions"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having PrintOptions value: "+request.getParameter("PrintOptions"), 2);
		request.setAttribute("ScreenSize", request.getParameter("ScreenSize"));
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having ScreenSize value: "+request.getParameter("ScreenSize"), 2);
		dem.writeAboutLogs("Debug", "Inside the doGet method of StartScanPage file having ScreenSize value: "+request.getParameter("ScreenSize"), 2);
		System.out.println("Mode "+request.getParameter("Mode"));
		if(request.getParameter("Mode").equalsIgnoreCase("Cancel"))
		{	request.setAttribute("Reason", "Job canceled by user");
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/PreMainPage.jsp");
    		reqDispatcher.forward(request, response);
			
		}
		request.setAttribute("DocName",request.getParameter("DocName"));
		//request.setAttribute("ScanLocation", request.getParameter("ScanLocation"));
		//request.setAttribute("RepositoryVolume", request.getParameter("RepositoryVolume"));
		
		//SetTemplate(request, response);
		sSelectedProtocol = request.getParameter("SelectedProtocol");
		System.out.println("SelectedProtocol : " +sSelectedProtocol);
		dem.writeAboutLogs("Debug", "Inside doGet method of StartScanPage file with selected protocol: "+sSelectedProtocol, 2);
		request.setAttribute("SelectedProtocol", request.getParameter("SelectedProtocol"));
        try
		{
        	dem.writeAboutLogs("Info", "Entering the try-catch block in doGet method of StartScanPage file", 2);
			//RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/ScanPage.jsp");
        	if(sSelectedProtocol.equalsIgnoreCase("SMB"))
        	{
        		dem.writeAboutLogs("Debug", "Inside doGet method of StartScanPage file with SMB protocol", 2);
        		System.out.println("Inside SMB");
        		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/AppServerDetails.jsp");
        		reqDispatcher.forward(request, response);
        	}
        	else
        	{
        		dem.writeAboutLogs("Debug", "Inside doGet method of StartScanPage file with FTP protocol", 2);
        		System.out.println("Inside FTP");
        		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/FTPAppServerDetails.jsp");
        		reqDispatcher.forward(request, response);
        	}	
        	
		}
		catch(Exception ex)
		{
			dem.writeAboutLogs("Error", "Entering the catch block in doGet  method of StartScanPage file with arg: "+ex.getMessage(), 2);
			System.out.println(ex.getMessage());		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


	}

	/*void SetTemplate(HttpServletRequest request, HttpServletResponse response)
	{
		
		setDevice(request.getRemoteHost());
	    setSecured(false);
	    setServiceURL(BuildUri(getDevice()));
	    
		XrxTemplateManagementServiceStub proxy = null;
		try {
			proxy = new XrxTemplateManagementServiceStub(getServiceURL());
			
			} 
		catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ListTemplatesRequest objLstTmplReq = new ListTemplatesRequest();
		ListTemplatesRequestE objLstTmplReqE = new ListTemplatesRequestE();
		objLstTmplReqE.setListTemplatesRequest(objLstTmplReq);
		
		TemplateEntriesE objTmplEntriesE = null;
		try {
			
			objTmplEntriesE = proxy.listTemplates(objLstTmplReqE);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchServiceExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnauthorizedExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (objTmplEntriesE != null)
		{
			TemplateEntries objTmplEntries = objTmplEntriesE.getTemplateEntries();
			TemplateEntry objTmplEntry[] = objTmplEntries.getTemplateEntry();
			int nTmplCount = objTmplEntry.length;
			System.out.println(nTmplCount);
			
			int nCheckSum = 0;
	        for (int nIndex = 0; nIndex < objTmplEntry.length; ++nIndex)
	        {
	        	TemplateName tmplName = objTmplEntry[nIndex].getTemplateName();
	        	String strTmplName = tmplName.getTemplateName();
	        	if (strTmplName.equalsIgnoreCase("DemoTemplate_Test.xst"))
	            //if (strTmplName == "DemoTemplate_Test.xst")
	            {
	                TemplateChecksum objTmplCS = objTmplEntry[nIndex].getTemplateChecksum();
	                nCheckSum = objTmplCS.getTemplateChecksum();
	                break;
	            }
	        }
	        if (nCheckSum!=0)
	        {
	        	
	        	DeleteTemplate(getServiceURL(),"DemoTemplate_Test.xst",nCheckSum);
	        }
	        
	        //nCheckSum = UploadTemplate("http://13.61.2.177","DemoTemplate_Test.xst",CreateTemplate(request, response));
			nCheckSum = UploadTemplate(getServiceURL(),"DemoTemplate_Test.xst",CreateTemplate(request, response));
	       
		}
	}
	
	private boolean DeleteTemplate(String strURL,String strTmplName, int nCheckSum)
	{
		boolean bRet = false;
		
		XrxTemplateManagementServiceStub proxy = null;
		try {
			proxy = new XrxTemplateManagementServiceStub(strURL);
			//proxy = new XrxTemplateManagementServiceStub("http://13.121.176.42");
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DeleteTemplateRequest objDelTmplReq = new DeleteTemplateRequest();
		DeleteTemplateRequestE objDelTmplReqE = new DeleteTemplateRequestE();
		
		TemplateName objTmplName = new TemplateName();
		objTmplName.setTemplateName(strTmplName);
		
		TemplateChecksum objTmplCS = new TemplateChecksum();
		objTmplCS.setTemplateChecksum(nCheckSum);
		
		objDelTmplReq.setTemplateName(objTmplName);
		objDelTmplReq.setPriorChecksum(objTmplCS);
		objDelTmplReqE.setDeleteTemplateRequest(objDelTmplReq);
		
	 	VoidResponseE objVoidRespE = null;
		try {
			
			objVoidRespE = proxy.deleteTemplate(objDelTmplReqE);
			VoidResponse objVoidResp = new VoidResponse();
			objVoidResp = objVoidRespE.getVoidResponse();
			bRet = true;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchServiceExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidChecksumExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnauthorizedExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchTemplateExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bRet;
	}

	private String CreateTemplate(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("entering CreateTemplate");
		String[] strLogin = new String[2];
		String strSplitter = ",";
				
		String strOrnt = request.getParameter("Orientation");
		
		String strServerLogin = request.getParameter("ServerLogin");
		String strRepositoryVolume = request.getParameter("RepositoryVolume");
		
		if (!strServerLogin.isEmpty())
			strLogin = strServerLogin.split(strSplitter );
		
		System.out.println("strLogin[0]=" + strLogin[0]);
		
        String strTmpl = 
			"[service xrx_svc_general]\n"
			+ "{\n"
			+ "* enum_DCS DCSDefinitionUsed = DCS_GENERIC;\n"
			+ "* string JobTemplateLanguageVersion = \"4.00.07\";\n"
			+ "* enum_encoding JobTemplateCharacterEncoding = ASCII;\n"
			+ "* enum_confmethod ConfirmationMethod = PRINT;\n"
			+ "* enum_confstage ConfirmationStage = AFTER_JOB_COMPLETE;\n"
			+ "* string JobTemplateDescription = \"Scan Demo\";\n"
			+ "* string JobTemplateName = \"DemoTemplate_Test.xst\";\n"
			+ "}\n"
			+ "end\n"
			+ "\n"
			+ "[service xrx_svc_scan]\n"
			+ "{\n"
			+ "* enum_sided SidesToScan = " + ConvertValue(request.getParameter("PageSides")) + ";\n"
			+ "* enum_imagemode DocumentImageMode = TEXT;\n"
			+ "* integer CompressionQuality = 127;\n"
			+ "* enum_colormode ColorMode = " + ConvertValue(request.getParameter("ColorOptions")) + ";\n"
			+ "* enum_orientation InputOrientation = " + ConvertValue(request.getParameter("Orientation")) + ";\n"
			+ "}\n"
			+ "end\n"
			+ "\n"
			+ "[doc_object xrx_document]\n"
			+ "doc_1{\n"
			+ "* enum_resolution Resolution = RES_300X300;\n"
			+ "* enum_docformat DocumentFormat = " + ConvertValue(request.getParameter("DocumentType")) + ";\n"
			+ "* string DocumentObjectName = \"" + request.getParameter("DocName") + "\";\n"
			+ "}\n"
			+ "end\n"
			+ "\n"
			+ "[service XRX_SVC_FILE]\n"
			+ "file_1{\n"
			+ "* enum_filingpolicy DocumentFilingPolicy = GEN_DATE_TIME_ID;\n"
			+ "* string RepositoryAlias = \"share\";\n"
			+ "* string DocumentPath = \"" + request.getParameter("ScanLocation") + "\";\n"
            + "* string RepositoryName = \"" + request.getLocalAddr() + ":445" + "\";\n"
            + "* string RepositoryVolume = \"" + request.getParameter("RepositoryVolume") + "\";\n"
           // + "* string RepositoryName = \"" + request.getParameter("ServerAddress") + "\";\n"
			+ "* enum_filingprotocol FilingProtocol = SMB;\n"
            + "* string UserNetworkFilingLoginName = \"" + strLogin[0] + "\\\\" + strLogin[1] + "\";\n"
            + "* string UserNetworkFilingLoginID = \"" + strLogin[2] + "\";\n"
			+ "}\n"
			+ "end\n";
       
        //System.out.println("strTmpl in  CreateTemplate: "  +strTmpl);
		return strTmpl;
	}
	
	private int UploadTemplate(String strURL, String strTmplName, String strTemplate)
	{
				
		int nCSum = 0;
		PutTemplateRequest objPutTmplReq = new PutTemplateRequest();
		PutTemplateRequestE objPutTmplReqE = new PutTemplateRequestE();
		
		TemplateName objTmplName = new TemplateName();
		objTmplName.setTemplateName(strTmplName);
		
		TemplateContent objTmplCtnt = new TemplateContent();
		objTmplCtnt.setTemplateContent(strTemplate);
		
		objPutTmplReq.setTemplateName(objTmplName);
		objPutTmplReq.setTemplateContent(objTmplCtnt);
		
		objPutTmplReqE.setPutTemplateRequest(objPutTmplReq);
		
		XrxTemplateManagementServiceStub proxy = null;
		try {
			
			proxy = new XrxTemplateManagementServiceStub(strURL);
			//proxy = new XrxTemplateManagementServiceStub("http://13.121.176.42");
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		ChecksumResponseE objCSRespE = null;
		try {

			objCSRespE = proxy.putTemplate(objPutTmplReqE);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryFullExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchServiceExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnauthorizedExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateExistsExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTemplateExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChecksumResponse objCSResp = objCSRespE.getChecksumResponse();
		TemplateChecksum objTmplCS = objCSResp.getTemplateChecksum();
		nCSum = objTmplCS.getTemplateChecksum();
		
		return nCSum;
	}
	
	private String ConvertValue( String strValue )
	{
		//strValue = strValue.replace(" ", "");
		
		if (strValue.equals("PDF"))
			strValue = "PDF";
		
		if (strValue.equals("TIFF"))
			strValue = "TIFF_V6";
		
		if (strValue.equals("Portrait"))
			strValue = "PORTRAIT";
		
		if (strValue.equals("Landscape"))
			strValue = "LANDSCAPE";
		
		if (strValue.equals("One Sided"))
			strValue = "ONE_SIDED";
		
		if (strValue.equals("Two Sided"))
			strValue = "TWO_SIDED";
		
		if (strValue.equals("Second Side Rotation"))
			strValue = "SECOND_SIDE_ROTATION";
		
		if (strValue.equals("Color"))
			strValue = "FULL_COLOR";
		
		if (strValue.equals("Grayscale"))
			strValue = "GRAYSCALE";
		
		if (strValue.equals("Black and White"))
			strValue = "BLACK_AND_WHITE";
		
		return strValue;
	}*/
}
