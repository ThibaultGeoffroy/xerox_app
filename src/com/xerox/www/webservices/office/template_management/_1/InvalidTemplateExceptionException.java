
/**
 * InvalidTemplateExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.www.webservices.office.template_management._1;

public class InvalidTemplateExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1358872483209L;
    
    private com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.InvalidTemplateExceptionE faultMessage;

    
        public InvalidTemplateExceptionException() {
            super("InvalidTemplateExceptionException");
        }

        public InvalidTemplateExceptionException(java.lang.String s) {
           super(s);
        }

        public InvalidTemplateExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InvalidTemplateExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.InvalidTemplateExceptionE msg){
       faultMessage = msg;
    }
    
    public com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.InvalidTemplateExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    