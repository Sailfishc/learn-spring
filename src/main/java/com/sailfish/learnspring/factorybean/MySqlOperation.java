package com.sailfish.learnspring.factorybean;

/**
 * @author sailfish
 * @create 2017-09-09-下午9:29
 */
public class MySqlOperation implements DBOperation<MySqlEntity>{

    @Override
    public void save(MySqlEntity mySqlEntity) {
        System.out.println("save mysql entity.");
    }

    @Override
    public int remove(MySqlEntity mySqlEntity) {
        System.out.println("remove mysql entity.");
        return 0;
    }

    @Override
    public int update(MySqlEntity mySqlEntity) {
        System.out.println("update mysql entity.");
        return 0;
    }

    @Override
    public MySqlEntity select(Long id) {
        System.out.println("select mysql entity.");
        return new MySqlEntity();
    }
}
