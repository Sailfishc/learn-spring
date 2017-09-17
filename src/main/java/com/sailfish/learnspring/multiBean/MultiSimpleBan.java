package com.sailfish.learnspring.multiBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author sailfish
 * @create 2017-09-09-下午10:13
 */
public class MultiSimpleBan implements BeanPostProcessor, BeanFactoryPostProcessor, BeanNameAware, BeanFactoryAware, InitializingBean {

    private Integer id;
    private String name;

    public MultiSimpleBan() {
        System.out.println("init constructor...");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    /**
     * init-method
     */
    public void initMethod(){
        System.out.println("init method Begin");
    }


    public void say(){
        System.out.println("hello I am "+name);
    }



    //BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryName初始化 begin and beanFactory is "+beanFactory);
    }

    //BeanNameAware
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware初始化 set BeanName begin and name is "+name);
    }

    //InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口的具体实现 begin and id is "+ id +" and name is "+ name);
    }

    //BeanFactoryPostProcessor
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor 接口初始化 begin and this beanFactory is "+beanFactory);
    }

    //BeanPostProcessor
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口 before 初始化  postProcessAfterInitialization begin");
        return bean;
    }

    //BeanPostProcessor
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口after 初始化  postProcessAfterInitialization begin");
        return bean;
    }
}
