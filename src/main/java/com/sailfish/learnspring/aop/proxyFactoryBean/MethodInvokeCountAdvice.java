package com.sailfish.learnspring.aop.proxyFactoryBean;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sailfish
 * @create 2017-09-10-下午9:30
 */
public class MethodInvokeCountAdvice implements MethodBeforeAdvice {

    private Map<String, Integer> countMap = new HashMap<>();

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String name = method.getName();
        if (countMap.containsKey(name)) {
            Integer count = countMap.get(name);
            countMap.put(name, ++count);
        } else {
            countMap.put(name, 1);
        }
        System.out.println("当前方法第:"+countMap.get(name)+"次调用");
    }
}
