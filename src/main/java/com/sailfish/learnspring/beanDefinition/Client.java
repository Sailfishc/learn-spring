/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.beanDefinition;

import com.sailfish.mybatis.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chengyi
 * @version : Client.java, v 0.1 2021年01月10日 11:54 上午 chengyi Exp $
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("learn-spring/beanDefinition-spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}