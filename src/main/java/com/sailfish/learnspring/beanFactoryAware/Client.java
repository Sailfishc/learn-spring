package com.sailfish.learnspring.beanFactoryAware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 实现这个接口的bean其实是希望知道自己属于哪一个beanfactory
 * @author sailfish
 * @create 2017-09-09-下午9:57
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-factory-aware.xml");
        MyBeanFactoryAware myBeanFactoryAware = context.getBean("myBeanFactoryAware", MyBeanFactoryAware.class);
        //belong toorg.springframework.beans.factory.support.DefaultListableBeanFactory@15975490: defining beans [myBeanFactoryAware]; root of factory hierarchy
    }
}
