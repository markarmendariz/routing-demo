# routing-demo
Simple routing example with Spring Boot and Docker

## Requires following to build and run the application:
- JDK 11
- Maven
- Docker

## Run the below at the command line to build the source code:
mvn clean package

## Run the below at the command line to build the Docker image:
docker build -t springio/routing-spring-boot-docker .

## Run the below at the command line to run the application:
docker run -p 8080:8080 springio/routing-spring-boot-docker

## Open a browser and navigate to:
http://locahost:8080

