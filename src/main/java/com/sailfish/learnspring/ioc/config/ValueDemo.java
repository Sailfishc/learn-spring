package com.sailfish.learnspring.ioc.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2020-04-25-10:42 上午
 */
public class ValueDemo {


    public static void main(String[] args) {

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/config/container-config.xml");
//
//        MovieRecommender movieRecommender = beanFactory.getBean("movieRecommender", MovieRecommender.class);
//        System.out.println(movieRecommender.getCatalog());

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        MovieRecommender movieRecommender = ctx.getBean(MovieRecommender.class);
        System.out.println(movieRecommender.getCatalog());

    }
}
