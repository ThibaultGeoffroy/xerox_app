//
//  Copyright (c) 2013 Xerox Corporation. All Rights Reserved.
//
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Log 
{
	// location of log directory
	String serverLocation;

	/**
	* Log writes the log statements given.
	*
	* @param location	physical location of home directory 
	*/
	public Log( String location )
	{
		serverLocation = location;
	}

	/**
	* Writes the given message to the debug log.
	*
	* @param msg	message to write 
	*/
	public void DebugLog( String msg )
	{
		FileWriter fw = null;
		try {
			
			fw = new FileWriter("D:\\Users\\Raja\\JavaSDKSamples\\DemoApp\\DebugLog\\DebugLog.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	* Writes the given message to the system log.
	*
	* @param msg	message to write 
	*/
	public void SysLog( String msg )
	{
		FileWriter fw = null;
		try {
			fw = new FileWriter(serverLocation + "\\Log\\SystemLog.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
