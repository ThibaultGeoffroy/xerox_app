
/**
 * XrxTemplateManagementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.xerox.www.webservices.office.template_management._1;

    /**
     *  XrxTemplateManagementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class XrxTemplateManagementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public XrxTemplateManagementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public XrxTemplateManagementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for restoreDefaultTemplate method
            * override this method for handling normal response from restoreDefaultTemplate operation
            */
           public void receiveResultrestoreDefaultTemplate(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ChecksumResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from restoreDefaultTemplate operation
           */
            public void receiveErrorrestoreDefaultTemplate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for putTemplate method
            * override this method for handling normal response from putTemplate operation
            */
           public void receiveResultputTemplate(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ChecksumResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from putTemplate operation
           */
            public void receiveErrorputTemplate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for replaceTemplate method
            * override this method for handling normal response from replaceTemplate operation
            */
           public void receiveResultreplaceTemplate(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ChecksumResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from replaceTemplate operation
           */
            public void receiveErrorreplaceTemplate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInterfaceVersion method
            * override this method for handling normal response from getInterfaceVersion operation
            */
           public void receiveResultgetInterfaceVersion(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.InterfaceVersionE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInterfaceVersion operation
           */
            public void receiveErrorgetInterfaceVersion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for replaceDefaultTemplate method
            * override this method for handling normal response from replaceDefaultTemplate operation
            */
           public void receiveResultreplaceDefaultTemplate(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.ChecksumResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from replaceDefaultTemplate operation
           */
            public void receiveErrorreplaceDefaultTemplate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteTemplate method
            * override this method for handling normal response from deleteTemplate operation
            */
           public void receiveResultdeleteTemplate(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.VoidResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteTemplate operation
           */
            public void receiveErrordeleteTemplate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listTemplates method
            * override this method for handling normal response from listTemplates operation
            */
           public void receiveResultlistTemplates(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.TemplateEntriesE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listTemplates operation
           */
            public void receiveErrorlistTemplates(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTemplate method
            * override this method for handling normal response from getTemplate operation
            */
           public void receiveResultgetTemplate(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.GetTemplateResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTemplate operation
           */
            public void receiveErrorgetTemplate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDefaultTemplate method
            * override this method for handling normal response from getDefaultTemplate operation
            */
           public void receiveResultgetDefaultTemplate(
                    com.xerox.www.webservices.office.template_management._1.XrxTemplateManagementServiceStub.GetTemplateResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDefaultTemplate operation
           */
            public void receiveErrorgetDefaultTemplate(java.lang.Exception e) {
            }
                


    }
    