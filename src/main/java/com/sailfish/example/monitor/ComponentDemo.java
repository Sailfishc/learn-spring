package com.sailfish.example.monitor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2020-05-03-11:31 上午
 */
public class ComponentDemo {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("example/component-spring.xml");
        PersonService personService = context.getBean(PersonService.class);
        personService.findPersonList();
    }
}
