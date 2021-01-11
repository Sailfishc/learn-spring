/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author chengyi
 * @version : MyApplicationContextAware.java, v 0.1 2021年01月10日 12:17 下午 chengyi Exp $
 */
@Component
@Configuration
public class MyApplicationContextAware  implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void handle() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("print all beanDefinition Names");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}