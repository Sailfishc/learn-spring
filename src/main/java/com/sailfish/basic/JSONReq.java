/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.sailfish.basic;

import lombok.Data;

/**
 * @author chengyi
 * @version : JSONReq.java, v 0.1 2020年11月09日 2:36 下午 chengyi Exp $
 */
@Data
public class JSONReq<T> {

    private String name;


    private T data;
}