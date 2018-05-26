
/**
 * ValidationFailedException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.www.webservices.office.cuisession._1;

public class ValidationFailedException extends java.lang.Exception{

    private static final long serialVersionUID = 1358280804909L;
    
    private com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.ValidationFailedE faultMessage;

    
        public ValidationFailedException() {
            super("ValidationFailedException");
        }

        public ValidationFailedException(java.lang.String s) {
           super(s);
        }

        public ValidationFailedException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ValidationFailedException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.ValidationFailedE msg){
       faultMessage = msg;
    }
    
    public com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.ValidationFailedE getFaultMessage(){
       return faultMessage;
    }
}
    