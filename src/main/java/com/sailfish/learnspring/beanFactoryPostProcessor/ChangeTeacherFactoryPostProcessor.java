package com.sailfish.learnspring.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author sailfish
 * @create 2017-09-09-下午9:03
 */
public class ChangeTeacherFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        //这里获取的是Teacher的beanDefinition
        BeanDefinition teacherDefinition = beanFactory.getBeanDefinition("teacher");
        MutablePropertyValues propertyValues = teacherDefinition.getPropertyValues();
        if (propertyValues.contains("smoking")) {
            propertyValues.add("smoking", false);
        }
    }
}
