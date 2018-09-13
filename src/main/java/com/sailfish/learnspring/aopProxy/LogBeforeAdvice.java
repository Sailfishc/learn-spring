package com.sailfish.learnspring.aopProxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author sailfish
 * @create 2018-09-13-上午10:21
 */
public class LogBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("log before advice .....");
    }
}
