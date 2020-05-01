package com.sailfish.design.abstract_factory_design;


/**
 * @author sailfish
 * @create 2020-05-01-5:17 下午
 */
public class CurrentAccount implements Account {

    @Override
    public void accountType() {
        System.out.println("CURRENT ACCOUNT");
    }
}
