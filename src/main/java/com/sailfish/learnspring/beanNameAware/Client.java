package com.sailfish.learnspring.beanNameAware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://blog.csdn.net/linuu/article/details/50857153
 * @author sailfish
 * @create 2017-09-09-下午10:03
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-practice/spring-bean-name-aware.xml");
        MyBeanNameAware myBeanNameAware = context.getBean("myBeanNameAware", MyBeanNameAware.class); //my name is:myBeanNameAware
    }
}
