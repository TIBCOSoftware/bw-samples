
#======================================================Domain Commands===============================================================================================
createDomain(){
	curl -H "Content-Type: application/x-www-form-urlencoded" -X POST "$BWAgent_REST_URL/bw/v1/domains/$1?agent=$2&owner=admin&desc=$3"
}

deleteDomain(){
	curl -H "Content-Type: application/x-www-form-urlencoded" -X DELETE "$BWAgent_REST_URL/bw/v1/domains/$1?force=true"
}
#====================================================================================================================================================================

#======================================================Archive Commands===============================================================================================
#upload EAR
uploadEAR(){

curl --form "file=@$2" -H "Content-Type: multipart/form-data" -X POST "$BWAgent_REST_URL/bw/v1/domains/$1/archives?replace=true"
}

uploadAllEAR(){
 for earFile in "$search_dir"/*
do
  echo "$earFile"
  curl --form "file=@$earFile" -H "Content-Type: multipart/form-data" -X POST "$BWAgent_REST_URL/bw/v1/domains/$domainName/archives?replace=true&startondeploy=true"
done
}

#uploadMultipleEARs
uploadMultipleEARs(){
for earFile in "$2"/*
do
  echo "$earFile"
  curl --form "file=@$earFile" -H "Content-Type: multipart/form-data" -X POST "$BWAgent_REST_URL/bw/v1/domains/$1/archives?replace=true&startondeploy=true"
done
}

#delete archive
deleteArchive(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X DELETE $BWAgent_REST_URL/bw/v1/domains/$1/archives/$2
}
#====================================================================================================================================================================

#======================================================Appspace Commands===============================================================================================
#create appspace
createAppspace(){
curl -H "Content-Type: application/x-www-form-urlencoded" -X POST $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2
}

#delete appspace
deleteAppspace(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X DELETE $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2?force=true
 
}

#start appspace
startAppspace(){
curl -H "Content-Type: application/x-www-form-urlencoded" -X POST $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/start
}

#stop appspace
stopAppspace(){
curl -H "Content-Type: application/x-www-form-urlencoded" -X POST $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/stop
}

#get AppSpace Status
getAppSpaceStatus(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X GET "$BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2?fields=status"
}
#====================================================================================================================================================================

#======================================================Appnode Commands===============================================================================================
#create appnode
createAppnode(){
 
curl -H "Content-Type: application/x-www-form-urlencoded" -X POST "$BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/appnodes/$3?agent=$4&httpport=$5"
}

#get AppNode details
getAppNode(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X GET $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/appnodes/$3
}

#get AppNode Status
getAppNodeStatus(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X GET "$BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/appnodes/$3?fields=state"
}

#delete appnode
deleteAppnode(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X DELETE $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/appnodes/$3?force=true
}

#Start AppNode
startAppNode(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X POST $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/appnodes/$3/start
}

#Stop AppNode
stopAppNode(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X POST $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/appnodes/$3/stop
}

#====================================================================================================================================================================

#======================================================Application Commands===============================================================================================
# getApplication details
getApplication(){

curl -H "Content-Type: application/x-www-form-urlencoded" -X GET $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/applications/$3/$4
}
# get application status only
getApplicationStatus(){

curl -H "Content-Type: application/x-www-form-urlencoded" -X GET "$BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/applications/$3/$4?fields=state"
}

# start application
startApplication(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X POST $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/applications/$3/$4/start
}

# stop application
stopApplication(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X POST $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/applications/$3/$4/stop
}

 #deploy appication
deploy(){
curl -H "Content-Type: application/x-www-form-urlencoded" -X POST "$BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/applications?archivename=$3"

}

#undeploy
undeploy(){
 curl -H "Content-Type: application/x-www-form-urlencoded" -X DELETE $BWAgent_REST_URL/bw/v1/domains/$1/appspaces/$2/applications/$3/$4
}
#====================================================================================================================================================================

#========================================================MISC Commands===============================================================================================
# get agent information
getAgentInfo(){
curl -H "Content-Type: application/x-www-form-urlencoded" -X GET $BWAgent_REST_URL/bw/v1/agents/info
}

#====================================================================================================================================================================








