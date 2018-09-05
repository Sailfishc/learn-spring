package com.sailfish.learnspring.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author sailfish
 * @create 2018-02-05-下午7:02
 */
public class AnimalCglibClient {


    public static void main(String[] args) {

        CgLibProxy cgLibProxy = new CgLibProxy();
        Animal animal = (Animal) Enhancer.create(Dog.class, cgLibProxy);

        animal.eat();
//        Before ....
//        Dog eat...
    }
}
