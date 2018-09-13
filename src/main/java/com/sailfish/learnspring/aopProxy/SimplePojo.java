package com.sailfish.learnspring.aopProxy;

import org.springframework.aop.framework.AopContext;

/**
 * @author sailfish
 * @create 2018-09-13-上午10:17
 */
public class SimplePojo implements Pojo {


    @Override
    public void foo() {
        // call on 'this' reference
        System.out.println("foo ......");
//        this.bar();

        ((Pojo) AopContext.currentProxy()).bar();
    }

    @Override
    public void bar() {
        System.out.println("bar .......");
    }
}
