package com.sailfish.dataAccess.transaction;

import com.sailfish.design.common.Account;

/**
 * @author sailfish
 * @create 2020-05-01-1:40 下午
 */
public interface AccountRepository {

    /**
     * 转账
     *
     * @param source
     * @param target
     */
    void transfer(Account source, Account target);
}
