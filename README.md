# spring-cxf

Demonstrates ability to host a JAX-WS service using Spring Boot and Apache CXF with zero XML configuration.

## Run the Service
In a terminal, execute: `./gradlew bootRun`

Alternatively can be run in your IDE of choice by running `demo.spring.service.Application.java` as a normal Java application.

Alternatively can be run via executing the `war` directly:

    java -jar ws-server/build/libs/ws-server-1.0.war
    
Alternatively can be run by being dropped into a container such as Jetty or Tomcat's /webapp directory.

### Service endpoint
The service endpoint is `<context-path>/api/hello`.  The full path to the WSDL/service is:

    http://localhost:8080/ws-server-1.0/api/hello?wsdl

## Run the client
Running the given class `demo.service.client.ClientDemo` demonstrates ability to interact with the service without tight coupling or hard dependencies.  

Running the client will print the following statement showing it received a response from the server:

    11:32:18.394 [main] INFO  demo.service.client.ClientDemo - Response from server: Hello hi, you beautiful world!
 
Alternatively the service can be hit with a testing tool, such as SoapUI or Postman, or any other technology capable of sending text over http.


## Generated client 
The client code was generated via the WSDL.  To reproduce this, in `build.gradle`, set the property `wsdl2java.enabled = ` to `true`, then execute:

    ./gradlew ws-client:wsdl2java
    
This will output the compiled classes in `ws-client/generatedsources`, which can then be used to hit a running service without any coupling or hard dependencies.  This generation only needs to occur when the service interface changes.

