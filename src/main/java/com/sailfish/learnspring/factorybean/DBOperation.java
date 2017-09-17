package com.sailfish.learnspring.factorybean;

/**
 * 操作数据库的接口
 * @author sailfish
 * @create 2017-09-09-下午9:27
 */
public interface DBOperation<T extends DBEntity> {

    void save(T t);

    int remove(T t);

    int update(T t);

    T select(Long id);

}
