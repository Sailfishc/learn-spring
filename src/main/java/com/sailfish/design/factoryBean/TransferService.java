package com.sailfish.design.factoryBean;

/**
 * @author sailfish
 * @create 2020-05-01-8:13 下午
 */
public class TransferService {

    IAccountRepository accountRepository;


    public TransferService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(String accountA, String accountB, Double amount) {
        System.out.println("Amount has been tranferred");
    }
}
