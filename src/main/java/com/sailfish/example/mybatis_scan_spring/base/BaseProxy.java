package com.sailfish.example.mybatis_scan_spring.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BaseProxy<UserService> implements InvocationHandler {

    private UserService service;

    public BaseProxy(UserService service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(service, args);
    }
}
