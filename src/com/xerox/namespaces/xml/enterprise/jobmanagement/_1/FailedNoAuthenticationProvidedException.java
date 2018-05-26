
/**
 * FailedNoAuthenticationProvidedException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.namespaces.xml.enterprise.jobmanagement._1;

public class FailedNoAuthenticationProvidedException extends java.lang.Exception{

    private static final long serialVersionUID = 1359407140759L;
    
    private com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailedNoAuthenticationProvidedE faultMessage;

    
        public FailedNoAuthenticationProvidedException() {
            super("FailedNoAuthenticationProvidedException");
        }

        public FailedNoAuthenticationProvidedException(java.lang.String s) {
           super(s);
        }

        public FailedNoAuthenticationProvidedException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public FailedNoAuthenticationProvidedException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailedNoAuthenticationProvidedE msg){
       faultMessage = msg;
    }
    
    public com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailedNoAuthenticationProvidedE getFaultMessage(){
       return faultMessage;
    }
}
    