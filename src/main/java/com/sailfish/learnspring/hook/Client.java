package com.sailfish.learnspring.hook;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2017-09-09-下午4:15
 */
public class Client {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-practice/spring-bean-processer.xml");
        Teacher teacher = context.getBean("teacher", Teacher.class);
        //Teacher{name='橙子', age='18', smoking=false}
        System.out.println(teacher.toString());
    }
}
