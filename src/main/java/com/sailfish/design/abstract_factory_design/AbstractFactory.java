package com.sailfish.design.abstract_factory_design;

/**
 * @author sailfish
 * @create 2020-05-01-7:05 下午
 */
public abstract class AbstractFactory {

    abstract Bank getBank(String bankName);

    abstract Account getAccount(String accountType);
}
