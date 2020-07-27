# devops-pipeline

Devops-pipeline is a Spring Boot application with a RESTful webservice for retrieving versioning information. 

Components:
==========

1. Spring Boot Application - which displays commit details at an end point.
2. Maven is the build tool used for building the application.
3. Used maven:3-alpine maven image to build the code and generate jar file.
4. Used tomcat:10-jdk8-openjdk image to run the image in the container.
5. Created docker-compose file to build the docker images.
6. Created shell script to autmate the build and execution process.
7. Jenkins pipelines are used for integrating continuous delivery pipelines into Jenkins.

Details:
========
 
 spring boot application:
 
 1. gitClient: spring boot application which uses "maven-git-commit-id-plugin" to fetch the details of last commit in git.
 
 2. when the build is executed on the project, it reads .git folder and generates git.properties with commit details in the source folder.
 
 3. Spring boot application reads git.properties from the class path and displays as a value object at an end point.
 
      --- localhost:8080/version
 
       output:   {"myapplication":[{"version":"0.0.1-SNAPSHOT","lastcommitsha":"8d6ac30","description":"complete application"}]}
 
4.  Junit test is written to test the functionality of the application and placed in test folder.
 
 Containerisation:
 ================
 
 1. Used maven docker container to build the application and generate the jar( mvn.sh script in build loction of jenkins folder in source code)
 2. Created Docker, docker-compose script to build the image.
 3. Used maven to test the application which generates surefire-reports in target folder of the application.
 4. Created seperate shell scripts for jar generation, building images for testing.
 5. Created jenkins pipeline (Jenkinsfile is the pipeline file) with two stages 
      1. build
      2. test
 6. Created jenkins pipeline in jenkins and configured git in the pipeline component.
 7. Execute the build-It executes in stages.
 
 Versioning: 
 ==================
 used BUILD_TAG( global variables)  in the docker-compose file for versioning.
 
 security:
 =========
  1. In jenkins, role based strategy can be integrated by creating users and roles with specific access.
  2. In Docker, follow versioning and tagging to avoid dangling images.
  3. Used volumes to write the maven repo details in the shell scripts.
  4. Spring security can be used to provide secuirty for the application.
  
  
  Webhooks:
  ==========
   Since jenkins is running on localhost , gitwebhooks is not configured to this repo.
   
   since tomcat and jenkins uses 8080, used different server address for the app(using port forwarding in docker run command).
   

 
 
Additional details:
 =======
 
1.   Installation of docker inside jenkins which is already running on a docker, gives perimission access issuess of /var/run/docker.sock
2.   .Git details are mandatory for the buid job of the gitClient application.
3.    /root/.m2 and jenkins workspace need to be modified in mvn.sh scripts when the code is cloned. (Due to VM and h/w constraints, hardcoded these two details)

 
 
          
 
 
 
 

 
 
