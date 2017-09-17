package com.sailfish.learnspring.beanNameAware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author sailfish
 * @create 2017-09-09-下午10:02
 */
public class MyBeanNameAware implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("my name is:" + name);
    }
}
