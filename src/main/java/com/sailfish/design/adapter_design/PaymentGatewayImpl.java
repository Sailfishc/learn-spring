package com.sailfish.design.adapter_design;

/**
 * @author sailfish
 * @create 2020-05-01-7:46 下午
 */
public class PaymentGatewayImpl implements PaymentGateway{

    @Override
    public void doPayment(Account account1, Account account2) {
        System.out.println("Do payment using Payment Gateway");
    }
}
