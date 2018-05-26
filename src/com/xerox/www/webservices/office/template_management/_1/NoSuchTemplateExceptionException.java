
/**
 * NoSuchTemplateExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.www.webservices.office.template_management._1;

public class NoSuchTemplateExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1358872483225L;
    
    private com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.NoSuchTemplateExceptionE faultMessage;

    
        public NoSuchTemplateExceptionException() {
            super("NoSuchTemplateExceptionException");
        }

        public NoSuchTemplateExceptionException(java.lang.String s) {
           super(s);
        }

        public NoSuchTemplateExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public NoSuchTemplateExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.NoSuchTemplateExceptionE msg){
       faultMessage = msg;
    }
    
    public com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.NoSuchTemplateExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    