package com.sailfish.learnspring.beanFactoryAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author sailfish
 * @create 2017-09-09-下午9:55
 */
public class MyBeanFactoryAware implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("belong to" + beanFactory);
    }
}
