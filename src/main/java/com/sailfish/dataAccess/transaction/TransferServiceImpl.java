package com.sailfish.dataAccess.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author sailfish
 * @create 2020-05-02-3:34 下午
 */
@Component
public class TransferServiceImpl implements TransferService {

//    @Autowired
//    private TransactionTemplate transactionTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void transfer(Long amount, Long a, Long b) {

    }
}
