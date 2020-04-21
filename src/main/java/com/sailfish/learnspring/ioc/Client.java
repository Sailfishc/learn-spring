package com.sailfish.learnspring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2017-09-07-下午3:30
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-practice/applicationContext-ioc.xml");
        UserService userService = (UserService) context.getBean("userService");

        userService.sayHello();
    }
}
