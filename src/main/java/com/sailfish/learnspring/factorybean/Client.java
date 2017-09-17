package com.sailfish.learnspring.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://blog.csdn.net/linuu/article/details/50855446
 * @author sailfish
 * @create 2017-09-09-下午9:35
 */
public class Client {

    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-factory-bean.xml");
//        //beanfaactory的getBean()返回的是beanFactory的getObject的对象
//        DBOperation proxyDB = context.getBean("proxyDB", DBOperation.class);
//        //remove mysql entity.
//        proxyDB.remove(new MySqlEntity());


        //从BeanFactory中获取FactoryBean,以&标识
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-factory-bean.xml");
        //beanfaactory的getBean()返回的是beanFactory的getObject的对象
        FactoryBean bean = context.getBean("&proxyDB", FactoryBean.class);
        DBOperation object = (DBOperation) bean.getObject();
        //remove mysql entity.
        object.remove(new MySqlEntity());
    }
}
