/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.sailfish.learnspring.circular.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chengyi
 * @version : GirlFriend.java, v 0.1 2021年01月12日 9:21 下午 chengyi Exp $
 */
@Component
public class GirlFriend {

    private BoyFriend boyFriend;

    @Autowired
    public GirlFriend(BoyFriend boyFriend) {
        this.boyFriend = boyFriend;
    }
}