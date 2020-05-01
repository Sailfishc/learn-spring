package com.sailfish.design.step01_no_spring;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-1:40 下午
 */
public class TransferService {

    private AccountRepository accountRepository;

    public TransferService() {
        this.accountRepository = new AccountRepository();
    }

    public void transferMoney(Account a, Account b) {
        accountRepository.transfer(a, b);
    }
}
