package com.sailfish.design.abstract_factory_design;

/**
 * @author sailfish
 * @create 2020-05-01-7:10 下午
 */
public class FactoryPatterMain {

    public static void main(String[] args) {
        AccountFactory accountFactory = new AccountFactory();
        Account savingAccount = accountFactory.getAccount("SAVING");
        savingAccount.accountType();

        Account currentAccount = accountFactory.getAccount("CURRENT");
        currentAccount.accountType();
    }
}
