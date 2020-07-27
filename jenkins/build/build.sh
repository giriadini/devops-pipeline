#! /bin/bash

# copy the newly built jar to build location
cp -f gitClient/target/*.jar jenkins/build/


echo "************************"
echo "**** building docker image *****"
echo "************************"

cd jenkins/build && docker-compose -f docker-compose-build.yaml build --no-cache
