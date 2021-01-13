/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.BeanDefinitionBuilder;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 参考：https://juejin.cn/book/6857911863016390663/section/6860301923770990606
 * @author chengyi
 * @version : ProgrammaticInjectApplication.java, v 0.1 2021年01月13日 10:34 下午 chengyi Exp $
 */
public class ProgrammaticInjectApplication {


    // 结论：refresh 方法的执行，会触发非延迟加载的单实例 bean 的实例化和初始化。
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        BeanDefinition personDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "老王").getBeanDefinition();
        ctx.registerBeanDefinition("laowang", personDefinition);

        BeanDefinition catDefinition = BeanDefinitionBuilder.rootBeanDefinition(Cat.class)
                .addPropertyValue("name", "咪咪").addPropertyReference("person", "laowang")
                .getBeanDefinition();
        ctx.registerBeanDefinition("mimi", catDefinition);

        BeanDefinition dogDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class)
                .addPropertyValue("name", "汪汪").addPropertyReference("person", "laowang")
                .setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE).getBeanDefinition();
        ctx.registerBeanDefinition("wangwang", dogDefinition);

        ctx.refresh();
        System.out.println("ApplicationContext refreshed ......");

        Cat cat = ctx.getBean(Cat.class);
        Dog dog = ctx.getBean(Dog.class);
        System.out.println(cat);
        System.out.println(dog);

    }
}