package com.sailfish.learnspring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author sailfish
 * @create 2020-04-25-10:14 下午
 */
@Aspect
public class NotVeryUsefulAspect {


    @Pointcut("execution(* transfer(..))") // the pointcut expression
    private void anyOldTransfer() {} // the pointcut signature


}
