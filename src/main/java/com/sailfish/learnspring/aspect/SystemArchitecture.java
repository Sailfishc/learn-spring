package com.sailfish.learnspring.aspect;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

/**
 * @author sailfish
 * @create 2020-04-25-10:31 下午
 */
@Service
public class SystemArchitecture {

//    @Idempotent
    public void businessService() {
        System.out.println("businessService ...");
        throw new PessimisticLockingFailureException("PessimisticLockingFailureException ...");
    }
}
