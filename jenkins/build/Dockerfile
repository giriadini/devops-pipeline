FROM tomcat:10-jdk8-openjdk

#create path in container
RUN mkdir /app

#copy jar from local to container path
COPY *.jar /app/app.jar

#Executable
CMD java -jar /app/app.jar
