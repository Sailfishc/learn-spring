package com.sailfish.example.interceptor;

import com.sailfish.example.ExecTimeData;
import com.sailfish.example.ExecTimeMonitor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author sailfish
 * @create 2020-05-02-11:59 下午
 */
public class ExecTimeMonitorInterceptor implements MethodInterceptor {

    private ExecTimeMonitor execTimeMonitor;


    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        boolean isNeedMonitor = this.execTimeMonitor.isNeedMonitor(method, declaringClass);
        if (isNeedMonitor) {
            String className = declaringClass.getName();
            String methodName = method.getName();
            ExecTimeData execTimeData = null;

            Object var8;
            try {
                execTimeData = this.execTimeMonitor.initExecTimeData(className, methodName);
                this.execTimeMonitor.startMonitor(className, methodName, execTimeData);
                var8 = invocation.proceed();
            } finally {
                this.execTimeMonitor.stopMonitor(execTimeData);
            }

            return var8;
        } else {
            return invocation.proceed();
        }
    }

    public ExecTimeMonitor getExecTimeMonitor() {
        return this.execTimeMonitor;
    }

    public void setExecTimeMonitor(ExecTimeMonitor execTimeMonitor) {
        this.execTimeMonitor = execTimeMonitor;
    }
}
