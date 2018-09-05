package com.sailfish.learnspring.aop.normal;

import org.springframework.stereotype.Service;

/**
 * @author sailfish
 * @create 2018-09-05-上午8:14
 */
@Service
public class UserServiceImpl {

    @Deprecated
    public String getName(String name) {
        System.out.println("Hello, " + name);
        return name;
    }
}
