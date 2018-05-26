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
 * Servlet implementation class AppServerDetails
 */
public class AppServerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String strdomainName,strusrName,strpassword,strServerLogin,strRepositoryVolume,strDocumentPath;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppServerDetails() {
        super();
        dem=new DemAppLog();
        // TODO Auto-generated constructor stub
    }

    private static final String FMT_URL = "https://%1$s/%2$s";
   	private static final String FMT_NOSSL_URL = "http://%1$s/%2$s";
   	private boolean bSecured = false; 
   	private String sDevice = "";
   	private String sServiceURL = "";
   	private String sWebserviceLocation = "webservices/office/template_management/1/";
   	private DemAppLog dem;									 
   	private boolean getSecured()
   	{
   		return bSecured;
   	}

   	private void setSecured(boolean value)
   	{
   		bSecured = value;
   	}
   	
   	private String getDevice() 
   	{
   		return sDevice;
   	}

   	private void setDevice(String value)
   	{
   		sDevice = value;
   	}

   	private String getServiceURL() 
   	{
   		return sServiceURL;
   	}

   	private void setServiceURL(String value)
   	{
   		sServiceURL = value;
   	}

   	private String BuildUri(String Destination)
   	{
   		String DestinationUri = "";
   		if (bSecured)
   		{
   			DestinationUri = String.format(FMT_URL, Destination,
   					sWebserviceLocation);
   		} 
   		else 
   		{
   			DestinationUri = String.format(FMT_NOSSL_URL, Destination,
   					sWebserviceLocation);
   		}
   		dem.writeAboutLogs("Debug", "Inside BuildUri method of AppServerDetails file having DestinationUri: "+DestinationUri, 2);
   		return DestinationUri;
   	}
   	
   	private String BuildSimpleUri(String Destination) {
   		String DestinationUri = "";
   		if (bSecured) {
   			DestinationUri = String.format(FMT_URL, Destination);
   		} else {
   			DestinationUri = String.format(FMT_NOSSL_URL, Destination);
   		}
   		dem.writeAboutLogs("Debug", "Inside BuildSimpleUri method of AppServerDetails file having DestinationUri: "+DestinationUri, 2);
   		return DestinationUri;
   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		dem.writeAboutLogs("Info", "Entering the doPost method of AppServerDetails file", 2);
		System.out.println("Inside AppServerDetails.java");
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
		request.setAttribute("ScanLocation", request.getParameter("AppServerSubSharFol"));
		request.setAttribute("RepositoryVolume", request.getParameter("AppServerMainSharFol"));
		request.setAttribute("SelectedProtocol", request.getParameter("SelectedProtocol"));
		request.setAttribute("ScreenSize", request.getParameter("ScreenSize"));
		//Kiruthika
		request.setAttribute("DocName",request.getParameter("DocName"));
		
		strRepositoryVolume = request.getParameter("AppServerMainSharFol");
		dem.writeAboutLogs("Debug", "Inside doPost method of AppServerDetails file having Repository Volume: "+strRepositoryVolume, 2);
		strDocumentPath = request.getParameter("AppServerSubSharFol");
		dem.writeAboutLogs("Debug", "Inside doPost method of AppServerDetails file having Document Path: "+strDocumentPath, 2);
		strdomainName = request.getParameter("AppServerDomainName");
		dem.writeAboutLogs("Debug", "Inside doPost method of AppServerDetails file having domain Name: "+strdomainName, 2);
		strusrName = request.getParameter("AppServerUserName");
		dem.writeAboutLogs("Debug", "Inside doPost method of AppServerDetails file having user Name: "+strusrName, 2);
		strpassword = request.getParameter("AppServerPassword");
		dem.writeAboutLogs("Debug", "Inside doPost method of AppServerDetails file having password: "+strpassword, 2);
		strServerLogin = strdomainName + "," + strusrName + "," + strpassword;
		request.setAttribute("ServerLogin",strServerLogin);
		dem.writeAboutLogs("Debug", "Inside doPost method of AppServerDetails file having ipaddress: "+ request.getParameter("ApplblServerIPAddres"), 2);
		request.setAttribute("SMBServerIPAddres",request.getParameter("SMBServerIPAddres"));		
		
		SetTemplate(request, response);
		
		 try
		 {
			    dem.writeAboutLogs("Debug", "Inside request dipatcher of doPost method of AppServerDetails file ->ScanPage.jsp", 2);
				RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/ScanPage.jsp");				
				reqDispatcher.forward(request, response);
		 }
		 catch(Exception ex)
		 {
			 dem.writeAboutLogs("Error", "Inside request dipatcher catch block of doPost method of AppServerDetails file with message: "+ex.getMessage(), 2);
				System.out.println(ex.getMessage());		
		 }

	 }
	
	void SetTemplate(HttpServletRequest request, HttpServletResponse response)
	{
		dem.writeAboutLogs("Info", "Entering the SetTemplate method of AppServerDetails file", 2);
		setDevice(request.getRemoteHost());
	    setSecured(false);
	    setServiceURL(BuildUri(getDevice()));
	    dem.writeAboutLogs("Debug", "Inside SetTemplate method of AppServerDetails file setting Device: "+request.getRemoteHost(), 2);
	    dem.writeAboutLogs("Debug", "Inside SetTemplate method of AppServerDetails file setting ServiceURL: "+BuildUri(getDevice()), 2);
		XrxTemplateManagementServiceStub proxy = null;
		try {
			proxy = new XrxTemplateManagementServiceStub(getServiceURL());
			
			} 
		catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dem.writeAboutLogs("Error", "Inside SetTemplate catch block of doGet method of AppServerDetails file with message: "+e.getMessage(), 2);
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
			int nCheckSum = 0;
			TemplateEntries objTmplEntries = objTmplEntriesE.getTemplateEntries();
			TemplateEntry objTmplEntry[] = objTmplEntries.getTemplateEntry();
			if(objTmplEntry!=null)
			{
				int nTmplCount = objTmplEntry.length;
				System.out.println(nTmplCount);				
				dem.writeAboutLogs("Debug", "Inside SetTemplate method of AppServerDetails file having TmplCount: "+nTmplCount, 2);
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
			 }
		        //nCheckSum = UploadTemplate("http://13.61.2.177","DemoTemplate_Test.xst",CreateTemplate(request, response));
				nCheckSum = UploadTemplate(getServiceURL(),"DemoTemplate_Test.xst",CreateTemplate(request, response));	
				dem.writeAboutLogs("Debug", "Inside SetTemplate method of AppServerDetails file having nCheckSum: "+nCheckSum, 2);
		}
	}
	
	private boolean DeleteTemplate(String strURL,String strTmplName, int nCheckSum)
	{
		boolean bRet = false;
		dem.writeAboutLogs("Info", "Entering the DeleteTemplate method of AppServerDetails file", 2);
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
		dem.writeAboutLogs("Debug", "Inside DeleteTemplate method of AppServerDetails file setting strTmplName: "+strTmplName, 2);
		TemplateChecksum objTmplCS = new TemplateChecksum();
		objTmplCS.setTemplateChecksum(nCheckSum);
		dem.writeAboutLogs("Debug", "Inside DeleteTemplate method of AppServerDetails file setting nCheckSum: "+nCheckSum, 2);
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
		dem.writeAboutLogs("Info", "Entering the CreateTemplate method of AppServerDetails file", 2);
		System.out.println("entering CreateTemplate");
		String[] strLogin = new String[2];
		String strSplitter = ",";
				
		String strOrnt = request.getParameter("Orientation");
		dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with Orientaion value: "+strOrnt, 2);
		//String strServerLogin = request.getParameter("ServerLogin");
		//String strRepositoryVolume = request.getParameter("RepositoryVolume");
		
		if (!strServerLogin.isEmpty())
			strLogin = strServerLogin.split(strSplitter );
		
		
		System.out.println("AppServerSubSharFol :" +strDocumentPath);	
		System.out.println("AppServerMainSharFol :" +strRepositoryVolume);	
		System.out.println("AppServerDomainName :" +strdomainName);
		System.out.println("AppServerUserName : " +strusrName);
		System.out.println("AppServerPassword :" +strpassword);
		System.out.println("serverLogin :" +strServerLogin);
		System.out.println("strLogin[0]=" + strLogin[0]);
		System.out.println("strLogin[0]=" + strLogin[1]);
		System.out.println("strLogin[0]=" + strLogin[2]);
		dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with DocumentPath value: "+strDocumentPath, 2);
		dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with RepositoryVolume value: "+strRepositoryVolume, 2);
		dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with domainName value: "+strdomainName, 2);
		dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with usrName value: "+strusrName, 2);
		dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with password value: "+strpassword, 2);
		dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with ServerLogin value: "+strServerLogin, 2);
		String value;
		if(strLogin[0].isEmpty())
		{
			value= strLogin[1];
		}
		else
		{
			value= strLogin[0]+"\\"+strLogin[1];
		}
	/*	if(strDocumentPath.equals('/'))
		{
			strDocumentPath="\\";
		}*/
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
			+ "* string DocumentPath = \"" + strDocumentPath + "\";\n"
            //+ "* string RepositoryName = \"" + "10.105.21.165:445" + "\";\n"
            + "* string RepositoryName = \"" + request.getParameter("SMBServerIPAddres") + ":445" + "\";\n"
            + "* string RepositoryVolume = \"" + strRepositoryVolume + "\";\n"
           // + "* string RepositoryName = \"" + request.getParameter("ServerAddress") + "\";\n"
			+ "* enum_filingprotocol FilingProtocol = SMB;\n"
          //  + "* string UserNetworkFilingLoginName = \"" + strLogin[0] + "\\\\" + strLogin[1] + "\";\n"
          + "* string UserNetworkFilingLoginName = \""+ value+ "\";\n"
            + "* string UserNetworkFilingLoginID = \"" + strLogin[2] + "\";\n"
			+ "}\n"
			+ "end\n";
       
        System.out.println("strTmpl in  CreateTemplate: "  +strTmpl);
        dem.writeAboutLogs("Debug", "Inside CreateTemplate method of AppServerDetails file with CreateTemplate value: "+strTmpl, 2);
		return strTmpl;
	}
	
	private int UploadTemplate(String strURL, String strTmplName, String strTemplate)
	{
		dem.writeAboutLogs("Info", "Entering the UploadTemplate method of AppServerDetails file", 2);
				
		int nCSum = 0;
		PutTemplateRequest objPutTmplReq = new PutTemplateRequest();
		PutTemplateRequestE objPutTmplReqE = new PutTemplateRequestE();
		
		TemplateName objTmplName = new TemplateName();
		objTmplName.setTemplateName(strTmplName);
		dem.writeAboutLogs("Debug", "Inside UploadTemplate method of AppServerDetails file setting strTmplName: "+strTmplName, 2);
		TemplateContent objTmplCtnt = new TemplateContent();
		objTmplCtnt.setTemplateContent(strTemplate);
		dem.writeAboutLogs("Debug", "Inside UploadTemplate method of AppServerDetails file setting strTemplate: "+strTemplate, 2);
		objPutTmplReq.setTemplateName(objTmplName);
		objPutTmplReq.setTemplateContent(objTmplCtnt);
		
		objPutTmplReqE.setPutTemplateRequest(objPutTmplReq);
		
		XrxTemplateManagementServiceStub proxy = null;
		try {
			dem.writeAboutLogs("Debug", "Inside UploadTemplate method of AppServerDetails file having strURL: "+strURL, 2);
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
		dem.writeAboutLogs("Debug", "Exiting UploadTemplate method of AppServerDetails file having nCSum: "+nCSum, 2);
		return nCSum;
	}
	
	private String ConvertValue( String strValue )
	{
		//strValue = strValue.replace(" ", "");
		dem.writeAboutLogs("Debug", "Inside ConvertValue method of AppServerDetails file with value: "+strValue, 2);
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
		dem.writeAboutLogs("Debug", "Exiting ConvertValue method of AppServerDetails file with value: "+strValue, 2);
		return strValue;
	}

}
