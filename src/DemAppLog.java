//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;


public class DemAppLog {
	

	public void writeAboutLogs(String mName,String info,int flag)
	{
		
		DocumentBuilderFactory docFact=DocumentBuilderFactory.newInstance();
		Document doc=null;
		Element root=null;
		Date dt=new Date();
		String xmlDecl =  "type=\"text/xsl\" href=\"Log.xsl\"";
		String strClassPath=getClass().getClassLoader().getResource("").getPath(); //upto classes folder
		//System.out.println("strClassPath path ==============" + strClassPath); 
		String strLogPath=strClassPath.substring(0,(strClassPath.length()-9));
		//System.out.println("strLogPath path ==============" + strLogPath);
		strLogPath = strLogPath + "//logs//log.xml";
		//System.out.println("After log path");
		URI outputURI = null;
		try {
			outputURI = new URI(("file:///"+ strLogPath.replaceAll(" ", "%20")));
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
		//System.out.println("After xml path"+strLogPath);

		SimpleDateFormat dtFormat=new SimpleDateFormat("HH:mm a dd/mm/yyyy");
			try {
				
				DocumentBuilder docBuild;
				docBuild = docFact.newDocumentBuilder();
				String time=dtFormat.format(dt);

				if(flag==2)
				{
				System.out.println("flag "+2);
			//	doc=docBuild.parse(outputURI.getPath());
				File file=new File( outputURI);
				doc=docBuild.parse(file);
				root=doc.getDocumentElement();
				//System.out.println("after flag "+2);
				}
				else if(flag==1)
				    {	
					File file=new File( outputURI);
					if (file.exists())
					{
						System.out.println("File exists in Log path");	
						file.delete();
						System.out.println("File deleted in Log path");
					}
					else
					{
						file.createNewFile();
					}

					doc=docBuild.newDocument();
					ProcessingInstruction process=doc.createProcessingInstruction("xml-stylesheet",xmlDecl);
					doc.insertBefore(process, root);
					root=doc.createElement("Logs");
					doc.appendChild(root);
					
					}
			    if(mName=="Info")
			    {
				Element Information=doc.createElement("Info");
				Element Description=doc.createElement("Desc");
				Description.appendChild(doc.createTextNode(info));
				Element Timestamp=doc.createElement("Timestamp");
				Timestamp.appendChild(doc.createTextNode(time));
				Information.appendChild(Timestamp);
				Information.appendChild(Description);
				root.appendChild(Information);
			    }
			    else if(mName=="Debug")
			    {
			    	Element Information=doc.createElement("Debug");
					Element Description=doc.createElement("Desc");
					Description.appendChild(doc.createTextNode(info));
					Element Timestamp=doc.createElement("Timestamp");
					Timestamp.appendChild(doc.createTextNode(time));
					Information.appendChild(Timestamp);
					Information.appendChild(Description);
					root.appendChild(Information);
			    }else if(mName=="Error")
			    {
			    	Element Information=doc.createElement("Error");
					Element Description=doc.createElement("Desc");
					Description.appendChild(doc.createTextNode(info));
					Element Timestamp=doc.createElement("Timestamp");
					Timestamp.appendChild(doc.createTextNode(time));
					Information.appendChild(Timestamp);
					Information.appendChild(Description);
					root.appendChild(Information);
			    }
			  
			    
			
				    TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer;
					transformer = transformerFactory.newTransformer();
				    DOMSource source = new DOMSource(doc);
				    StreamResult result = new StreamResult(new File(outputURI));
				   // StreamResult result = new StreamResult(new File("C:\\Program Files\\apache-tomcat-7.0.42\\webapps\\DemoApp\\WEB-INF\\Log.xml"));	
				    transformer.transform(source, result);
			    } 
			catch( Exception e) 
			    {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
			
	}

}
