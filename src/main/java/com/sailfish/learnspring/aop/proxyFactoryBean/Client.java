package com.sailfish.learnspring.aop.proxyFactoryBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2017-09-10-下午1:16
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-proxy-factory-bean.xml");
        BussinessService bussiness = context.getBean("proxyFactoryBean", BussinessService.class);
        bussiness.say();
    }
}
