package com.sailfish.learnspring.aopProxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author sailfish
 * @create 2018-09-13-上午10:18
 */
public class Client2 {

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new LogBeforeAdvice());
        // Exception in thread "main" java.lang.IllegalStateException: Cannot find current proxy: Set 'exposeProxy' property on Advised to 'true' to make it available.
        factory.setExposeProxy(true);

        Pojo proxy = (Pojo) factory.getProxy();

        // method call on the proxy
        // bar method not advice
        proxy.foo();

//        proxy.bar();
    }
}
