package com.sailfish.design.step03_di;

import com.sailfish.design.common.Account;

import java.math.BigDecimal;

/**
 * @author sailfish
 * @create 2020-05-01-1:56 下午
 */
public interface TransferService {


    /**
     * 账户转钱
     * @param a
     * @param b
     */
    void transferMoney(Long sourceId, Long targetId, Amount amount);
}