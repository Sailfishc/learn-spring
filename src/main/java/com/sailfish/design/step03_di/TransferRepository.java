package com.sailfish.design.step03_di;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-1:57 下午
 */
public interface TransferRepository {


    /**
     * 转账
     * @param sourceAccount
     * @param targetAccount
     * @param amount
     */
    void transfer(Account sourceAccount, Account targetAccount, Amount amount);

}
