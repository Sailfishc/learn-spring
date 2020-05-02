package com.sailfish.cycle.step03_InitializerExtensionPoint;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-1:50 下午
 */
public class JDBCAccountRepository implements AccountRepository {

    @Override
    public void transfer(Account source, Account target) {

    }

    public void populateCache() {
        System.out.println("Called populateCache() method");
    }
}
