package com.sailfish.component;

/**
 * @author sailfish
 * @create 2020-05-02-11:57 下午
 */
public class ExecTimeData {

    private Integer id;
    private Integer parentId;
    private String parentName;
    private String methodName;
    private String className;
    private Long execTime;
    private Long startTime;
    private Long endTime;
    private Boolean haveHandle;
    private String fileName;
    private Integer line;
    private Integer level;


    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getHaveHandle() {
        return this.haveHandle;
    }

    public void setHaveHandle(Boolean haveHandle) {
        this.haveHandle = haveHandle;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getExecTime() {
        return this.execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getLine() {
        return this.line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

}
