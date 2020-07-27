# devops-pipeline

Devops-pipeline project is an example of CI pipeline.

Components:
==========

1. Spring Boot Application - which displays commit details at an end point.
2. Maven is the build tool used for building the application.
3. Used maven:3-alpine maven image to build the code and generate jar file.  -----BUILD_TAG
4. Used tomcat:10-jdk8-openjdk image to run the image in the container.
5. Created docker-compose file to build the docker file.
6. Created shell script to autmate the build and execution process.
7. Jenkins pipelines are used for integrating continuous delivery pipelines into Jenkins.

Details:
========
 
 spring boot application:
 
 gitClient: spring boot application which uses "maven-git-commit-id-plugin" to fetch the details of last commit in git.
 
 when the build is executed on the project, it reads .git folder and generates git.properties with commit details in the source fodler.
 
 Spring boot application reads git.properties from the class path and displays as a value object at an end point.
 
 --- localhost:8080/version
 
 output:   {"myapplication":[{"version":"0.0.1-SNAPSHOT","lastcommitsha":"8d6ac30","description":"complete application"}]}
 
 Junit test is written to test the functionality of the application and placed in test folder.
 
 Containerisation:
 ================
 
 1. Used maven docker container to build the application and generate the jar( mvn.sh script in build loction of jenkins folder in source code)
 2. Created Docker, docker-compose script to build the image.
 3. Used maven to test the application and generate surefire-reports in target folder of the application.
 4. Created sepeate shell scripts for jar generation, building images for testing.
 5. Created jenkins pipeline (Jenkinsfile is the pipeline file) with two stages 
      1. build
      2. test
 6. Create jenkins pipeline in jenkins and configured git in the pipeline.
 7. Excute the build, it executes in stages.
 
 Versioning of image: 
 ==================
 used BUILD_TAG( global variables)  in the docker-compose file for versioning.
 
 security:
 =========
  1. Inside jenkins, we can create roles, users and assign users only readonly and execute acces in jenkins.
  2. Follow verioning and tagging to avoid dangling images.
  3. Used volumes to write the maven repo details.
  
  
  Webhooks:
  ==========
   Since jenkins is running on localhost , dint conigure gitwebhooks in git
   
   since tomcat and jenkins uses 8080, used different server address for the app.( using port forwarding in docker run command)
   

 
 
Additional details:
 =======
 
1.   Installation of docker inside jenkins which is already runnign docker, we face perimission access issuess of /var/run/docker.sock
2.   .Git details are mandatory for the buid job of the gitClient application.
3.    /root/.m2 and jenkins workspace need to modified in mvn.sh scripts when the code is cloned. ( because of VM and h/w constraints i have hardcoded these two details)
 
 
 Next apporach: 
 ============= 
               Jar has to be pushed to dockerhub or any artifactory for deployments.
              
 
 
 
 

 
 
