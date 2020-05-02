package com.sailfish.dataAccess.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2020-05-02-3:37 下午
 */
public class TransactionDemo {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dataAccess/transaction-config.xml");
        TransferService transferService = context.getBean(TransferService.class);
        transferService.transfer(100L, 1L, 2L);

    }
}
