package com.sailfish.learnspring.hook.demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2017-09-09-下午4:52
 */
public class Client {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-practice/spring-bean-processer.xml");
        DataSource dataSource = context.getBean("dataSource2", DataSource.class);
        System.out.println(dataSource.toString());
        //DataSource{driver='com.mysql.jdbc.Driver  ', url='jdbc:mysql:/prd.com:3306/gms?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true  ', username='prd_user  ', password='prd_user '}
        //DataSource{driver='com.mysql.jdbc.Driver  ', url='jdbc:mysql:/127.0.0.1:3306/gms?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true  ', username='dev_user  ', password='dev_password '}
    }
}
