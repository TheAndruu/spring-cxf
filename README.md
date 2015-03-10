# spring-cxf

Demonstrates ability to host a JAX-WS service using Spring Boot and Apache CXF with zero XML configuration.

## Run the Service
In a terminal, execute: `./gradlew bootRun`

Alternatively can be run in your IDE of choice by running `demo.spring.service.Application.java` as a normal Java application.

### Service endpoint
The service endpoint is `api/hello`.  If running the embedded tomcat from the command line or within an IDE, this will be:

    http://localhost:8080/api/hello?wsdl

The built WAR can also be dropped into a servlet container (such as Tomcat or Jetty).  Typically this updates the context path of the URI, so inside a servlet container, the path will default to: `http://localhost:8080/<name-of-war-file>/api/hello?wsdl`

## Generate client 
The same WSDL available at `api/hello?wsdl` is included as a resource for code generation purposes.  To compile code from the WSDL definition, in `build.gradle`, set the property `wsdl2java.enabled = ` to `true`, then execute:

    ./gradlew ws-client:wsdl2java
    
This will output the compiled classes in `ws-client/generatedsources`, which can then be used to hit a running endpoint.  Suggest copying the outputted classes to a source folder and importing it as a separate library.  This generation only needs to occur when the service interface changes.


## To test
The service can be tested with any standard WS tool, such as SoapUI or a client using classes compiled against the WSDL.

The `ws-client ` module includes an example of accessing the service using code generated using wsdl2java as described above.  

With the server running, execute the class `demo.service.client.ClientDemo.java` which contains a `main()` method.  Upon running, the following log statement will show the client received a response from the server like so:

    11:32:18.394 [main] INFO  demo.service.client.ClientDemo - Response from server: Hello hi, you beautiful world!
 

