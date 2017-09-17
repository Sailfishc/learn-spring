package com.sailfish.learnspring.base;

import javax.xml.ws.Service;

/**
 * @author sailfish
 * @create 2017-09-16-下午5:32
 */
public class ServiceA {

    private String name;
    ServiceB serviceB;


    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
