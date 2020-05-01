package com.sailfish.cycle.step01_loadBeanDefinition;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author sailfish
 * @create 2020-05-01-10:11 下午
 */
@Configuration
public class InfraConfig {

    @Bean
    public DataSource dataSource(@Value("${jdbc.driver}") String driver, @Value("${jdbc.url}") String url, @Value("${jdbc.user}") String user, @Value("${jdbc.password}") String pwd) {
        DataSource ds = new DruidDataSource();

        return ds;
    }

}
