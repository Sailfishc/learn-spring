/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.BeanDefinitionBuilder;

import lombok.Data;

/**
 * @author chengyi
 * @version : Animal.java, v 0.1 2021年01月13日 10:29 下午 chengyi Exp $
 */
@Data
public abstract class Animal {

    protected String name;

    protected Person person;

    public Animal() {
        System.out.println("Animal Constructor run ...");
    }
}