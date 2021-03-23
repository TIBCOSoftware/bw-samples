# Teradata JDBC Driver

This bundle can be used to connect to Teradata using the Custom JDBC Driver support in TIBCO ActiveMatrix BusinessWorks 6.x, TIBCO BusinessWorks Container Edition and TIBCO Cloud Integration.

## Driver jar requirements

Place the following JAR files in the lib folder:
* terajdbc4.jar
* tdgssconfig.jar

To use this bundle just import it into TIBCO BusinessStudio and add it to your Modules and Application. Please note the driver class needs to match exactly with the JDBC Shared Resource driver class for this to function correctly.


[Documentation on how Custom JDBC Driver is supported can be found here](https://docs.tibco.com/pub/activematrix_businessworks/6.7.0/doc/html/GUID-DF12A927-F788-46DC-ABA1-0A1BA797DE2F.html)
