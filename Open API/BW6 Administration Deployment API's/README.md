# Admin Scripts using REST API

BWAgent can be accessed by REST API. This REST API can be used to perform administrative tasks like creating a domain, uploading archives, deploying an application, etc.

See section **"Accessing the bwagent REST API with the Swagger UI"** in the TIBCO ActiveMatrix BusinessWorks™ Administration guide for more information about the REST API's.

Use the Swagger UI to access the bwagent REST API, where you can try out operations and see results using sample data. 

Some of these REST API's are implemented in the scripts provided.

You can add functions in the scripts to call remaining REST API's as per your need.

CommandFunctions.sh contains all the functions which makes the REST API call using cURL command.
These commands are called from start.sh file providing required parameters.
We can provide customized entity names(like domainName,appSpacename etc) from outside file entityNames.sh which is referred from start.sh. 
Note : Function parameters are positional in nature;like, first value will be assigned to $1 inside the function.

## Prerequisites:

1. Install curl and set in Path for Windows.
2. Install cygwin for Windows.
3. BWAgent should be running.

## Steps to run the script:

1. Set the env variables and entity names in the entityNames.sh file. Set the values for agentName, BWAgent_REST_URL and other fields.
2. In start.sh, you can call the functions as per your need.
3. Execute start.sh from the cygwin (Windows) or from command prompt (linux/mac)

After successful execution of script, you will see output of each command executed on the command prompt and in TEA UI, the entities getting created.

## Partial Response support

There are functions like getApplicationStatus, getAppNodeStatus, getAppSpaceStatus which use the REST API to return only selected fields instead of full response as per the query parameters.
You need to pass the fields which you want to return in fields query parameter.

For Eg:
This returns the application status as {"state":"Running"}-

http://localhost:8079/bw/v1/domains/MyDomain/appspaces/AS1/applications/tibco.bw.sample.binding.rest.Basic.application/1.0?fields=state


This returns the AppNode status {"state":"Running"}:
http://localhost:8079/bw/v1/domains/MyDomain/appspaces/AS1/appnodes/AN1?status=true&fields=state


This returns appspace status as { "status": "Running" }-
http://localhost:8079/bw/v1/domains/MyDomain/appspaces/AS1?status=true&full=true&fields=status

You can add your own custom functions in CommandFunctions.sh and use the fields parameter in different GET REST API's





