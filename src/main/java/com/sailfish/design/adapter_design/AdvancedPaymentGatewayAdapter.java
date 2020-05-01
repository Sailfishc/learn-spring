package com.sailfish.design.adapter_design;

/**
 * @author sailfish
 * @create 2020-05-01-7:47 下午
 */
public class AdvancedPaymentGatewayAdapter implements AdvancedPayGateway {

    private PaymentGateway paymentGateway;

    public AdvancedPaymentGatewayAdapter(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void makePayment(String mobile1, String mobile2) {
        Account account1 = null;//get account number by              mobile number mobile
        Account account2 = null;//get account number by             mobile number mobile
        paymentGateway.doPayment(account1, account2);
    }
}
