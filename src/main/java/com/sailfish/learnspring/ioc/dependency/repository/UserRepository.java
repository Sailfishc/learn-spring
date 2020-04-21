package com.sailfish.learnspring.ioc.dependency.repository;

import com.sailfish.learnspring.ioc.dependency.domain.User;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

import lombok.Data;

/**
 * @author sailfish
 * @create 2020-04-21-11:38 下午
 */
@Data
public class UserRepository {

    private List<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<User> userObjectFactory;

    private ObjectFactory<ApplicationContext> applicationContextObjectFactory;

}
