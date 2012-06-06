#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy magbro
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/magbro.war
