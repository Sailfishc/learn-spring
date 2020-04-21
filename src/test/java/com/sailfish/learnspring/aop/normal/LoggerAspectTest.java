package com.sailfish.learnspring.aop.normal;

import com.sailfish.learnspring.aop.proxyFactoryBean.BussinessService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sailfish
 * @create 2017-09-11-上午10:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring-practice/spring-aop-normal.xml")
public class LoggerAspectTest {

    @Autowired
    private BussinessService bussinessService;

    @Test
    public void doBefore() throws Exception {
        bussinessService.say();
    }

}
//args:[Ljava.lang.Object;@740cae06,
// kind:method-execution,
// signature:void com.sailfish.learnspring.aop.proxyFactoryBean.BussinessService.say(),
// name:com.sailfish.learnspring.aop.proxyFactoryBean.BussinessServiceImpl
//        say hello