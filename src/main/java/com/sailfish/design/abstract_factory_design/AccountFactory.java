package com.sailfish.design.abstract_factory_design;

/**
 * @author sailfish
 * @create 2020-05-01-7:07 下午
 */
public class AccountFactory extends AbstractFactory {

    final String CURRENT_ACCOUNT = "CURRENT";
    final String SAVING_ACCOUNT = "SAVING";

    //use getAccount method to get object of type Account          //It is factory method for object of type Account

    @Override
    public Bank getBank(String bankName) {
        return null;
    }

    @Override
    public Account getAccount(String accountType) {
        if (CURRENT_ACCOUNT.equals(accountType)) {
            return new CurrentAccount();
        } else if (SAVING_ACCOUNT.equals(accountType)) {
            return new SavingAccount();
        }
        return null;
    }
}
