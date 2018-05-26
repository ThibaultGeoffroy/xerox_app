
/**
 * AccountingMethodNotFoundExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.xerox.www.webservices.office.cuisession._1;

public class AccountingMethodNotFoundExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1358280805007L;
    
    private com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.AccountingMethodNotFoundExceptionE faultMessage;

    
        public AccountingMethodNotFoundExceptionException() {
            super("AccountingMethodNotFoundExceptionException");
        }

        public AccountingMethodNotFoundExceptionException(java.lang.String s) {
           super(s);
        }

        public AccountingMethodNotFoundExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public AccountingMethodNotFoundExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.AccountingMethodNotFoundExceptionE msg){
       faultMessage = msg;
    }
    
    public com.xerox.www.webservices.office.cuisession._1.CUISessionServiceStub.AccountingMethodNotFoundExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    