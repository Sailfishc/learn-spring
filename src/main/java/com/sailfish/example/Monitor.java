package com.sailfish.example;

import com.sailfish.example.config.ExecTimeMonitorConfig;
import com.sailfish.example.handler.AbstractExecTimeResultHandler;
import com.sailfish.example.handler.DefaultExecTimeResultHandler;
import com.sailfish.example.handler.TreeExecTimeResultHandler;
import com.sailfish.example.interceptor.ExecTimeMonitorInterceptor;
import com.sailfish.example.mybatis.ExecTimeMonitorPlugin;

import org.aopalliance.intercept.MethodInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sailfish
 * @create 2020-05-02-11:55 下午
 */
@Configuration
public class Monitor {

    private String[] monitorBeanNames;
    private Long limitTime;
    private ExecTimeMonitorTypeEnum monitorType;
    private Boolean monitorMybatis = false;
    private Integer maxThread = null;
    private boolean limitEntry;
    private String[] limitEntryPaths;
    @Autowired(required = false)
    private SqlSessionFactory sqlSessionFactory;

    @Autowired(required = false)
    private ExecTimeMonitor execTimeMonitor;


    @Bean(name = {"execTimeMonitorBean"})
    public BeanNameAutoProxyCreator monitorBean() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setInterceptorNames(new String[]{"execTimeMonitorInterceptor"});
        beanNameAutoProxyCreator.setBeanNames(this.monitorBeanNames);
        beanNameAutoProxyCreator.setProxyTargetClass(true);
        if (this.sqlSessionFactory != null && this.monitorMybatis) {
            org.apache.ibatis.session.Configuration configuration = this.sqlSessionFactory.getConfiguration();
            ExecTimeMonitorPlugin execTimeMonitorPlugin = new ExecTimeMonitorPlugin();
            execTimeMonitorPlugin.setExecTimeMonitor(execTimeMonitor);
            configuration.addInterceptor(execTimeMonitorPlugin);
        }

        return beanNameAutoProxyCreator;
    }

    @Bean(name = {"execTimeMonitorInterceptor"})
    public MethodInterceptor methodInterceptor() {
        ExecTimeMonitorInterceptor execTimeMonitorInterceptor = new ExecTimeMonitorInterceptor();
        execTimeMonitorInterceptor.setExecTimeMonitor(execTimeMonitor);
        return execTimeMonitorInterceptor;
    }

    @Bean(name = {"execTimeMonitor"})
    public ExecTimeMonitor execTimeMonitor() {
        ExecTimeMonitor execTimeMonitor = new ExecTimeMonitor();
        ExecTimeMonitorConfig execTimeMonitorConfig = new ExecTimeMonitorConfig();
        if (null == this.limitTime) {
            this.limitTime = 500L;
        }

        execTimeMonitorConfig.setLimitTime(this.limitTime);
        execTimeMonitorConfig.setMaxThread(this.maxThread);
        execTimeMonitorConfig.setLimitEntry(this.limitEntry);
        execTimeMonitorConfig.setLimitEntryPaths(this.limitEntryPaths);
        execTimeMonitor.setExecTimeMonitorConfig(execTimeMonitorConfig);
        AbstractExecTimeResultHandler execTimeTreeResultHandler = null;
        if (null == this.monitorType) {
            this.monitorType = ExecTimeMonitorTypeEnum.LINE;
        }

        if (this.monitorType == ExecTimeMonitorTypeEnum.LINE) {
            execTimeTreeResultHandler = new DefaultExecTimeResultHandler();
        }

        if (this.monitorType == ExecTimeMonitorTypeEnum.TREE) {
            execTimeTreeResultHandler = new TreeExecTimeResultHandler();
        }

        execTimeMonitor.setExecTimeResultHandler((AbstractExecTimeResultHandler) execTimeTreeResultHandler);
        return execTimeMonitor;
    }

    public String[] getMonitorBeanNames() {
        return this.monitorBeanNames;
    }

    public void setMonitorBeanNames(String[] monitorBeanNames) {
        this.monitorBeanNames = monitorBeanNames;
    }

    public Long getLimitTime() {
        return this.limitTime;
    }

    public void setLimitTime(Long limitTime) {
        this.limitTime = limitTime;
    }

    public ExecTimeMonitorTypeEnum getMonitorType() {
        return this.monitorType;
    }

    public void setMonitorType(ExecTimeMonitorTypeEnum monitorType) {
        this.monitorType = monitorType;
    }

    public Boolean getMonitorMybatis() {
        return this.monitorMybatis;
    }

    public void setMonitorMybatis(Boolean monitorMybatis) {
        this.monitorMybatis = monitorMybatis;
    }

    public Integer getMaxThread() {
        return this.maxThread;
    }

    public void setMaxThread(Integer maxThread) {
        this.maxThread = maxThread;
    }

    public boolean isLimitEntry() {
        return this.limitEntry;
    }

    public void setLimitEntry(boolean limitEntry) {
        this.limitEntry = limitEntry;
    }

    public String[] getLimitEntryPaths() {
        return this.limitEntryPaths;
    }

    public void setLimitEntryPaths(String[] limitEntryPaths) {
        this.limitEntryPaths = limitEntryPaths;
    }
}
