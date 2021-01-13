/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.BeanDefinitionBuilder;

import com.sailfish.learnspring.beanPostProcessor.Ball;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 不使用任何配置类 / 配置文件，向 IOC 容器注册一个 Person 对象，并注入属性值。
 * @author chengyi
 * @version : BeanDefinitionBuilderDemo.java, v 0.1 2021年01月13日 7:10 下午 chengyi Exp $
 */
public class BeanDefinitionBuilderDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Ball.class)
                .addPropertyValue("name", "sailfish").getBeanDefinition();
        ctx.registerBeanDefinition("ball", beanDefinition);
        // 如果不调用refresh则报错： has not been refreshed yet
        ctx.refresh();

        Ball bean = ctx.getBean(Ball.class);
        System.out.println(bean);
    }
}