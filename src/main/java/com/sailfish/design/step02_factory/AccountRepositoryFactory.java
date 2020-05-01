package com.sailfish.design.step02_factory;


/**
 * @author sailfish
 * @create 2020-05-01-1:49 下午
 */
public class AccountRepositoryFactory {


    public static AccountRepository getInstance(String type) {
        return new JDBCAccountRepository();
    }
}
