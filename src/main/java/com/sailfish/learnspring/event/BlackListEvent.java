package com.sailfish.learnspring.event;

import org.springframework.context.ApplicationEvent;

/**
 * To publish a custom ApplicationEvent, call the publishEvent() method on an ApplicationEventPublisher
 *
 * @author sailfish
 * @create 2020-04-25-11:09 上午
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    // accessor and other methods...


    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}