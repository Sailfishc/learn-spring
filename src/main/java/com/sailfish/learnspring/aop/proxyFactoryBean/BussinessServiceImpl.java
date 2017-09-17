package com.sailfish.learnspring.aop.proxyFactoryBean;

/**
 * @author sailfish
 * @create 2017-09-10-下午1:16
 */
public class BussinessServiceImpl implements BussinessService {

    @Override
    public void say() {
        System.out.println("say hello");
    }
}
