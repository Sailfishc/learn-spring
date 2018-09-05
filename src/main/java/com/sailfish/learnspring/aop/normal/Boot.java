package com.sailfish.learnspring.aop.normal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2018-09-05-上午8:17
 */
public class Boot {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-aspect.xml");
        UserServiceImpl bean = (UserServiceImpl) context.getBean("userServiceImpl");
        String sailfish = bean.getName("sailfish");

    }
}
