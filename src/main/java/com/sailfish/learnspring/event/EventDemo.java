package com.sailfish.learnspring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sailfish
 * @create 2020-04-25-11:18 上午
 */
public class EventDemo {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/event/spring-event.xml");
        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendEmail("known.spammer@example.org", "i love you");
    }
}
