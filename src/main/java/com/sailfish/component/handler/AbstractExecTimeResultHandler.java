package com.sailfish.component.handler;

import com.sailfish.component.ExecTimeData;
import com.sailfish.component.config.ExecTimeMonitorConfig;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author sailfish
 * @create 2020-05-02-11:59 下午
 */
public abstract class AbstractExecTimeResultHandler {

    protected Boolean needTreeNode;

    public AbstractExecTimeResultHandler() {
    }

    public abstract void handleResult(ExecTimeData var1, List<ExecTimeData> var2, ExecTimeMonitorConfig var3);

    public void removeHold(Semaphore semaphore, ThreadLocal<SoftReference<List<ExecTimeData>>> monitorChainHolder, ThreadLocal<Integer> methodCountHolder, ThreadLocal<Boolean> semaphoreHolder) {
        boolean needRemove = true;
        SoftReference<List<ExecTimeData>> listSoftReference = (SoftReference)monitorChainHolder.get();
        if (listSoftReference != null) {
            List<ExecTimeData> execTimeData = (List)listSoftReference.get();
            if (execTimeData != null) {
                Iterator dataIterator = execTimeData.iterator();

                while(dataIterator.hasNext()) {
                    ExecTimeData execTimeDatum = (ExecTimeData)dataIterator.next();
                    if (!execTimeDatum.getHaveHandle() && execTimeDatum.getParentName() == null) {
                        needRemove = false;
                        break;
                    }
                }
            }
        }

        if (needRemove) {
            monitorChainHolder.remove();
            methodCountHolder.remove();
            if (semaphore != null) {
                semaphore.release();
            }

            if (semaphoreHolder != null) {
                semaphoreHolder.remove();
            }
        }

    }

    public Boolean getNeedTreeNode() {
        return this.needTreeNode;
    }

    public void setNeedTreeNode(Boolean needTreeNode) {
        this.needTreeNode = needTreeNode;
    }
}
