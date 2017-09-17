package com.sailfish.learnspring.multiBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://blog.csdn.net/linuu/article/details/50865002
 *
 * @author sailfish
 * @create 2017-09-09-下午10:31
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-multi-bean.xml");
        MultiSimpleBan multiSimpleBean = context.getBean("multiSimpleBean", MultiSimpleBan.class);
        multiSimpleBean.say();

        SpringOtherBean bean = context.getBean("springOtherBean", SpringOtherBean.class);
        bean.say();
    }
}
//    init constructor...
//        BeanNameAware初始化 set BeanName begin and name is multiSimpleBean
//        BeanFactoryName初始化 begin and beanFactory is org.springframework.beans.factory.support.DefaultListableBeanFactory@4909b8da: defining beans [multiSimpleBean]; root of factory hierarchy
//        InitializingBean接口的具体实现 begin and id is 1 and name is spring
//      init method Begin
//        BeanFactoryPostProcessor 接口初始化 begin and this beanFactory is org.springframework.beans.factory.support.DefaultListableBeanFactory@4909b8da: defining beans [multiSimpleBean]; root of factory hierarchy
//        hello I am spring

// 开启后面的bean
//    init constructor...
//        BeanNameAware初始化 set BeanName begin and name is multiSimpleBean
//        BeanFactoryName初始化 begin and beanFactory is org.springframework.beans.factory.support.DefaultListableBeanFactory@4909b8da: defining beans [multiSimpleBean]; root of factory hierarchy
//        InitializingBean接口的具体实现 begin and id is 1 and name is spring
//      init method Begin
//        BeanFactoryPostProcessor 接口初始化 begin and this beanFactory is org.springframework.beans.factory.support.DefaultListableBeanFactory@4909b8da: defining beans [multiSimpleBean]; root of factory hierarchy
//    BeanPostProcessor接口 before 初始化  postProcessAfterInitialization begin
//        BeanPostProcessor接口after 初始化  postProcessAfterInitialization begin
//        hello I am spring
//        i am springOtherBean
