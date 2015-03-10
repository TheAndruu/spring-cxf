package demo.service.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.spring.service.HelloWorld;

public class ClientDemo {

    private static final Logger log = LoggerFactory.getLogger(ClientDemo.class);

    public static void main(String args[]) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://localhost:8080/api/hello");
        factory.setServiceClass(HelloWorld.class);

        HelloWorld client = (HelloWorld) factory.create();
        String response = client.sayHi("hi, you beautiful world!");
        log.info("Response from server: " + response);
    }
}
