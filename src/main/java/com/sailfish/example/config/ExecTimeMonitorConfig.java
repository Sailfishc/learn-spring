package com.sailfish.example.config;

/**
 * @author sailfish
 * @create 2020-05-02-11:58 下午
 */
public class ExecTimeMonitorConfig {
    private Long limitTime = 500L;
    private Integer maxThread = null;
    private boolean limitEntry;
    private String[] limitEntryPaths;

    public ExecTimeMonitorConfig() {
    }

    public Long getLimitTime() {
        return this.limitTime;
    }

    public void setLimitTime(Long limitTime) {
        this.limitTime = limitTime;
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
