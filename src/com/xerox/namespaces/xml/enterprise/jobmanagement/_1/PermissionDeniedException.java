
/**
 * PermissionDeniedException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.namespaces.xml.enterprise.jobmanagement._1;

public class PermissionDeniedException extends java.lang.Exception{

    private static final long serialVersionUID = 1359407140731L;
    
    private com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.PermissionDeniedE faultMessage;

    
        public PermissionDeniedException() {
            super("PermissionDeniedException");
        }

        public PermissionDeniedException(java.lang.String s) {
           super(s);
        }

        public PermissionDeniedException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public PermissionDeniedException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.PermissionDeniedE msg){
       faultMessage = msg;
    }
    
    public com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.PermissionDeniedE getFaultMessage(){
       return faultMessage;
    }
}
    