package com.sailfish.design.factory_design;

/**
 * @author sailfish
 * @create 2020-05-01-5:18 下午
 */
public class FactoryPatterMain {



    public static void main(String[] args) {
        AccountFactory accountFactory = new AccountFactory();
        Account savingAccount = accountFactory.getAccount("SAVING");          //call accountType method of SavingAccount
        savingAccount.accountType();          //get an object of CurrentAccount and call its accountType()          method.
        Account currentAccount = accountFactory.getAccount("CURRENT");          //call accountType method of CurrentAccount
        currentAccount.accountType();
    }
}
