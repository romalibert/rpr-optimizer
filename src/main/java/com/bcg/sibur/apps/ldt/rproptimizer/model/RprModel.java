package com.bcg.sibur.apps.ldt.rproptimizer.model;

public class RprModel {
    private String scriptParm;
    private String scriptRes;
    private Integer errorLevel;
    private Integer batRetVal;
    private Integer callCnt;

    public RprModel() {
        super();
    }

    public RprModel(String scriptParm, String scriptRes, Integer errorLevel, Integer batRetVal, Integer callCnt) {
        this.scriptParm = scriptParm;
        this.scriptRes = scriptRes;
        this.errorLevel = errorLevel;
        this.batRetVal = batRetVal;
        this.callCnt = callCnt;
    }

    public String getScriptRes() {
        return scriptRes;
    }

    public void setScriptRes(String scriptRes) {
        this.scriptRes = scriptRes;
    }

    public Integer getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(Integer errorLevel) {
        this.errorLevel = errorLevel;
    }

    public Integer getBatRetVal() {
        return batRetVal;
    }

    public void setBatRetVal(Integer batRetVal) {
        this.batRetVal = batRetVal;
    }

    public RprModel(Integer batRetVal) {
        this.batRetVal = batRetVal;
    }

    public String getScriptParm() {
        return scriptParm;
    }

    public void setScriptParm(String scriptParm) {
        this.scriptParm = scriptParm;
    }

    public RprModel(String scriptParm) {
        this.scriptParm = scriptParm;
    }

    public Integer getCallCnt() {
        return callCnt;
    }

    public void setCallCnt(Integer callCnt) {
        this.callCnt = callCnt;
    }

    @Override
    public String toString() {
        return "RprModel{" +
                "scriptParm='" + scriptParm + '\'' +
                ", scriptRes='" + scriptRes + '\'' +
                ", errorLevel=" + errorLevel +
                ", batRetVal=" + batRetVal +
                ", callCnt=" + callCnt +
                '}';
    }
}
