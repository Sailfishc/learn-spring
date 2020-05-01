package com.sailfish.design.step03_di;

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

    /**
     * 根据账户id插查找账户
     * @param accountId
     * @return
     */
    Account findByAccountId(Long accountId);

}
