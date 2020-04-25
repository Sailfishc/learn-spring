package com.sailfish.learnspring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author sailfish
 * @create 2020-04-25-10:21 下午
 */
@Aspect
public class AroundExample {

    @Around("com.xyz.myapp.SystemArchitecture.businessService()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Signature signature = pjp.getSignature();
        String name = signature.getName();
        Object arg = pjp.getArgs()[0];
        Object proxy = pjp.getThis();
        pjp.getTarget();
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
}
