# Weblogic JMS Driver

This bundle can be used to connect to Weblogic JMS Server using the Custom JMS Driver support in TIBCO ActiveMatrix BusinessWorks, TIBCO BusinessWorks Container Edition and TIBCO Cloud Integration.

## Driver jar requirements

Place the following JAR files in the lib folder:
* wlfullclient.jar

To use this bundle just import it into TIBCO BusinessStudio and add it to your Modules and Application. Alternatively you can export this as an OSGI jar and add it to your installation (or BWCE Base Image) to use it across applications.

Please note that Weblogic JMS driver doesn't behave well with OSGI hence extra classes need to be written under the decorators package in this bundle.

[Documentation on how Custom JMS Driver is supported can be found here](https://docs.tibco.com/pub/activematrix_businessworks/6.7.0/doc/html/GUID-2AC259A3-3C1C-4F27-8FD9-E7AF41D9CBEB.html)