package com.sailfish.design.step03_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2020-05-01-2:06 下午
 */
public class ApplicationClient {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/design/sample-di.xml");
        TransferService transferService = context.getBean(TransferService.class);
        transferService.transferMoney(1000L, 2000L, new Amount());

    }
}
