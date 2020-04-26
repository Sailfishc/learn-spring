package com.sailfish.learnspring.tx;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author sailfish
 * @create 2020-04-26-11:27 下午
 */
public class TransactionDemo {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/tx/tx-config.xml");
        DataSource dataSource = context.getBean(DataSource.class);

        Connection conn = DataSourceUtils.getConnection(dataSource);
        int networkTimeout = conn.getNetworkTimeout();
        System.out.println(networkTimeout);
    }
}
