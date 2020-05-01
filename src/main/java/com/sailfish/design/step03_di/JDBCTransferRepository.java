package com.sailfish.design.step03_di;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-2:06 下午
 */
public class JDBCTransferRepository implements TransferRepository{
    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Amount amount) {

    }
}
