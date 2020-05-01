package com.sailfish.design.factory_design;

/**
 * @author sailfish
 * @create 2020-05-01-5:17 下午
 */
public class AccountFactory {

    final String CURRENT_ACCOUNT = "CURRENT";
    final String SAVING_ACCOUNT = "SAVING";       //use getAccount method to get object of type Account          //It is factory method for object of type Account


    /**
     * 获取账户
     * @param accountType
     * @return
     */
    public Account getAccount(String accountType) {
        if (CURRENT_ACCOUNT.equals(accountType)) {
            return new CurrentAccount();
        } else if (SAVING_ACCOUNT.equals(accountType)) {
            return new SavingAccount();
        }
        return null;
    }
}
