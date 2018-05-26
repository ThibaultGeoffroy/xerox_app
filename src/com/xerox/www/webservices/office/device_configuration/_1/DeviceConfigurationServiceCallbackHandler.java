
/**
 * DeviceConfigurationServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.xerox.www.webservices.office.device_configuration._1;

    /**
     *  DeviceConfigurationServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DeviceConfigurationServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DeviceConfigurationServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DeviceConfigurationServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getDeviceCapabilities method
            * override this method for handling normal response from getDeviceCapabilities operation
            */
           public void receiveResultgetDeviceCapabilities(
                    com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.GetDeviceCapabilitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDeviceCapabilities operation
           */
            public void receiveErrorgetDeviceCapabilities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDeviceInformation method
            * override this method for handling normal response from getDeviceInformation operation
            */
           public void receiveResultgetDeviceInformation(
                    com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.DeviceInformationResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDeviceInformation operation
           */
            public void receiveErrorgetDeviceInformation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInterfaceVersion method
            * override this method for handling normal response from getInterfaceVersion operation
            */
           public void receiveResultgetInterfaceVersion(
                    com.xerox.www.webservices.office.device_configuration._1.DeviceConfigurationServiceStub.InterfaceVersionE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInterfaceVersion operation
           */
            public void receiveErrorgetInterfaceVersion(java.lang.Exception e) {
            }
                


    }
    