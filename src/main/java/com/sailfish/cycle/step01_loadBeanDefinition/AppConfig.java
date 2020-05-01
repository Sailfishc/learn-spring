package com.sailfish.cycle.step01_loadBeanDefinition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author sailfish
 * @create 2020-05-01-10:10 下午
 */
@Configuration
public class AppConfig {

    @Bean
    public TransferService transferService() {

        return new TransferService();
    }

    @Bean
    public AccountRepository accountRepository(DataSource dataSource) {

        return new AccountRepository();
    }
}
