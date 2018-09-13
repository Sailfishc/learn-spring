package com.sailfish.learnspring.aopProxy;

/**
 * @author sailfish
 * @create 2018-09-13-上午10:17
 */
public class Client {


    public static void main(String[] args) {
        Pojo pojo = new SimplePojo();

        pojo.foo();
    }
}
