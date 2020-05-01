package com.sailfish.design.factory_design;

/**
 * @author sailfish
 * @create 2020-05-01-5:17 下午
 */
public class SavingAccount implements Account {

    @Override
    public void accountType() {
        System.out.println("SAVING ACCOUNT");
    }
}
