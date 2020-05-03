package com.sailfish.component.handler;

import com.sailfish.component.ExecTimeData;
import com.sailfish.component.config.ExecTimeMonitorConfig;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sailfish
 * @create 2020-05-03-12:02 上午
 */
@Slf4j
public class TreeExecTimeResultHandler extends AbstractExecTimeResultHandler {

    public TreeExecTimeResultHandler() {
        super.needTreeNode = true;
    }

    public void handleResult(ExecTimeData execTimeData, List<ExecTimeData> execTimeDataList, ExecTimeMonitorConfig execTimeMonitorConfig) {
        Iterator var4 = execTimeDataList.iterator();

        while(var4.hasNext()) {
            ExecTimeData timeData = (ExecTimeData)var4.next();
            if (timeData.getParentName() == null && timeData.getExecTime() != null && timeData.getExecTime() >= execTimeMonitorConfig.getLimitTime()) {
                String lineSeparator = System.getProperty("line.separator");
                StringBuilder logTemplate = new StringBuilder();
                logTemplate.append("有待优化:").append(lineSeparator);
                int i = 0;

                while(true) {
                    if (i >= execTimeDataList.size()) {
                        log.info(logTemplate.toString());
                        break;
                    }

                    ExecTimeData item = (ExecTimeData)execTimeDataList.get(i);
                    if (!item.getHaveHandle()) {
                        item.setHaveHandle(true);
                        Integer parentId = item.getParentId();
                        int level = this.getLevel(execTimeDataList, parentId, 0);
                        item.setLevel(level);
                        String perString = this.getPerString(level);
                        logTemplate.append(perString).append("[");
                        if (parentId == null) {
                            logTemplate.append("100%");
                        } else {
                            Iterator var13 = execTimeDataList.iterator();

                            while(var13.hasNext()) {
                                ExecTimeData data = (ExecTimeData)var13.next();
                                if (parentId.equals(data.getId())) {
                                    BigDecimal bigDecimal = (new BigDecimal(String.valueOf(item.getExecTime()))).divide(new BigDecimal(String.valueOf(data.getExecTime())), 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP);
                                    logTemplate.append(bigDecimal.toPlainString()).append("%");
                                    break;
                                }
                            }
                        }

                        logTemplate.append(",").append(item.getExecTime()).append(",").append(level).append(",").append(item.getId());
                        logTemplate.append("] ").append(item.getClassName()).append(".").append(item.getMethodName()).append("(");
                        if (item.getFileName() == null) {
                            logTemplate.append("MonitorStart").append(",").append("0");
                        } else {
                            logTemplate.append(item.getFileName(), 0, item.getFileName().lastIndexOf(".")).append(",").append(item.getLine());
                        }

                        logTemplate.append(")").append(lineSeparator);
                    }

                    ++i;
                }
            }

            if (timeData.getParentName() == null && timeData.getExecTime() != null) {
                timeData.setHaveHandle(true);
            }
        }

    }

    private int getLevel(List<ExecTimeData> execTimeData, Integer parentId, int count) {
        if (parentId == null) {
            return count;
        } else {
            ExecTimeData parentExecTimeData = null;
            Iterator var5 = execTimeData.iterator();

            while(var5.hasNext()) {
                ExecTimeData execTimeDatum = (ExecTimeData)var5.next();
                if (parentId.equals(execTimeDatum.getId())) {
                    parentExecTimeData = execTimeDatum;
                    ++count;
                    break;
                }
            }

            Integer timeDataParentId = parentExecTimeData.getParentId();
            if (parentExecTimeData.getLevel() != null) {
                return parentExecTimeData.getLevel() + count;
            } else {
                return timeDataParentId != null ? this.getLevel(execTimeData, timeDataParentId, count) : count;
            }
        }
    }

    private String getPerString(int level) {
        if (level == 0) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0; i < level - 1; ++i) {
                stringBuilder.append("     ");
            }

            stringBuilder.append("├────");
            return stringBuilder.toString();
        }
    }
}
