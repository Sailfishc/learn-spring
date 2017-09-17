package com.sailfish.learnspring.base;

/**
 * @author sailfish
 * @create 2017-09-16-下午5:33
 */
public class Client {

    public static void main(String[] args) {

//        ServiceA serviceA = new ServiceA();
//        ServiceB serviceB = new ServiceB();
//        serviceA.setServiceB(serviceB);
//        serviceA.getServiceB().sayHello();

        ServiceA serviceA = new ServiceA(new ServiceB());
        serviceA.serviceB.sayHello();
    }
}
