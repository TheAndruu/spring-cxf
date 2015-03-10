# spring-cxf

Demonstrates ability to host a JAX-WS service using Spring Boot and Apache CXF with zero XML configuration.

## To run
In a terminal, execute: `./gradlew bootRun`

Alternatively can be run in your IDE of choice by running `demo.spring.service.Application.java` as a normal Java application.

## Service endpoint
The service endpoint is `api/hello`.  If running the embedded tomcat from the command line or within an IDE, this will be:

    http://localhost:8080/api/hello?wsdl

The built WAR can also be dropped into a servlet container (such as Tomcat or Jetty).  Typically this updates the context path of the URI, so inside a servlet container, the path will default to: `http://localhost:8080/<name-of-war-file>/api/hello?wsdl`

## To test
The service can be tested with any standard WS tool, such as SoapUI or a client using classes compiled against the WSDL.