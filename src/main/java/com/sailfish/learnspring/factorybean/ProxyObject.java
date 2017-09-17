package com.sailfish.learnspring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author sailfish
 * @create 2017-09-09-下午9:32
 */
public class ProxyObject implements FactoryBean<Object> {


    private String currentDB;

    public String getCurrentDB() {
        return currentDB;
    }

    public void setCurrentDB(String currentDB) {
        this.currentDB = currentDB;
    }

    @Override
    public Object getObject() throws Exception {
        if ("mysql".equals(currentDB)) {
            return new MySqlOperation();
        }
        return new RedisOperation();
    }

    @Override
    public Class<?> getObjectType() {
        if ("mysql".equals(currentDB)) {
            return MySqlOperation.class;
        }
        return RedisOperation.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
