package com.sailfish.example.mybatis_scan_spring.base;

public class UserServiceImpl implements UserService{

    @Override
    public void sayHello(String name) {
        System.out.println("Hello ...");
    }
}
