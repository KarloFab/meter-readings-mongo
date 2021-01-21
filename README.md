# Meter Readings Mongo DB
This application was developed as a purpose of getting familiar with concepts
of MongoDB and Gradle.
It uses some code and features from meter-readings project I have developed earlier. 
It provides APIs for retrieving Meter Readings as well as inserting Meter Readings.
Application uses Swagger UI for clear APIs overview and easy APIs usage. 

## Running application
Application can be started using command:

## Running database
To start a mongodb database in a docker container, run:

    docker-compose -f src/main/docker/mongodb.yml up -d

To stop a mongodb database in docker container, run:
    
    docker-compose -f src/main/docker/mongodb.yml down

## Running tests
Application tests can be started using command:

   
## Database

  
    
Credentials for accessing database can be found in:

    application.yml
    
There is initial data import each time application is started.
Data location is in folder:

  
## Swagger
Application APIs can be over viewed and tested by using Swagger. Each endpoint is described along with parameters
 it uses. Once application is started,
Swagger UI is available on link:
 
     http://localhost:8080/swagger-ui.html
