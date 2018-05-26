
/**
 * InvalidArgumentExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.www.webservices.office.cuisession._1;

public class InvalidArgumentExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1358280804978L;
    
    private com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.InvalidArgumentExceptionE faultMessage;

    
        public InvalidArgumentExceptionException() {
            super("InvalidArgumentExceptionException");
        }

        public InvalidArgumentExceptionException(java.lang.String s) {
           super(s);
        }

        public InvalidArgumentExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InvalidArgumentExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.InvalidArgumentExceptionE msg){
       faultMessage = msg;
    }
    
    public com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.InvalidArgumentExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    