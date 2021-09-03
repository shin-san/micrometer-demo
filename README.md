# micrometer-demo

A simple spring-boot service for showing how micrometer works
# Local
## Build
### Maven
    mvn clean package

## Run
Run the service using maven spring-boot plugin

    mvn spring-boot:run

# Docker
## Build
### Prerequisites
Local Docker instance must be installed
The Dockerfile also relies on build-args

Note: the following container images have been tested in Raspberry PI
Note: `sudo` might also be required if it is being installed in unix OS
#### Local
    docker build \
    --build-arg MAVEN_BUILD=maven:3.6.3-jdk-11-slim \
    --build-arg MYAPP_IMAGE=openjdk:11-jdk-slim \
    -t localhost:5000/hello-world:latest .
#### Remote
    docker build https://github.com/shin-san/hello-world.git \
    --build-arg MAVEN_BUILD=maven:3.6.3-jdk-11-slim \
    --build-arg MYAPP_IMAGE=openjdk:11-jdk-slim \
    -t localhost:5000/hello-world:latest
    
## Run
    docker run -p 8080:8080 localhost:5000/hello-world

# REST API
The REST API to the example app is described below.
## Print Hello World
### Request
`GET /hello`

    curl -k -v http://localhost:8080/hello
### Response
    HTTP/1.1 200
    Content-Type: text/plain;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Sat, 06 Feb 2021 10:39:58 GMT
    
    Hello World!
## Get Employee
### Request
`GET /employee`

    curl -k -v http://localhost:8080/employee
### Response
    HTTP/1.1 200
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Sat, 06 Feb 2021 10:39:58 GMT
    
    {
        "firstName": "John",
        "lastName": "Doe",
        "age": "27",
        "dob": "01/01/1993"
    }