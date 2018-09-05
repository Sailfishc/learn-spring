package com.sailfish.learnspring.proxy;

import java.lang.reflect.Proxy;

/**
 * @author sailfish
 * @create 2018-02-05-下午6:53
 */
public class AnimalProxy {


    public static void main(String[] args) {

        Animal animal = new Dog();

        DynamicProxy proxy = new DynamicProxy(animal);  //代理 对象

        Animal animalProxy = (Animal) Proxy.newProxyInstance(animal.getClass().getClassLoader(),
                animal.getClass().getInterfaces(),
                proxy);
        animalProxy.eat();
//        Before ....
//        Dog eat...

    }
}
