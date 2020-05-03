package com.sailfish.component.interceptor;

import com.sailfish.component.ExecTimeData;
import com.sailfish.component.ExecTimeMonitor;

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

            Object result;
            try {
                execTimeData = this.execTimeMonitor.initExecTimeData(className, methodName);
                this.execTimeMonitor.startMonitor(className, methodName, execTimeData);
                result = invocation.proceed();
            } finally {
                this.execTimeMonitor.stopMonitor(execTimeData);
            }

            return result;
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
