
/**
 * InvalidStateExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.www.webservices.office.cuisession._1;

public class InvalidStateExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1358280804924L;
    
    private com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.InvalidStateExceptionE faultMessage;

    
        public InvalidStateExceptionException() {
            super("InvalidStateExceptionException");
        }

        public InvalidStateExceptionException(java.lang.String s) {
           super(s);
        }

        public InvalidStateExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InvalidStateExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.InvalidStateExceptionE msg){
       faultMessage = msg;
    }
    
    public com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.InvalidStateExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    