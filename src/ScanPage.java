//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.axis2.databinding.types.xsd.DateTime;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;


/**
 * Servlet implementation class ScanPage
 */
public class ScanPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String community = "public";
	private String sSelectedProtocol = "";   
	private String completedReason ="";
	private DemAppLog dem;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScanPage() {
        super();
        dem =new DemAppLog();
        // TODO Auto-generated constructor stub
    }

    String strDocName;
    String TEMP_SCAN_FILE_LOCATION = "Temp";
    String sourcePath="";
    String TEMP_DEST_LOC="";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		dem.writeAboutLogs("Info", "Entering the doPost method of ScanPage file", 2);
		request.setAttribute("Username", request.getParameter("Username"));	
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having Username value: "+request.getParameter("Username"), 2);
		request.setAttribute("Password", request.getParameter("Password"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having Password value: "+request.getParameter("Password"), 2);
		request.setAttribute("DeviceModel",request.getParameter("DeviceModel"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having DeviceModel value: "+request.getParameter("DeviceModel"), 2);
		request.setAttribute("EipVersion", request.getParameter("EipVersion"));
		System.out.println("Eipversion on Scanpage"+request.getParameter("EipVersion"));
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having EipVersion value: "+request.getParameter("EipVersion"), 2);
		request.setAttribute("Color", request.getParameter("Color"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having Color value: "+request.getParameter("Color"), 2);
		request.setAttribute("Destination", request.getParameter("Destination"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having Destination value: "+request.getParameter("Destination"), 2);
		request.setAttribute("DocumentType",  request.getParameter("DocumentType"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having DocumentType value: "+request.getParameter("DocumentType"), 2);
		request.setAttribute("ColorOptions", request.getParameter("ColorOptions"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having ColorOptions value: "+request.getParameter("ColorOptions"), 2);
		request.setAttribute("Orientation" ,request.getParameter("Orientation"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having Orientation value: "+request.getParameter("Orientation"), 2);
		request.setAttribute("PageSides", request.getParameter("PageSides"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having PageSides value: "+request.getParameter("PageSides"), 2);
		request.setAttribute("PrintOptions", request.getParameter("PrintOptions"));
		System.out.println("Print Option on ScanPage"+request.getParameter("PrintOptions"));
		
		System.out.println("scren size inside Scanpage "+request.getParameter("ScreenSize"));
		request.setAttribute("ScreenSize", request.getParameter("ScreenSize"));
		request.setAttribute("JobID", request.getParameter("JobID"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having JobID value: "+request.getParameter("JobID"), 2);
		request.setAttribute("DocName", request.getParameter("DocName"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having DocName value: "+request.getParameter("DocName"), 2);
		request.setAttribute("ServerAddress", request.getParameter("ServerAddress"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having ServerAddress value: "+request.getParameter("ServerAddress"), 2);
		request.setAttribute("ServerLogin",  request.getParameter("ServerLogin"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having ServerLogin value: "+request.getParameter("ServerLogin"), 2);
		request.setAttribute("ScanLocation", request.getParameter("ScanLocation"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having ScanLocation value: "+request.getParameter("ScanLocation"), 2);
		request.setAttribute("RepositoryVolume", request.getParameter("RepositoryVolume"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having RepositoryVolume value: "+request.getParameter("RepositoryVolume"), 2);
		request.setAttribute("Community" ,request.getParameter("Community"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having Community value: "+request.getParameter("Community"), 2);
		request.setAttribute("RepositoryFiles", request.getParameter("RepositoryFiles"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having RepositoryFiles value: "+request.getParameter("RepositoryFiles"), 2);
		request.setAttribute("ClientIP", request.getParameter("ClientIP"));
		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having ClientIP value: "+request.getParameter("ClientIP"), 2);
		
		request.setAttribute("FTPServerIPAddress", request.getParameter("FTPServerIPAddress"));		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having FTPServerIPAddress value: "+request.getParameter("FTPServerIPAddress"), 2);
		
		request.setAttribute("SMBServerIPAddres",request.getParameter("SMBServerIPAddres"));		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having SMBServerIPAddress value: "+request.getParameter("SMBServerIPAddres"), 2);	
		
		request.setAttribute("SelectedProtocol", request.getParameter("SelectedProtocol"));		
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having SelectedProtocol value: "+request.getParameter("SelectedProtocol"), 2);

		//Kiruthika
		request.setAttribute("DocName",request.getParameter("DocName"));
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having DocName value: "+request.getParameter("DocName"), 2);
		strDocName = request.getParameter("DocName");
		
		String strJobID = request.getParameter("JobID");
		String strPath1 = getServletConfig().getServletContext().getContextPath();
		String strPath = getServletConfig().getServletContext().getRealPath(strPath1);
		String strFTPServerIPAddr = request.getParameter("FTPServerIPAddress");
		String strSMBServerIPAddr = request.getParameter("SMBServerIPAddres");
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having path value: "+strPath, 2);
		sSelectedProtocol = request.getParameter("SelectedProtocol");
		System.out.println("SelectedProtocol : " +sSelectedProtocol);
		dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file having SelectedProtocol : " +sSelectedProtocol, 2);
		int eipVersion =0;
		if(request.getParameter("EipVersion")!="")
		{
			eipVersion = Integer.parseInt(request.getParameter("EipVersion"));
		}
		System.out.println("Eip version inside scanpage.java "+eipVersion);
       // int eipVersion = Integer.parseInt(request.getParameter("EipVersion"));
        //intentionally hard-coded eipversion to test SNMP code.
       
		ScanJobManagement objSJM = new ScanJobManagement(strPath);
		
        boolean succeeded = false;
        if (eipVersion < 2)
        {
        	dem.writeAboutLogs("Info", "Entering the doPost method of ScanPage file where eipVersion < 2 ", 2);
        	dem.writeAboutLogs("Debug", "Inside the doPost method of ScanPage file where eipVersion: "+eipVersion, 2);
        	JOptionPane.showMessageDialog(null, "The application is not supporting eipversion less than TWO");
//        	JobStatus job = new JobStatus();//strPath, request.getParameter("Community"));
//         	succeeded=job.checkJobSuccess("13.121.176.42", strJobID);
        }
        else
        {
            try
            {
            dem.writeAboutLogs("Info", "Entering try-catch block of doPost method of ScanPage file", 2);	
            dem.writeAboutLogs("Debug", "Inside the try block of doPost method of ScanPage file where eipVersion: "+eipVersion, 2);
            //succeeded = objSJM.checkJobStatus(request.getRemoteHost(), strJobID,Integer.parseInt(request.getParameter("MaxCount")));
            succeeded = objSJM.checkJobStatus(request.getRemoteHost(), strJobID);
            }
            catch (Exception ex)
            {   dem.writeAboutLogs("Error", "Scan Operation Failed.. "+ex.getMessage(), 2);
            	//dem.writeAboutLogs("Error", "Entering the catch block in doPost  method of ScanPage file with arg: "+ex.getMessage(), 2);
            	System.out.println("Completed Reason inside ScanPage :::failed");
   			    completedReason = "ScanJob(JobID=" + strJobID + ")---failed";
            }
        }
//        
//
        if (succeeded)
		{ dem.writeAboutLogs("Info", "Job completed successfully - waiting for filing", 2);
        //	System.out.println ("completedReason  :: succeded");
        	completedReason = "ScanJob(JobID=" + strJobID + ")---succeeded";
        	String strFile = "";
        	System.out.println ("About to Retrieve SCan File");
        	// Retrieve the new file in repository
        	if(sSelectedProtocol.equalsIgnoreCase("SMB"))
        	{
        		
        		System.out.println("Local Addr : " +request.getLocalAddr());
        		System.out.println("ScanLocation : " +request.getParameter("ScanLocation"));
        		dem.writeAboutLogs("Debug", "Inside doPost method of ScanPage file (FTP) where Local Addr : " +request.getLocalAddr(), 2);
        		dem.writeAboutLogs("Debug", "Inside doPost method of ScanPage file (FTP) where ScanLocation : " +request.getParameter("ScanLocation"), 2);
        		strFile = RetrieveScanFile(strSMBServerIPAddr, request.getParameter("ScanLocation"), request.getParameter("RepositoryVolume"));
        	}
        	else
        	{
        		 System.out.println("ScanLocation : " +request.getParameter("ScanLocation"));
        		 dem.writeAboutLogs("Debug", "Inside doPost method of ScanPage file where ScanLocation(Other than SMB) : " +request.getParameter("ScanLocation"), 2);
        		// strFile = RetrieveScanFile(strFTPServerIPAddr, request.getParameter("ScanLocation"), "");
        	}
                       

        	try
        	{
				Thread.currentThread().sleep(60);
				dem.writeAboutLogs("Info", "Entering thread of doPost method of ScanPage file", 2);
			} 
            catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("Scanned File "+strFile);
        	System.out.println("Remote Host "+request.getRemoteHost());
			if (!strFile.equalsIgnoreCase("") && request.getParameter("PrintOptions").equalsIgnoreCase("Scan and Print"))
            {
				// Get the file to be printed
				System.out.println("Calling the Copy file to temporary directory function");
				System.out.println("Passing the scan file path and file name");
				//CopyFileToTemp(strFile,sourcePath);
				System.out.println("Inside Scan & print");
				SendPrint(strFile, request.getRemoteHost());
				System.out.println("Scan & print --> Successful");
	            //ClearRepository();
            }
			else
			{
				System.out.println("Inside Scan & print else loop");
				
			}		

		} 
		else
		{
			//System.out.println("Completed Reason :::failed");
			 completedReason = "ScanJob(JobID=" + strJobID + ")---failed";
		}
    	System.out.println("Completed Reason setting inside ScanPage  ::"+completedReason);
    	request.setAttribute("Reason", completedReason);
    	dem.writeAboutLogs("Info","------------------",2);
    	dem.writeAboutLogs("Info", request.toString(), 2);
		dem.writeAboutLogs("Info", response.toString(), 2);
		dem.writeAboutLogs("Info", "reason inside request "+request.getAttribute("Reason"),2);
	  	dem.writeAboutLogs("Info", "request.getRemoteHost()=" + request.getRemoteHost(), 2);
    	dem.writeAboutLogs("Info", "request.getLocalHost()=" + request.getLocalAddr(), 2);
    	dem.writeAboutLogs("Info", "request.getRemoteHost()=" + request.getRemoteAddr(), 2);
    	dem.writeAboutLogs("Info", "request.getRemoteHost()=" + request.getLocalName(), 2);
    	dem.writeAboutLogs("Info","------------------",2);
	request.setAttribute("Reason", completedReason);
  // 	System.out.println("Before calling changepage");
		ChangePage(request,  response);
		
	}
	
	/**
	* Send the new page to the printer via LPR. This method will block 
	* until the process is ended
	*
	* @param name	name of file to send 
	*/
	private void SendPrint( String strFile , String strClientIP)
	{
        try
        {
        	dem.writeAboutLogs("Info", "Entering the SendPrint method of ScanPage file ", 2);
        
        	dem.writeAboutLogs("Info", "Entering the SendPrint method of ScanPage file ", 2);
        	dem.writeAboutLogs("Debug", "Inside the SendPrint method of ScanPage file where file value is "+strFile, 2);
        	dem.writeAboutLogs("Debug", "Inside the SendPrint method of ScanPage file where ClientIP value is "+strClientIP, 2);
        	
        	//String strDir = TEMP_SCAN_FILE_LOCATION; 
        	
        	String strDir = sourcePath;
        	//anu
        	sourcePath=sourcePath+"\\"+strFile;
        	//anu
        	System.out.println(" Temp file folder"+strDir);
        	
        	//anu String strArgs = " -S \"" + strClientIP + "\" -P lp -J \"" + strFile + "\"" + " -d" +" \"" + strDir + "\\"+ strFile + "\"";
        	String strArgs = " -S \"" + strClientIP + "\" -P lp -J \"" + sourcePath + "\"" + " -d" +" \"" + strDir +"\""+" \""+ sourcePath + "\"";
        	
        	System.out.println ("strArgs in  SendPrint =" + strArgs);
        	Runtime.getRuntime().exec("lpr " + strArgs);
        	
/*        	ProcessBuilder pb = new ProcessBuilder("lpr",strArgs);
        	String strPWD = getServletConfig().getServletContext().getRealPath("");
        	
        	//strDir = strDir + "\\"+ strFile;
        	File file = new File(strPWD);
            pb.directory(file);
            pb.start();
            pb.wait();*/
        }
        catch (Exception exc)
        {
        	dem.writeAboutLogs("Error", "Entering the catch block in SendPrint  method of ScanPage file with arg: "+exc.getMessage(), 2);
        }
	}

    /*
     * Retrieve the scan file in repository
     * 
     * @return Filename
     */
    @SuppressWarnings("unchecked")
	private String RetrieveScanFile(String strServerAddress, String strScanLocation, String strRepositoryVolume)
    {
    	dem.writeAboutLogs("Info", "Entering the RetrieveScanFile method of ScanPage file ", 2);
    	String strScanFolder;
        String strRetFile = "";
        if(sSelectedProtocol.equalsIgnoreCase("SMB"))
    	{
        	strScanFolder = "\\\\" + strServerAddress + "\\" + strRepositoryVolume + "\\" + strScanLocation;
    	}
        else
        {
        	strScanFolder = "\\\\" + strServerAddress + "\\" + strScanLocation;
        }                
        System.out.println("strScanFolder = " +strScanFolder); 
        File folder = new File(strScanFolder);
        dem.writeAboutLogs("Debug", "Entering the RetrieveScanFile method of ScanPage file where ScanFolder is: "+strScanFolder, 2);
       
        File[] listOfFiles = folder.listFiles();
        File[] files=new File[listOfFiles.length];
        int count=0;
        if(listOfFiles != null)
        {
	        for (int i = 0; i < listOfFiles.length; i++) 
	        {
	        	if (listOfFiles[i].isFile()) 
	        	{
					String strFile = listOfFiles[i].getName();
					System.out.println ("List of Files: strFile=" + strFile);
					dem.writeAboutLogs("Debug", "Inside the RetrieveScanFile method of ScanPage file where List of Files: strFile= " + strFile, 2);
					int nPos = strFile.lastIndexOf('.');
					String strExt = strFile.substring(nPos);
					if (!strExt.equalsIgnoreCase(".xst"))
					{
						System.out.println ("Return this file: strFile=" + strFile);
						 dem.writeAboutLogs("Debug", "Inside the RetrieveScanFile method of ScanPage file where file returned is: "+strFile, 2);
						
						
						 if(strFile.contains(strDocName))
						 {
							files[count]= listOfFiles[i];
							 

							// Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
							 // get the File name
							 strRetFile = strFile;
							//anu sourcePath=strScanFolder+"\\"+strRetFile;
							 sourcePath=strScanFolder;
							 count=count+1;
							// System.out.println("Name of the First ="+strRetFile);
							// System.out.println("File location ="+sourcePath);
							// break;
						 }						
					}
	        	}        	
	    	}
        }
        File[] filesort=new File[count];
        for(int n=0;n<count;n++)
        {
        	if(files[n]!=null)
        	{
        	filesort[n]=files[n];
        	}
        }
        Arrays.sort(filesort, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        
        /*
        System.out.println("strRetFile = " +strRetFile);
        dem.writeAboutLogs("Debug", "Exiting the RetrieveScanFile method of ScanPage file where file returned is: "+strRetFile, 2);
        
        String strClassPath=getClass().getClassLoader().getResource("").getPath(); //upto classes folder
		System.out.println("strClassPath path ==============" + strClassPath); 
		String strTempPath=strClassPath.substring(0,(strClassPath.length()-9));
		System.out.println("strLogPath path ==============" + strTempPath);
		strTempPath = strTempPath + "//temp";
		
		String srcFilePath = strScanFolder + "\\" + strRetFile;
		String dstFilePath = strTempPath;
		
		System.out.println("After log path");
		URI outputURI = null;
		try
		{
			outputURI = new URI(("file:///"+ strTempPath.replaceAll(" ", "%20")));
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   		
        File file = new File(outputURI);
		if (!file.exists()) 
		{
	    	if (file.mkdir()) 
	    	{
	    			System.out.println("Directory is created!");
	    			dem.writeAboutLogs("Info", "Directory is created", 2);
	    	}
	    	else
	    	{
	    			System.out.println("Failed to create directory!");
	    			dem.writeAboutLogs("Info", "Failed to create directory", 2);
	    	}
	    }	
		
		try 
		{
			FileMoving(srcFilePath,dstFilePath,strRetFile);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
      //  return strRetFile;
        return filesort[0].getName();
    }

    /*public void FileMoving(String sourceFilePath, String destinationPath, String fileName) throws IOException 
    {
        File dstPathObject = new File(destinationPath);
        File srcFilePathObject = new File(sourceFilePath);
        if ((dstPathObject.isDirectory()) && (srcFilePathObject.isFile()))        
        {           
            File statusFileNameObject = new File(destinationPath + "/" + fileName);
            if (statusFileNameObject.isFile())            
            {               
                statusFileNameObject.delete();               
                FileUtils.copyFile(srcFilePathObject, statusFileNameObject);
            }
            else
            {
                FileUtils.copyFile(srcFilePathObject, statusFileNameObject);
            }
        }
    }*/
    
    private void ClearRepository()
    {
    	File TempFolder = new File(TEMP_DEST_LOC);
    	TempFolder.delete();
    	/*
    	File[] listOfFiles = TempFolder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) 
        {
        	if (listOfFiles[i].isFile()) 
        	{
        		listOfFiles[i].delete();
        	}        	
    	}*/
    }
    
    /***
	 * 
	 * Creating a temporary folder  and moving the file into that location 
     * @throws IOException 
	 */
	/*public void CopyFileToTemp(String strFile,String sourcePath)throws IOException
	{
		//temporary folder concept
		System.out.println("Creating a temporary folder in temp location in local");
		String tmpDirStr = System.getProperty("java.io.tmpdir");
	    if (tmpDirStr == null) {
	      throw new IOException(
	        "System property 'java.io.tmpdir' does not specify a tmp dir");
	    }
	    
	    File tmpDir = new File(tmpDirStr);
	    if (!tmpDir.exists()) {
	      boolean created = tmpDir.mkdirs();
	      if (!created) {
	        throw new IOException("Unable to create tmp dir " + tmpDir);
	      }
	    }
	   
	 
	    TEMP_DEST_LOC=tmpDir.getAbsolutePath();
	    System.out.println("Getting the destination location"+TEMP_DEST_LOC);
	    TEMP_SCAN_FILE_LOCATION=tmpDir.getAbsolutePath()+ "\\"+ strFile;
	    System.out.println("Getting the destination file location"+TEMP_SCAN_FILE_LOCATION);
	     
		File sourceLocation=new File(sourcePath);
		if(tmpDir.isDirectory()==true && sourceLocation.isFile()==true )
		{ 
	    		FileUtils.copyFileToDirectory(sourceLocation, tmpDir);
	  
		}
	}*/
	public void CopyFileToTemp(String strFile,String sourcePath) throws IOException
	{
		TEMP_DEST_LOC=this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		File path=new File(TEMP_DEST_LOC);
		Boolean flag=path.mkdir();
	
		System.out.println("strClassPath path ==============" + TEMP_DEST_LOC); 
		String DestTempLocation=path.getAbsolutePath()+ "\\"+ strFile;
		
		File sourceLocation=new File(sourcePath);
		TEMP_SCAN_FILE_LOCATION=DestTempLocation;
		if(path.isDirectory()==true && sourceLocation.isFile()==true )
		{
			FileUtils.copyFileToDirectory(sourceLocation, path);
		}
	
	}
	
    /*
     * Copy the files in file repository to \Scans folder, then 
     * clear the file repository.
     *
 
    private void ClearRepository()
    {
    	dem.writeAboutLogs("Info", "Entering the ClearRepository method of ScanPage file ", 2);
    	
    	File srcFolder = new File(TEMP_SCAN_FOLDER);
    	File file = new File(getServletConfig().getServletContext().getRealPath("") + "\\" + SCAN_FOLDER + "\\");
    	if (!file.exists()) {
    		if (file.mkdir()) {
    			System.out.println("Directory is created!");
    		} else {
    			System.out.println("Failed to create directory!");
    		}
    	}

    	File dstFolder = new File(getServletConfig().getServletContext().getRealPath("") + "\\" + SCAN_FOLDER + "\\");
    	System.out.println ("srcFolder=" + srcFolder);
    	System.out.println ("dstFolder=" + dstFolder);
    	dem.writeAboutLogs("Debug", "Inside the ClearRepository method of ScanPage file where srcFolder: "+srcFolder, 2);
    	dem.writeAboutLogs("Debug", "Inside the ClearRepository method of ScanPage file where dstFolder: "+dstFolder, 2);
    	
        File[] listOfFiles = srcFolder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) 
        {
        	if (listOfFiles[i].isFile()) 
        	{
        		System.out.println ("listOfFiles[i]=" + listOfFiles[i]);
        		System.out.println ("listOfFiles[i].getAbsolutePath()=" + listOfFiles[i].getAbsolutePath());
        		System.out.println ("listOfFiles[i].getName()=" + listOfFiles[i].getName());
        		System.out.println ("dstFolder + listOfFiles[i].getName()=" + dstFolder + listOfFiles[i].getName());
        		Copyfile(listOfFiles[i].getAbsolutePath(),dstFolder + "\\" + listOfFiles[i].getName());
        		listOfFiles[i].delete();
        	}        	
    	}
    }

    private static void Copyfile(String srFile, String dtFile)
    {
    	try
    	{
			File f1 = new File(srFile);
			File f2 = new File(dtFile);
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2);
			
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
			{
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			System.out.println("Successfully copied the file to destination");
		}
    	catch(FileNotFoundException ex)
    	{
    		
    		System.exit(0);
    	}
    	catch(IOException e)
    	{
    		System.out.println(e.getMessage());  
    	}
    }
  */
    private void ChangePage(HttpServletRequest request, HttpServletResponse response)
    {
    	dem.writeAboutLogs("Info", "Entering the ChangePage method of ScanPage file ", 2);
    	try
		{
    		dem.writeAboutLogs("Info", request.toString(), 2);
    		dem.writeAboutLogs("Info", response.toString(), 2);
    		dem.writeAboutLogs("Info", "reason inside request "+request.getAttribute("Reason"),2);
    	  	dem.writeAboutLogs("Info", "request.getRemoteHost()=" + request.getRemoteHost(), 2);
        	dem.writeAboutLogs("Info", "request.getLocalHost()=" + request.getLocalAddr(), 2);
        	dem.writeAboutLogs("Info", "request.getRemoteHost()=" + request.getRemoteAddr(), 2);
        	dem.writeAboutLogs("Info", "request.getRemoteHost()=" + request.getLocalName(), 2);
    	
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/PreMainPage.jsp");
    	//	RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/Test.jsp");
    		dem.writeAboutLogs("Info", "After setting request dispatcher in scanpage "+reqDispatcher, 2);
			reqDispatcher.forward(request, response);
		}
		catch(Exception ex)
		{
			dem.writeAboutLogs("Error", "Entering the catch block in ChangePage  method of ScanPage file with arg: "+ex.getMessage(), 2);
			System.out.println(ex.getMessage());		
		}
    }
    
      
   
}
