package com.sailfish.learnspring.hook;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * “spring”开闭原则的典型实现
 * @author sailfish
 * @create 2017-09-09-下午4:11
 */
public class TeacherProcesser implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof Teacher) {
            Teacher teacher = (Teacher) bean;
            //如果抽烟，改为false
            if (teacher.isSmoking() == true) {
                teacher.setSmoking(false);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
