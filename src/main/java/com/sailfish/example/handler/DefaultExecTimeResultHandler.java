package com.sailfish.example.handler;

import com.sailfish.example.ExecTimeData;
import com.sailfish.example.config.ExecTimeMonitorConfig;

import java.util.List;

/**
 * @author sailfish
 * @create 2020-05-03-12:01 上午
 */
public class DefaultExecTimeResultHandler extends AbstractExecTimeResultHandler {

    public DefaultExecTimeResultHandler() {
        super.needTreeNode = false;
    }

    public void handleResult(ExecTimeData execTimeData, List<ExecTimeData> execTimeDataList, ExecTimeMonitorConfig execTimeMonitorConfig) {
        execTimeData.setHaveHandle(true);
        if (execTimeData.getExecTime() >= execTimeMonitorConfig.getLimitTime()) {
            String lineSeparator = System.getProperty("line.separator");
            StringBuilder logTemplate = new StringBuilder();
            logTemplate.append("有待优化:").append(lineSeparator);
            logTemplate.append("[");
            logTemplate.append("100%");
            logTemplate.append(",").append(execTimeData.getExecTime()).append(",").append("0").append(",").append(execTimeData.getId()).append("]").append(execTimeData.getClassName()).append(".").append(execTimeData.getMethodName()).append(lineSeparator);
        }

    }

}
