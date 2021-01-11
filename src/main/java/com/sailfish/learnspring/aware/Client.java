/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chengyi
 * @version : Client.java, v 0.1 2021年01月10日 11:54 上午 chengyi Exp $
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationContextAware.class);
        MyApplicationContextAware aware = context.getBean(MyApplicationContextAware.class);
        aware.handle();

    }
}