package com.sailfish.design.step03_di;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-2:05 下午
 */
public class JDBCAccountRepository implements AccountRepository{

    @Override
    public void transfer(Account source, Account target) {

    }

    @Override
    public Account findByAccountId(Long accountId) {
        return null;
    }
}
