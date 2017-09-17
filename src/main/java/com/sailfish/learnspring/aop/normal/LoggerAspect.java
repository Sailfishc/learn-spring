package com.sailfish.learnspring.aop.normal;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * @author sailfish
 * @create 2017-09-11-上午8:24
 */
public class LoggerAspect {

    public void doBefore(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        String kind = joinpoint.getKind();
        Signature signature = joinpoint.getSignature();
        String name = joinpoint.getTarget().getClass().getName();
        System.out.println("args:" + args + ",kind:" + kind + ",signature:" + signature + ",name:" + name);
    }
}
