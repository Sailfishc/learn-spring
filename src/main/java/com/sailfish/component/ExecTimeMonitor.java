package com.sailfish.component;

import com.sailfish.component.annotation.UnNeedMonitor;
import com.sailfish.component.config.ExecTimeMonitorConfig;
import com.sailfish.component.handler.AbstractExecTimeResultHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.AntPathMatcher;

import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author sailfish
 * @create 2020-05-02-11:56 下午
 */
public class ExecTimeMonitor implements InitializingBean {

    private AntPathMatcher antPathMatcher = null;
    private final ThreadLocal<SoftReference<List<ExecTimeData>>> monitorChainHolder = new ThreadLocal();
    private final ThreadLocal<Integer> methodCountHolder = new ThreadLocal();
    private ThreadLocal<Boolean> semaphoreHolder = null;
    private ExecTimeMonitorConfig execTimeMonitorConfig = null;
    private AbstractExecTimeResultHandler execTimeResultHandler = null;
    private Semaphore semaphore = null;


    public boolean isNeedMonitor(Method method, Class<?> declaringClass) {
        boolean classUnNeedMonitor = declaringClass.isAnnotationPresent(UnNeedMonitor.class);
        boolean isMatchPath = false;
        if (this.execTimeMonitorConfig.isLimitEntry()) {
            String[] limitEntryPaths = this.execTimeMonitorConfig.getLimitEntryPaths();
            if (limitEntryPaths == null || limitEntryPaths.length < 1) {
                return false;
            }

            String entryPath = null;
            SoftReference<List<ExecTimeData>> listSoftReference = (SoftReference) this.monitorChainHolder.get();
            List<ExecTimeData> execTimeData = null;
            if (listSoftReference != null) {
                execTimeData = (List) listSoftReference.get();
            }

            if (listSoftReference == null && this.monitorChainHolder.get() == null) {
                entryPath = declaringClass.getName();
            } else if (listSoftReference != null && execTimeData != null && execTimeData.size() > 0) {
                entryPath = ((ExecTimeData) execTimeData.get(0)).getClassName();
            }

            if (entryPath == null) {
                return false;
            }

            String[] entryPaths = limitEntryPaths;
            int length = limitEntryPaths.length;

            for (int i = 0; i < length; ++i) {
                String limitEntryPath = entryPaths[i];
                boolean match = this.antPathMatcher.match(limitEntryPath, entryPath);
                if (match) {
                    isMatchPath = true;
                }
            }

            if (!isMatchPath) {
                return false;
            }
        }

        if (classUnNeedMonitor) {
            return false;
        } else {
            boolean methodUnNeedMonitor = method.isAnnotationPresent(UnNeedMonitor.class);
            if (this.execTimeMonitorConfig.getMaxThread() == null) {
                return !methodUnNeedMonitor;
            } else if (this.semaphoreHolder.get() == null) {
                boolean acquire = this.semaphore.tryAcquire();
                this.semaphoreHolder.set(acquire);
                return acquire && !methodUnNeedMonitor && isMatchPath;
            } else {
                return (Boolean) this.semaphoreHolder.get() && !methodUnNeedMonitor && isMatchPath;
            }
        }
    }

    public ExecTimeData initExecTimeData(String className, String methodName) {
        Integer methodId = (Integer) this.methodCountHolder.get();
        if (methodId == null) {
            methodId = 0;
        } else {
            methodId = methodId + 1;
        }

        ExecTimeData execTimeData = new ExecTimeData();
        execTimeData.setParentName((String) null);
        execTimeData.setClassName(className);
        execTimeData.setMethodName(methodName);
        execTimeData.setHaveHandle(false);
        this.methodCountHolder.set(methodId);
        execTimeData.setId(methodId);
        return execTimeData;
    }

    public void startMonitor(String className, String methodName, ExecTimeData execTimeData) {
        SoftReference<List<ExecTimeData>> listSoftReference = (SoftReference) this.monitorChainHolder.get();
        List<ExecTimeData> execTimeDataList = null;
        if (listSoftReference != null) {
            execTimeDataList = (List) listSoftReference.get();
        }

        if (listSoftReference != null || (Integer) this.methodCountHolder.get() == 0) {
            if (listSoftReference == null || execTimeDataList != null || (Integer) this.methodCountHolder.get() == 0) {
                if (execTimeDataList != null && execTimeDataList.size() >= 1) {
                    if (this.execTimeResultHandler.getNeedTreeNode()) {
                        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                        StackTraceElement[] stackTraceElements = stackTrace;
                        int length = stackTrace.length;

                        for (int i = 0; i < length; ++i) {
                            StackTraceElement stackTraceElement = stackTraceElements[i];
                            String traceElementClassName = stackTraceElement.getClassName();
                            String traceElementMethodName = stackTraceElement.getMethodName();
                            boolean hasGetParent = false;

                            for (int index = execTimeDataList.size() - 1; index >= 0; --index) {
                                ExecTimeData parentMonitorClass = (ExecTimeData) execTimeDataList.get(index);
                                if (parentMonitorClass.getClassName().equals(traceElementClassName) && parentMonitorClass.getMethodName().equals(traceElementMethodName) && !(traceElementClassName + "." + traceElementMethodName).equals(className + "." + methodName)) {
                                    execTimeData.setParentName(parentMonitorClass.getClassName() + "." + parentMonitorClass.getMethodName());
                                    execTimeData.setParentId(parentMonitorClass.getId());
                                    execTimeData.setFileName(stackTraceElement.getFileName());
                                    execTimeData.setLine(stackTraceElement.getLineNumber());
                                    hasGetParent = true;
                                    break;
                                }
                            }

                            if (hasGetParent) {
                                break;
                            }
                        }
                    }

                    execTimeDataList.add(execTimeData);
                } else {
                    List<ExecTimeData> newExecTimeDataList = new LinkedList();
                    newExecTimeDataList.add(execTimeData);
                    this.monitorChainHolder.set(new SoftReference(newExecTimeDataList));
                }

                execTimeData.setStartTime(System.currentTimeMillis());
            }
        }
    }

    public void stopMonitor(ExecTimeData execTimeData) {
        SoftReference<List<ExecTimeData>> listSoftReference = (SoftReference) this.monitorChainHolder.get();
        List<ExecTimeData> execTimeDataList = null;
        if (listSoftReference != null) {
            execTimeDataList = (List) listSoftReference.get();
        }

        if (execTimeDataList == null) {
            this.execTimeResultHandler.removeHold(this.semaphore, this.monitorChainHolder, this.methodCountHolder, this.semaphoreHolder);
        } else {
            execTimeData.setEndTime(System.currentTimeMillis());
            execTimeData.setExecTime(execTimeData.getEndTime() - execTimeData.getStartTime());
            this.execTimeResultHandler.handleResult(execTimeData, execTimeDataList, this.execTimeMonitorConfig);
            this.execTimeResultHandler.removeHold(this.semaphore, this.monitorChainHolder, this.methodCountHolder, this.semaphoreHolder);
        }

    }

    public ExecTimeMonitorConfig getExecTimeMonitorConfig() {
        return this.execTimeMonitorConfig;
    }

    public void setExecTimeMonitorConfig(ExecTimeMonitorConfig execTimeMonitorConfig) {
        this.execTimeMonitorConfig = execTimeMonitorConfig;
    }

    public AbstractExecTimeResultHandler getExecTimeResultHandler() {
        return this.execTimeResultHandler;
    }

    public void setExecTimeResultHandler(AbstractExecTimeResultHandler execTimeResultHandler) {
        this.execTimeResultHandler = execTimeResultHandler;
    }

    public void afterPropertiesSet() throws Exception {
        if (this.execTimeMonitorConfig.getMaxThread() != null) {
            this.semaphore = new Semaphore(this.execTimeMonitorConfig.getMaxThread());
            this.semaphoreHolder = new ThreadLocal();
        }

        if (this.execTimeMonitorConfig.isLimitEntry()) {
            this.antPathMatcher = new AntPathMatcher();
        }
    }
}
