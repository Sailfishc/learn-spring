package com.sailfish.design.step02_factory;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-1:40 下午
 */
public class TransferService {

    private AccountRepository accountRepository;

    //  Thistechnique provides a solution for tight coupling, but we are still adding factoryclasses to the business component for fetching collaborating components.
    public TransferService() {
        this.accountRepository = AccountRepositoryFactory.getInstance("jdbc");
    }

    public void transferMoney(Account a, Account b) {
        accountRepository.transfer(a, b);
    }
}
