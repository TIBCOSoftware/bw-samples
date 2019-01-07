# Steps to write custom config management code
Open the Bussiness Works (BW) studio. Go to file and select plug-in project from the list. Provide it a suitable name e.g. **com.tibco.bwce.profile.sample** in this sample.
After the project is created successfuly, right click on the src folder of the project to create a new package e.g. com.tico.bwce.profile.sample in this sample and right click on this package to create a new Java class e.g. **CustomConfigManagement** in this sample, with a main method. 
Import **com.tibco.bwce.profile.resolver** package in this class and write the custom config management code here with the help of the helper class.

The helper class that is provided in the package com.tibco.bwce.profile.resolver for the users is called **ProfileResolverHelper**.
This class has two methods: 
* **getKeysForConfig()** 
* **replaceProfileValues()**

The first method **getKeysForConfig()** returns a list of type string to the calling function.
* This list consists of all the keys that are required to be fetched by the user from the custom config management server.
* These keys are fetched from the **pcf.substvar** file.
* The keys in the pcf.substvar file are set through the profile created by the user in the properties section of the BW application in the studio.

Use getKeysForConfig() method to get a list of the required keys whose corresponding values are required to be fetched from the custom config management server.
Write code for connecting to the custom config management server in the new main class (CustomConfigManagement in this sample) and fetch the values for the corresponding keys collected using the method getKeysForConfig().

The second method **replaceProfileValues()** accepts a Map of type <String, Value> and has a void return type.
* Import the static class **Value** and enum **Type** from the package com.tibco.bwce.profile.resolver in the new class i.e. CustomConfigManagement in this case.
* The type of Value in the method replaceProfileValues() is defined by the Value class in the package com.tibco.bwce.profile.resolver
* The enum Type defined in the package com.tibco.bwce.profile.resolver defines three Type of values: ENV, SYSPROP and APPCONFIG where ENV means that the value is an environment variable, SYSPROP means the value is a system property and APPCONFIG  means that the value is an application configuration.
*	The static class Value has two reference variables called **value** and **type** that are used to define the value and its corresponding type (as mentioned above in enum).
* The keys and their corrsponding values fetched from the custom config server are given to this method as input.
* This method is used to replace the values of the corresponding keys in the final pcf.substvar file that is used to provide the profile values to the BW aplication.

The values of the  keys to be be fetched are hard coded in this sample and will be replaced by the user values fetched from the custom config server.

Once the code to connect to the config server and the code for retrieving the values of the corresponding keys is ready, create a JAR out of this package. Unzip the runtime zip for bwce 2.4.2 and then go to tibco.home/bwce/2.4/system/shared. Add here, the JAR with the custom config mangement code i.e. com.tibco.bwce.profile.sample.*.jar in this case. Once the JAR is added in the runtime zip, zip it back. 

The next step is to make changes in the setup.sh script present in the scripts folder in the location where bwce-docker repo is cloned.

Go to line number 419 in the **setup.sh** script. The classpath for java is define here. Add the name of the new package with the custom config management code in the classpath and also replace the name of the main class with the newly created main class .i.e. if the name of the previous main class was Resolver and was accessed as com.tibco.bwce.profile.resolver.Resolver, then replace the name of the main class Resolver with the new main class CustomConfigManagement as com.tibco.bwce.profile.sample.CustomConfigManagement in the docker script setup.sh.

Save the changes made and use the new runtime zip and the new setup.sh script to deploy applications on docker and connect to a custom config server of your choice.
