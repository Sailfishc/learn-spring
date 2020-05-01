package com.sailfish.design.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2020-05-01-9:17 下午
 */
public class FactoryDemo {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/design/factory-bean-config.xml");
        TransferService transferService = context.getBean(TransferService.class);
        transferService.transfer("1", "2", 1.22);


    }
}
