package com.sailfish.design.adapter_design;

/**
 * @author sailfish
 * @create 2020-05-01-7:48 下午
 */
public class AdapterPatternMain {


    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGatewayImpl();
        AdvancedPayGateway advancedPayGateway = new AdvancedPaymentGatewayAdapter(paymentGateway);
        String mobile1 = null;
        String mobile2 = null;
        advancedPayGateway.makePayment(mobile1, mobile2);
    }
}
