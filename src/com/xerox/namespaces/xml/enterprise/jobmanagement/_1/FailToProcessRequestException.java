
/**
 * FailToProcessRequestException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.namespaces.xml.enterprise.jobmanagement._1;

public class FailToProcessRequestException extends java.lang.Exception{

    private static final long serialVersionUID = 1359407140746L;
    
    private com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailToProcessRequestE faultMessage;

    
        public FailToProcessRequestException() {
            super("FailToProcessRequestException");
        }

        public FailToProcessRequestException(java.lang.String s) {
           super(s);
        }

        public FailToProcessRequestException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public FailToProcessRequestException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailToProcessRequestE msg){
       faultMessage = msg;
    }
    
    public com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailToProcessRequestE getFaultMessage(){
       return faultMessage;
    }
}
    