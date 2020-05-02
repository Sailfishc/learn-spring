package com.sailfish.cycle.step02_initBeanInstance;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sailfish
 * @create 2020-05-02-2:54 下午
 */
public class BeanLifeCycleDemo {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.close();
    }
}
