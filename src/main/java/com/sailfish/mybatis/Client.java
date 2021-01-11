/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.mybatis;

import com.sailfish.mybatis.entity.User;
import com.sailfish.mybatis.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author chengyi
 * @version : Client.java, v 0.1 2021年01月09日 10:34 上午 chengyi Exp $
 */
public class Client {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis/spring-mybatis.xml");
        TransactionTemplate transactionTemplate = context.getBean("transactionTemplate", TransactionTemplate.class);
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        transactionTemplate.execute(txStatus -> {
            userMapper.addUser("100", "李四");
            User user01 = userMapper.getUser("1");
            System.out.println(user01);
            throw new RuntimeException("exception ...");
//            System.out.println(userMapper.getUser("2"));
//            return null;
        });
    }
}