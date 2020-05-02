package com.sailfish.dataAccess.transaction;

/**
 * @author sailfish
 * @create 2020-05-02-3:34 下午
 */
public interface TransferService {


    void transfer(Long amount, Long a, Long b);
}
