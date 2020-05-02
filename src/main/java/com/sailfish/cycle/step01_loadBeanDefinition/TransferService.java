package com.sailfish.cycle.step01_loadBeanDefinition;

import com.sailfish.design.factoryBean.IAccountRepository;

import org.springframework.stereotype.Component;

/**
 * @author sailfish
 * @create 2020-05-01-8:13 下午
 */
@Component
public class TransferService {

    IAccountRepository accountRepository;

    public TransferService() {
    }

    public TransferService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(String accountA, String accountB, Double amount) {
        System.out.println("Amount has been tranferred");
    }
}
