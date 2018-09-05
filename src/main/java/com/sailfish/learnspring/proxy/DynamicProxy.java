package com.sailfish.learnspring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理
 * @author sailfish
 * @create 2018-02-05-下午6:51
 */
public class DynamicProxy implements InvocationHandler{

    private Object target; //被代理对象

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        return method.invoke(target, args);  //注意这里是target
    }


    private void before() {
        System.out.println("Before ....");
    }

}
