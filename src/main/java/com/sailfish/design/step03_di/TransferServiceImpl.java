package com.sailfish.design.step03_di;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-1:57 下午
 */
public class TransferServiceImpl implements TransferService {


    private TransferRepository transferRepository;

    private AccountRepository accountRepository;

    public TransferServiceImpl(TransferRepository transferRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;  //TransferRepository is injected
        this.accountRepository = accountRepository;  //AccountRepository is injected
    }

    @Override
    public void transferMoney(Long sourceId, Long targetId, Amount amount) {
        Account sourceAccount = accountRepository.findByAccountId(sourceId);
        Account targetAccount = accountRepository.findByAccountId(targetId);
        transferRepository.transfer(sourceAccount, targetAccount, amount);
    }
}
