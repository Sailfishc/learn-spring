/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.beanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengyi
 * @version : Client.java, v 0.1 2021年01月13日 6:15 下午 chengyi Exp $
 */
@Configuration
@ComponentScan(basePackages = "com.sailfish.learnspring.beanPostProcessor")
public class Client {

    @Bean
    public Ball ball() {
        Ball ball = new Ball();
        ball.setName("111");
        return ball;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Client.class);
        Ball ball = context.getBean(Ball.class);
        // Ball(name=橙子篮球)
        System.out.println(ball);
    }

}