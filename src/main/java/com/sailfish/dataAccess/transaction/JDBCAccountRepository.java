package com.sailfish.dataAccess.transaction;

import com.sailfish.design.common.Account;

import org.springframework.stereotype.Repository;

/**
 * @author sailfish
 * @create 2020-05-01-1:50 下午
 */
@Repository
public class JDBCAccountRepository implements AccountRepository {

    @Override
    public void transfer(Account source, Account target) {

    }

    public void populateCache() {
        System.out.println("Called populateCache() method");
    }
}
