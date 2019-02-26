      
This project shows how you can use an API to collect monitoring data from TIBCO BusinessWorks™ applications. This can be further used to build a custom monitoring solution for TIBCO ActiveMatrix BusinessWorks™ 6.x and TIBCO BusinessWorks™ Container Edition

The 2 plugin projects contains the source code 
* tibco.bw.sample.application.execution.event.subscriber
* tibco.bw.sample.custom.monitoring.api
These can be imported in eclipse using the Import Project wizard.

## API Description

### Use Case : Display the Application Status
**Application to run** : com.tibco.sample.custom.monitoring.api  
**Demo Client Class involved** : BWApplicationEventSubscriber  
**Callback method at the client** : handleEvent()   
**Callback Received** : Event storing the current state of the application   
**Description** : This is the subscriber which gets a callback every time , there is a change in the state of the application

### Use Case : Display the application version 
**Application to Run** : com.tibco.sample.custom.monitoring.api  
**Demo Client Class involved** : ApplicationDataClient  
**Method to be called by the Client** : getApplications()  
**Output Received** : List of ApplicationRuntimeState  
**Description** : This is the client to get the application name and application version running. The API which client is using to get the info is ApplicationRuntimeStateApi which exposes the public methods.  
**Additional Comments** : For required API a bundle needs to be added. The required bundle is &quot;com.tibco.bw.frwk.custom.api.wrappers&quot;. This can be used as a bundle with others for testing purpose but would be the part of BW for the customer to use.

### Use Case :  Display Instance ID
**Application to run** : com.tibco.sample.custom.monitoring.api  
**Demo Client Class** : PCFENVInfo.java  
**Method to be called by the Client** : getInstanceID()  
**Output Received** : Instance Id(Type: String)  
**Description** : Getting the required Info from the System Variable

### Use Case : Display the end points details similar to end points tab in BWCE monitoring
 **Application to Run** : com.tibco.sample.custom.monitoring.api  
 **Demo Client Class involved** : ApplicationDataClient  
 **Method to be called by the Client** : getApplications()  
 **Output Received** : List of ApplicationRuntimeState  
 **Description** : This is the client to get the Exposed Endpoints by the applications. On the returned ApplicationRuntimeState , other API exposed to get the Endpoints needs to be called as done in the DEMO. The API which client is using to get the info is ApplicationRuntimeStateApi which exposes the public methods.  
 **Additional Comments** : For required API a bundle needs to be added. . The required bundle is &quot;com.tibco.bw.frwk.custom.api.wrappers&quot;. This can be used as a bundle with others for testing purpose but would be the part of BW for the customer to use.   
 
 ### Use Case : Display the Process Diagram Application to Run 
 
 ### Use Case : Process Instrumentation
 **Application to run** : tibco.bw.sample.application.execution.event.subscriber  
 **Demo Client Class** : BWEventSubscriber  
 **Callback method at the client** : handleEvent()   
 **Callback Received** : Event storing the instrumentation data
 **Description** :  Callback which gets called anytime instrumentation data is published in the Engine.    
 
 ### Use Case: Jobs Statistics- created ,running,faulted.scheduled,cancelled 
 **Application to run** : com.tibco.sample.custom.monitoring.api  
 **Demo Client Class** : JobMetricsEventSubscriber  
 **Methods to be called** : getRunningJobsCount, getCreatedJobsCount  
 **Output Received** : Metrics for the jobs  
 **Description** : The client can get the required metrics by calling the relative methods on the service instance as done in the Demo Client. To show the Demo a Timer client is used.
 
### Use Case :Activity Instrumentation
**Application to run** : tibco.bw.sample.application.execution.event.subscriber  
**Demo Client Class:** BWEventSubscriber  
**Callback method at the client** : handleEvent()  
**Callback Received** : Event storing the instrumentation data  
**Description** :  Callback which gets called anytime instrumentation data is published in the Engine.

### Use Case : Display all the module properties used by an application 
**Application to run** : com.tibco.sample.custom.monitoring.api  
**Demo Client Class** : ApplicationDataClient  
**Method to be called by the Client** : getConfigurations(\&lt;ApplicationName\&gt;,\&lt;Application Version\&gt;)  
**Output Received** : Maps having all the properties  
**Description** : This is the client to get the properties used by the applications. The API which client is using to get the info is ApplicationRuntimeStateApi which exposes the public methods.   
**Additional Comments** : For required API a bundle needs to be added. . The required bundle is &quot;com.tibco.bw.frwk.custom.api.wrappers&quot;. This can be used as a bundle with others for testing purpose but would be the part of BW for the customer to use. 

### Use Case : Get the input/output of the activities 
**Application to run** : tibco.bw.sample.application.execution.event.subscriber  
**Demo Client Class:** BWEventSubscriber  
**Callback method at the client** : handleEvent()  
**Callback Received** : Event storing the input / output of the activity depending on the state of the activity. The started state gets the input where completed state gets output for the activity.  
**Description** :  Callback which gets called anytime instrumentation data is published in the Engine which gets us the input /output of the activity.
