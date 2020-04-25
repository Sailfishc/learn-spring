package com.sailfish.learnspring.event;

import org.springframework.context.ApplicationListener;

/**
 * @author sailfish
 * @create 2020-04-25-11:11 上午
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    public void onApplicationEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("receive blackEvent. " + "address=" + event.getAddress() + " content=" + event.getContent());
    }
}