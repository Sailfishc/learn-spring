package com.sailfish.cycle.step02_initBeanInstance;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author sailfish
 * @create 2020-05-02-2:58 下午
 */
@Component
public class TransferService {

    @PostConstruct
    public void init() {
        System.out.println("TransferService init ...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("TransferService destroy ...");
    }

}
