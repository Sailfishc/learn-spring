package com.sailfish.learnspring.aop.normal;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author sailfish
 * @create 2018-09-05-上午8:09
 */
@Aspect
@Component
public class LogAspect {


    @Around("execution(* com.sailfish.learnspring.aop.normal.UserServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        before();
        Signature signature = pjp.getSignature();
        System.out.println("signature.name=" + signature.getName());
        System.out.println("signature.type.name=" + signature.getDeclaringType().getName());
        System.out.println("signature.modify=" + signature.getModifiers());
        Object o = Class.forName(signature.getDeclaringType().getName()).newInstance();
        Class<?> aClass = Class.forName(signature.getDeclaringType().getName());
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation=" + annotation.toString()); //Service
        }
        Method[] methods = aClass.getMethods();
        System.out.println("=====================");
        for (Method method : methods) {
            System.out.println("method=" + method.getName());
        }
        System.out.println("=====================");

        Object o1 = aClass.newInstance();
        System.out.println("o equals o1=" + o.equals(o1));

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            // method arg
            System.out.println("arg=" + arg);
        }
        Object target = pjp.getTarget();

        Object proceed = pjp.proceed();

        after();
        return proceed;
    }

    private void after() {
        System.out.println("5888,我是橙子，欢迎下次光临");
    }

    private void before() {
        System.out.println("2333，我是橙子，为您服务");
    }


}
