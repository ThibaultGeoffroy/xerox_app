
/**
 * JobManagementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.xerox.namespaces.xml.enterprise.jobmanagement._1;

    /**
     *  JobManagementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class JobManagementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public JobManagementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public JobManagementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for resumeJob method
            * override this method for handling normal response from resumeJob operation
            */
           public void receiveResultresumeJob(
                    com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.ResumeJobResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resumeJob operation
           */
            public void receiveErrorresumeJob(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelJob method
            * override this method for handling normal response from cancelJob operation
            */
           public void receiveResultcancelJob(
                    com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.CancelJobResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelJob operation
           */
            public void receiveErrorcancelJob(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInterfaceVersion method
            * override this method for handling normal response from getInterfaceVersion operation
            */
           public void receiveResultgetInterfaceVersion(
                    com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.GetInterfaceVersionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInterfaceVersion operation
           */
            public void receiveErrorgetInterfaceVersion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listCompletedJobQueue method
            * override this method for handling normal response from listCompletedJobQueue operation
            */
           public void receiveResultlistCompletedJobQueue(
                    com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.ListCompletedJobQueueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listCompletedJobQueue operation
           */
            public void receiveErrorlistCompletedJobQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pauseJob method
            * override this method for handling normal response from pauseJob operation
            */
           public void receiveResultpauseJob(
                    com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.PauseJobResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pauseJob operation
           */
            public void receiveErrorpauseJob(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listActiveJobQueue method
            * override this method for handling normal response from listActiveJobQueue operation
            */
           public void receiveResultlistActiveJobQueue(
                    com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.ListActiveJobQueueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listActiveJobQueue operation
           */
            public void receiveErrorlistActiveJobQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getJobDetails method
            * override this method for handling normal response from getJobDetails operation
            */
           public void receiveResultgetJobDetails(
                    com.xerox.namespaces.xml.enterprise.jobmanagement._1.JobManagementServiceStub.GetJobDetailsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getJobDetails operation
           */
            public void receiveErrorgetJobDetails(java.lang.Exception e) {
            }
                


    }
    