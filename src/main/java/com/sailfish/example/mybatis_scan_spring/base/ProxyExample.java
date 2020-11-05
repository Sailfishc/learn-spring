package com.sailfish.example.mybatis_scan_spring.base;

import java.lang.reflect.Proxy;

public class ProxyExample {


    public static void main(String[] args) {

        BaseProxy baseProxy = new BaseProxy(new UserServiceImpl());

        final UserService userService = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, baseProxy);
        userService.sayHello("Sailfish");

    }
}
