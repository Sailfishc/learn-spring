package com.sailfish.learnspring.ioc.dependency.lookup;

import com.sailfish.learnspring.ioc.dependency.domain.Super;
import com.sailfish.learnspring.ioc.dependency.domain.User;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author sailfish
 * @create 2020-04-21-11:00 下午
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-manager/dependency-lookup-context.xml");
        lookupRealTime(beanFactory);
        lookupLazy(beanFactory);

        lookupByType(beanFactory);
        lookupByCollection(beanFactory);

        loopupByAnnotation(beanFactory);
    }

    private static void loopupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> users = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(users);
        }
    }

    private static void lookupByCollection(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println(bean);
    }

    private static void lookupLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = beanFactory.getBean("objectFactory", ObjectFactory.class);
        User user = objectFactory.getObject();
        System.out.println(user);
    }

    private static void lookupRealTime(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
