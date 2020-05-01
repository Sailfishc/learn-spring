package com.sailfish.design.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author sailfish
 * @create 2020-05-01-8:14 下午
 */
public class AccountRepositoryFactoryBean implements FactoryBean<IAccountRepository> {


    @Override
    public IAccountRepository getObject() throws Exception {
        return new AccountRepository();
    }

    @Override
    public Class<?> getObjectType() {
        return IAccountRepository.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
