/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.mybatis;

import com.sailfish.mybatis.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chengyi
 * @version : SqlSessionDemo.java, v 0.1 2021年01月09日 2:19 下午 chengyi Exp $
 */
public class SqlSessionDemo {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis/spring-sqlsession.xml");
        SqlSessionTemplate sqlSession = context.getBean("sqlSession", SqlSessionTemplate.class);
        // User(id=1, userId=123, name=张三)
        User user = sqlSession.selectOne("com.sailfish.mybatis.mapper.UserMapper.getUser", "1");
        System.out.println(user);
    }
}