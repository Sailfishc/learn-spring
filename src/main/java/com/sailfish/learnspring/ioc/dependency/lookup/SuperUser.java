package com.sailfish.learnspring.ioc.dependency.lookup;

import lombok.Data;

/**
 * @author sailfish
 * @create 2020-04-21-11:28 下午
 */
@Data
@Super
public class SuperUser extends User{

    private String address;

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
