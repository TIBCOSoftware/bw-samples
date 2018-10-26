#*************************Script for BW6 Admin Automation using REST API**************************************************

#Import all the functions
source CommandFuntions.sh

#Import all the user defined variables
source entityNames.sh

 echo "***************Clean up Domain before starting***********"
 deleteDomain $domainName $agentName

 echo "*******************Creating Domain******************************"
 createDomain $domainName $agentName

 echo "*******************Creating AppSpace******************************"
 createAppspace $domainName $appSpaceName

 echo "*******************Creating Appnode******************************"
 createAppnode $domainName $appSpaceName $appNodename $agentName $httpPort
 
# add sleep time in seconds to check/see if all are working as expected  
 
 sleep 5

# If you want to upload a single ear
# echo "*******************Uploading EAR******************************"
 uploadEAR $domainName $earFile
 
 # If you want to upload multiple ears at a time.
 #uploadMultipleEARs $domainName $search_dir

 echo "*******************Deploying Application******************************"
 deploy $domainName $appSpaceName $earFile


 echo "*******************Starting Appnode******************************"
 startAppNode $domainName $appSpaceName $appNodename
 
 
 sleep 5
 
 echo "***************AppNode Status***********"
 getAppNodeStatus $domainName $appSpaceName $appNodename
 
 echo "*******************Starting Application******************************"
	
 startApplication $domainName $appSpaceName $applicationName $version
 
 sleep 5
 
 echo "***************Application Status***********"
 getApplicationStatus $domainName $appSpaceName $applicationName $version
 
 echo "***************Undeploying Application ***********"

 undeploy $domainName $appSpaceName $applicationName $version

 echo "***************Deleting Archive ***********"
 deleteArchive $domainName $earFile

 echo "***************Deleting AppNode ***********"
 deleteAppnode $domainName $appSpaceName $appNodename

 #echo "***************Deleting AppSpace ***********"
 #deleteAppspace $domainName $app
 
 echo "***************Deleting Domain ***********"
 deleteDomain $domainName $agentName

