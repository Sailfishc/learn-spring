package com.sailfish.learnspring.hook.demo2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sailfish
 * @create 2017-09-09-下午4:36
 */
public class DataSourceProcessor implements BeanPostProcessor {

    private String env;  //环境
    private String configName;   //配置文件

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof DataSource) {

            Properties properties = new Properties();
            InputStream stream = Object.class.getResourceAsStream("/"+"jdbc_".concat(env).concat(".properties"));
            try {
                properties.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //读取数据
            DataSource dataSource = (DataSource) bean;
//            String driver = dataSource.getDriver();
//            String username = dataSource.getUsername();
//            String url = dataSource.getUrl();
//            String password = dataSource.getPassword();

            String driver = properties.getProperty("jdbc.driver");
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            return new DataSource(driver, url, username, password);


        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
