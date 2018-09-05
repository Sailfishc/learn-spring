package com.sailfish.learnspring.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sailfish
 * @create 2018-02-05-下午7:00
 */
public class CgLibProxy implements MethodInterceptor{



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        return methodProxy.invokeSuper(o, objects);
    }

    private void before() {
        System.out.println("Before ....");
    }
}
