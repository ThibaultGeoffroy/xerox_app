
/**
 * FailedAuthenticationException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.namespaces.xml.enterprise.jobmanagement._1;

public class FailedAuthenticationException extends java.lang.Exception{

    private static final long serialVersionUID = 1359407140699L;
    
    private com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailedAuthenticationE faultMessage;

    
        public FailedAuthenticationException() {
            super("FailedAuthenticationException");
        }

        public FailedAuthenticationException(java.lang.String s) {
           super(s);
        }

        public FailedAuthenticationException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public FailedAuthenticationException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailedAuthenticationE msg){
       faultMessage = msg;
    }
    
    public com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.FailedAuthenticationE getFaultMessage(){
       return faultMessage;
    }
}
    