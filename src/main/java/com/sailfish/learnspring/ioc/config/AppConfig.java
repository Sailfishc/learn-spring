package com.sailfish.learnspring.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author sailfish
 * @create 2020-04-25-10:38 上午
 */
@Configuration
@PropertySource("classpath:META-INF/config/application.properties")
@ComponentScan(basePackages = "com.sailfish.learnspring.ioc.config")
public class AppConfig {


}
