/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.BeanDefinitionBuilder;

import com.sailfish.learnspring.beanPostProcessor.Ball;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author chengyi
 * @version : ProgrammaticDemo.java, v 0.1 2021年01月13日 7:18 下午 chengyi Exp $
 */
public class ProgrammaticDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        int i = reader.loadBeanDefinitions(new ClassPathResource("learn-spring/programmatic-beanDefinition-spring.xml"));

        context.refresh();
        Ball bean = context.getBean(Ball.class);
        System.out.println(bean);
    }

}