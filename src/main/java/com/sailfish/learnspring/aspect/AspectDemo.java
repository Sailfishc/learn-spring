package com.sailfish.learnspring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2020-04-25-10:32 下午
 */
public class AspectDemo {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/aspectJ/aspectJ-config.xml");
        SystemArchitecture systemArchitecture = context.getBean(SystemArchitecture.class);
        systemArchitecture.businessService();

    }
}
