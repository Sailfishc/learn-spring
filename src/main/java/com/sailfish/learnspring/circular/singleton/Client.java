/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.circular.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 单例情况下构造器循环依赖
 * Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'boyFriend': Requested bean is currently in creation: Is there an unresolvable circular reference?
 * @author chengyi
 * @version : Client.java, v 0.1 2021年01月12日 9:21 下午 chengyi Exp $
 */
@Configuration
@ComponentScan(basePackages = "com.sailfish.learnspring.circular.singleton")
public class Client {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Client.class);
        BoyFriend boyFriend = (BoyFriend) context.getBean("boyFriend");
    }
}