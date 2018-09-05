package com.sailfish.learnspring.proxy;

/**
 * @author sailfish
 * @create 2018-02-05-下午6:53
 */
public class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("Dog eat...");
    }
}
