//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.axis2.AxisFault;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.xerox.namespaces.xml.enterprise.jobmanagement._1.FailToProcessRequestException;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.GetJobDetailsRequest;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.GetJobDetailsRequestType;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.GetJobDetailsResponse;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.GetJobDetailsResponseType;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.IdString;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.IdforJob;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.JobIdentifier;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.ServiceType;
import com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobNotFoundException;


public class ScanJobManagement
    {
        int SCAN_CHECK_MAX =120;

     
        //Log log;
        private static final String FMT_URL = "https://%1$s/%2$s";
    	private static final String FMT_NOSSL_URL = "http://%1$s/%2$s";
    	private boolean bSecured = false; 
    	private String sDevice = "";
    	private String sServiceURL = "";
    	private String sWebserviceLocation = "webservices/JobManagement/1/";
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
    		sDevice = value;
    	}

    	private String getServiceURL() {

    		return sServiceURL;

    	}

    	private void setServiceURL(String value) {
    		sServiceURL = value;
    	}

    	private String BuildUri(String Destination) {
    		dem.writeAboutLogs("Info", "Entering the BuildUri method of ScanJobManagement file", 2);
    		String DestinationUri = "";
    		if (bSecured) {
    			DestinationUri = String.format(FMT_URL, Destination,
    					sWebserviceLocation);
    		} else {
    			DestinationUri = String.format(FMT_NOSSL_URL, Destination,
    					sWebserviceLocation);
    		}
    		dem.writeAboutLogs("Debug", "Inside BuildUri method of ScanJobManagement file having DestinationUri: "+DestinationUri, 2);
    		return DestinationUri;
    	}
    	private String BuildSimpleUri(String Destination) {
    		dem.writeAboutLogs("Info", "Entering the BuildSimpleUri method of ScanJobManagement file", 2);
    		String DestinationUri = "";
    		if (bSecured) {
    			DestinationUri = String.format(FMT_URL, Destination);
    		} else {
    			DestinationUri = String.format(FMT_NOSSL_URL, Destination);
    		}
    		dem.writeAboutLogs("Debug", "Inside BuildSimpleUri method of ScanJobManagement file having DestinationUri: "+DestinationUri, 2);
    		return DestinationUri;
    	}

        public ScanJobManagement(String logLocation)
        {
          
            dem=new DemAppLog();
           
        }

        public boolean checkJobStatus(String deviceAddr, String jobId)
        {
        	
        	System.out.println("max "+SCAN_CHECK_MAX);
        	dem.writeAboutLogs("Info", "Entering the checkJobStatus method of ScanJobManagement file", 2);
        	dem.writeAboutLogs("Debug", "Inside checkJobStatus method of ScanJobManagement file having deviceAddr: "+deviceAddr, 2);
        	System.out.println("Inside CheckJobStatus: deviceAddr=" + deviceAddr);
            boolean isJobCompleted = false;
            boolean isJobSuccessful = false;
            int i = 0;

            while ((!isJobSuccessful) && (i < SCAN_CHECK_MAX))
            {
            	
            	setDevice(deviceAddr);

        		setSecured(false);
        	    setServiceURL(BuildUri(getDevice()));
        	    JobManagementServiceStub proxy = null;
				try {
						dem.writeAboutLogs("Info", "Entering the try-catch block in checkJobStatus  method of ScanJobManagement file", 2);
						proxy = new JobManagementServiceStub(getServiceURL());
				
				   } 
				    catch (AxisFault e)
				    {
					   dem.writeAboutLogs("Error", "Entering the catch block in checkJobStatus  method of ScanJobManagement file with arg: "+e.getMessage(), 2);
					// TODO Auto-generated catch block
					   e.printStackTrace();
				    }
        	    GetJobDetailsRequest objGetJobDtlsReq = new GetJobDetailsRequest();
        	    GetJobDetailsRequestType objGetJobDtlsReqType = new GetJobDetailsRequestType();
        	    JobIdentifier objJobId = new JobIdentifier();
        	    IdforJob objId4Job = new IdforJob();
        	    IdString objIdStr = new IdString();
        	    
        	    objId4Job.setIdforJob(jobId);
        	    objIdStr.setIdString("JobId");
        	    dem.writeAboutLogs("Info", "Inside checkJobStatus method of ScanJobManagement file setting jobId", 2);
        	    objJobId.setJobIdentifierString(objId4Job);
        	    objJobId.setJobIdentifierType(objIdStr);
        	    
        	    ServiceType objSvcType = new ServiceType();
        	    objSvcType.setServiceType("WorkflowScanning");
        	    dem.writeAboutLogs("Info", "Inside checkJobStatus method of ScanJobManagement file setting WorkflowScanning", 2);
        	    objGetJobDtlsReqType.setJobData(objJobId);
        	    objGetJobDtlsReqType.setJobType(objSvcType);
        	            	    
        	    objGetJobDtlsReq.setGetJobDetailsRequest(objGetJobDtlsReqType);
        	    
        	    GetJobDetailsResponse objGetJobDtlsResp = null;
				try {
					
						objGetJobDtlsResp = proxy.getJobDetails(objGetJobDtlsReq);
						
					} 
					catch (RemoteException e)
					{
						dem.writeAboutLogs("Error", e.getMessage(), 2);
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					catch (FailToProcessRequestException e)
					{
						dem.writeAboutLogs("Error", e.getMessage(), 2);
						e.printStackTrace();
					} catch (JobNotFoundException e)
					{
						dem.writeAboutLogs("Error", e.getMessage(), 2);
						e.printStackTrace();
					}
        	    GetJobDetailsResponseType objGetJobDtlsRespType = objGetJobDtlsResp.getGetJobDetailsResponse();
        	    String strJobInfoXml = objGetJobDtlsRespType.getJobInfoXmlDocument();
        	  
        		//String strJobInfoXmlFilePath = "C:/Temp/JobInfo.xml";
        	   // String strDeviceConfigFilePath=System.getProperty("user.dir");
        	    //String strJobInfoXmlFilePath=strDeviceConfigFilePath.substring(0,(strDeviceConfigFilePath.length()-4))+"\\webapps\\DemoApp\\JobInfo.xml";;
        	    String strClassPath=getClass().getClassLoader().getResource("").getPath(); //upto classes folder
        	    String strJobInfoXmlFilePath=strClassPath.substring(0,(strClassPath.length()-9))+"//logs//JobInfo.xml";
        	    URI outputURI = null;
        		try {
        			outputURI = new URI(("file:///"+ strJobInfoXmlFilePath.replaceAll(" ", "%20")));
        		} catch (URISyntaxException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}   
        	    dem.writeAboutLogs("Info", "Writing job details to file "+strJobInfoXmlFilePath , 2);
        	    dem.writeAboutLogs("Info", "Writing job details with content "+strJobInfoXml , 2);
        	    WriteToFile(outputURI.getPath(),strJobInfoXml);
        		
        		String strJobState = "";
        		String strJobStateReasons = "";
        		try 
        		{
        			dem.writeAboutLogs("Info", "Entering the try-catch block in checkJobStatus  method of ScanJobManagement file", 2);
        		    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        		    dbf.setValidating(false);  
        		    DocumentBuilder db = null;
        			try 
        			{
        				db = dbf.newDocumentBuilder();
        			} 
        			catch (ParserConfigurationException e) 
        			{
        				dem.writeAboutLogs("Error", e.getMessage(),2);
        				e.printStackTrace();
        			}  
        			String strDeviceValue = "";
        			Document myDoc = null;
        			try 
        			{
        			//	myDoc = db.parse(new FileInputStream(new File(strJobInfoXmlFilePath)));
        				InputStream is = new ByteArrayInputStream(strJobInfoXml.getBytes());
        				myDoc = db.parse(is);
        			} 
        			catch (SAXException e) 
        			{
        				dem.writeAboutLogs("Error", "Entering catch block in checkJobStatus  method of ScanJobManagement file "+e.getMessage(),2);
        				e.printStackTrace();
        			} 
        			
        			dem.writeAboutLogs("Debug", "Before getting Jobstate",2);
        			NodeList nljs=myDoc.getElementsByTagName("eipjobmodel:JobState");
        			if(nljs.getLength()!=0)
        			{
        				strJobState = findNodeByXPath( myDoc, "//*[name()='eipjobmodel:JobState']");
        			}
        			else
        			{
        			//dem.writeAboutLogs("Debug", "job state null",2);
        			//if(strJobState==null)
        				strJobState = findNodeByXPath( myDoc, "//*[name()='JobState']");
        				dem.writeAboutLogs("Debug", "job state inside if "+strJobState,2);
        			}
        			dem.writeAboutLogs("Debug", "After getting Jobstate",2);
        			dem.writeAboutLogs("Debug", "Before getting JobstateReason",2);
        			NodeList nljsr=myDoc.getElementsByTagName("eipjobmodel:JobStateReasons");
        			if(nljsr.getLength()!=0)
        			{
        				strJobStateReasons = findNodeByXPath( myDoc, "//*[name()='eipjobmodel:JobStateReasons']");
        			}else
        			//if(strJobStateReasons==null)
        			{
        				strJobStateReasons = findNodeByXPath( myDoc, "//*[name()='JobStateReasons']");
        				dem.writeAboutLogs("Debug", "JobStateReasons inside if "+strJobStateReasons,2);
        			}
        			dem.writeAboutLogs("Debug", "After getting eipjobmodel:JobStateReasons",2);
        			dem.writeAboutLogs("Debug", "Inside checkJobStatus method of ScanJobManagement file having strJobState: "+strJobState, 2);
        			dem.writeAboutLogs("Debug", "Inside checkJobStatus method of ScanJobManagement file having strJobStateReasons: "+strJobStateReasons, 2);
        			
        		}
        		catch (Exception e) 
        		{
        			dem.writeAboutLogs("Error", "Entering the catch block(document building) in checkJobStatus  method of ScanJobManagement file with arg: "+e.getMessage(), 2);
        			e.printStackTrace();
        		}
                
                if (strJobState.equalsIgnoreCase("Pending") || strJobState.equalsIgnoreCase("PendingHeld") || strJobState.equalsIgnoreCase("Processing") || strJobState.equalsIgnoreCase("ProcessingStopped"))
                {
                	
                  //  log.DebugLog("job in processing state");
                    try {
	                    	System.out.println("Pending or PendingHeld or Processing or ProcessingStopped");
	                    	dem.writeAboutLogs("Info", "Inside checkJobStatus  method of ScanJobManagement file where it is Pending or PendingHeld or Processing or ProcessingStopped", 2);
							Thread.currentThread().sleep(1000);
						} 
	                    catch (InterruptedException e)
	                    {
							dem.writeAboutLogs("Error", e.getMessage(),2);
							e.printStackTrace();
						}
                }
                if (strJobState.equalsIgnoreCase("Aborted") || strJobState.equalsIgnoreCase("Canceled") || strJobState.equalsIgnoreCase("Completed"))
                {
                	
                    isJobCompleted = true;
                    i++;
                    System.out.println("value of i :::::;"+i);
                    System.out.println("Aborted or Canceled or Completed");
                    dem.writeAboutLogs("Info", "value of i "+i, 2);
                    dem.writeAboutLogs("Info", "Inside checkJobStatus  method of ScanJobManagement file where it is Aborted or Canceled or Completed", 2);
                    boolean bRet = strJobStateReasons.equalsIgnoreCase("JobCompletedSuccessfully");
                    if (bRet)
                    {
                    	isJobSuccessful = true;
                    	dem.writeAboutLogs("Info", "job state in isJobSuccessful "+isJobSuccessful, 2);
                    	 return isJobSuccessful;
                    }

                }
                else
                {
                    i++;
                    System.out.println("value of i :::::;"+i);
                    dem.writeAboutLogs("Info", "value of i inside else "+i, 2);
                }
            }
            return isJobSuccessful;
        }
        
    	private void WriteToFile(String strFilePath, String strInputXML)
    	{
    		dem.writeAboutLogs("Info", "Entering the WriteToFile method of ScanJobManagement file", 2);
    		FileOutputStream fop = null;
    		File file;
    		
    		try
    		{
     
    			file = new File(strFilePath);
    			fop = new FileOutputStream(file);
    			dem.writeAboutLogs("Debug", "Entering the try catch section in WriteToFile method of ScanJobManagement file having filepath: "+strFilePath, 2);
    			// if file doesnt exists, then create it
    			if (!file.exists()) {
    				file.createNewFile();
    			}
     
    			// get the content in bytes
    			byte[] contentInBytes = strInputXML.getBytes();
     
    			fop.write(contentInBytes);
    			fop.flush();
    			fop.close();
    			dem.writeAboutLogs("Debug", "Exiting from  the try catch section in WriteToFile method of ScanJobManagement",2);
    		} 
    		catch (IOException e) 
    		{
    			dem.writeAboutLogs("Error", "Entering the catch section of WriteToFile method of ScanJobManagement file having argument: "+e.getMessage(), 2);
    			e.printStackTrace();
    		}	
    	
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
	    		} 
	    	catch (XPathExpressionException e)
	    		{
	    			System.out.println("Error on findNodeByXPath method of ScanJobManagement : "+e.getMessage());
	    			e.printStackTrace();
	    			return null;
	    		}  
  
    	    return node.getTextContent();
    	}

    }