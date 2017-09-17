package com.sailfish.learnspring.factorybean;

/**
 * @author sailfish
 * @create 2017-09-09-下午9:31
 */
public class RedisOperation implements DBOperation<RedisEntity> {

    @Override
    public void save(RedisEntity redisEntity) {
        System.out.println("save redis entity");
    }

    @Override
    public int remove(RedisEntity redisEntity) {
        System.out.println("remove redis entity");
        return 0;
    }

    @Override
    public int update(RedisEntity redisEntity) {
        System.out.println("update redis entity");
        return 0;
    }

    @Override
    public RedisEntity select(Long id) {
        System.out.println("select redis entity");
        return new RedisEntity();
    }
}
