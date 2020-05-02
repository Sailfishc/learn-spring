package com.sailfish.cycle.step02_initBeanInstance;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


/**
 * @author sailfish
 * @create 2020-05-01-10:11 下午
 */
@Configuration
@ComponentScan(basePackages = "com.sailfish.cycle.step02_initBeanInstance")
public class AppConfig {


}
