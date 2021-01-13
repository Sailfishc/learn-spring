/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chengyi
 * @version : MyInstantiationAwareBeanPostProcessor.java, v 0.1 2021年01月13日 6:12 下午 chengyi Exp $
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("ball".equalsIgnoreCase(beanName)) {
            Ball ball = new Ball();
            ball.setName("橙子篮球");
            return ball;
        }
        return null;
    }
}