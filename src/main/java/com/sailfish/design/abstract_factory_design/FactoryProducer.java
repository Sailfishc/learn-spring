package com.sailfish.design.abstract_factory_design;

/**
 * @author sailfish
 * @create 2020-05-01-7:10 下午
 */
public class FactoryProducer {

    final static String BANK = "BANK";
    final static String ACCOUNT = "ACCOUNT";

    public static AbstractFactory getFactory(String factory) {
        if (BANK.equalsIgnoreCase(factory)) {
            return new BankFactory();
        } else if (ACCOUNT.equalsIgnoreCase(factory)) {
            return new AccountFactory();
        }
        return null;
    }

}
