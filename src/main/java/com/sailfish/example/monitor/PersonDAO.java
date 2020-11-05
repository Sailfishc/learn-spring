package com.sailfish.example.monitor;

import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2020-05-03-12:16 下午
 */
public class PersonDAO {

    public void findPersonList() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
