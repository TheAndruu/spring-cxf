package demo.service.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import demo.spring.service.HelloWorld;

public class ClientDemo {

    public static void main(String args[]) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://localhost:8080/ws-server-1.0/api/hello");
        factory.setServiceClass(HelloWorld.class);

        HelloWorld client = (HelloWorld) factory.create();
        String response = client.sayHi("hi, you beautiful world!");
        System.out.println("Response from server: " + response);
    }
}
