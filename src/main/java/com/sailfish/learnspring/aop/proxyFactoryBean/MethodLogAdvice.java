package com.sailfish.learnspring.aop.proxyFactoryBean;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author sailfish
 * @create 2017-09-10-下午9:34
 */
public class MethodLogAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String name = method.getName();
        System.out.println("当前方法为:" + name);
    }
}
