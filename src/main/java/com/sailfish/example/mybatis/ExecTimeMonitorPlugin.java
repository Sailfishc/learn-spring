package com.sailfish.example.mybatis;

import com.sailfish.example.ExecTimeData;
import com.sailfish.example.ExecTimeMonitor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author sailfish
 * @create 2020-05-03-12:03 上午
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
public class ExecTimeMonitorPlugin implements Interceptor {
    private ExecTimeMonitor execTimeMonitor;

    public ExecTimeMonitorPlugin() {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        String id = mappedStatement.getId();
        String className = id.substring(0, id.lastIndexOf("."));
        String methodName = id.substring(id.lastIndexOf(".") + 1);
        Class<?> declaringClass = Class.forName(className);
        Method method = null;
        Method[] var9 = declaringClass.getDeclaredMethods();
        int var10 = var9.length;

        for (int var11 = 0; var11 < var10; ++var11) {
            Method declaredMethod = var9[var11];
            if (declaredMethod.getName().equals(methodName)) {
                method = declaredMethod;
            }
        }

        boolean isNeedMonitor = this.execTimeMonitor.isNeedMonitor(method, declaringClass);
        if (isNeedMonitor) {
            ExecTimeData execTimeData = null;

            Object var17;
            try {
                execTimeData = this.execTimeMonitor.initExecTimeData(className, methodName);
                this.execTimeMonitor.startMonitor(className, methodName, execTimeData);
                var17 = invocation.proceed();
            } finally {
                this.execTimeMonitor.stopMonitor(execTimeData);
            }

            return var17;
        } else {
            return invocation.proceed();
        }
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }

    public ExecTimeMonitor getExecTimeMonitor() {
        return this.execTimeMonitor;
    }

    public void setExecTimeMonitor(ExecTimeMonitor execTimeMonitor) {
        this.execTimeMonitor = execTimeMonitor;
    }
}
