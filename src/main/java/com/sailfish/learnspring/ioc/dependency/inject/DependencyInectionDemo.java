package com.sailfish.learnspring.ioc.dependency.inject;

import com.sailfish.learnspring.ioc.dependency.domain.Super;
import com.sailfish.learnspring.ioc.dependency.domain.User;
import com.sailfish.learnspring.ioc.dependency.repository.UserRepository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author sailfish
 * @create 2020-04-21-11:00 下午
 */
public class DependencyInectionDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-manager/dependency-injection-context.xml");

        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository);


        //
        System.out.println(userRepository.getBeanFactory());
        System.out.println(beanFactory == userRepository.getBeanFactory());


//        Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
        System.out.println(userObjectFactory.getObject());

        // true
        // autowring 的时候注入了一个ApplicationContext
        System.out.println(userRepository.getApplicationContextObjectFactory().getObject() == beanFactory);
    }

}
