package com.sailfish.cycle.step01_loadBeanDefinition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sailfish
 * @create 2020-05-02-10:40 上午
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(InfraConfig.class);
        TransferService transferService = context.getBean(TransferService.class);
        transferService.transfer("1", "2", 1.2);

    }
}
