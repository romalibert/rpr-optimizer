package com.bcg.sibur.apps.ldt.rproptimizer;

public class RprModel {
    private String scriptParm;
    private String scriptRes;
    private Integer errorLevel;
    private Integer batRetVal;
    private Integer cnt = 0;

    public RprModel() {
        super();
    }

    public RprModel(String scriptParm, String scriptRes, Integer errorLevel, Integer batRetVal) {
        this.scriptParm = scriptParm;
        this.scriptRes = scriptRes;
        this.errorLevel = errorLevel;
        this.batRetVal = batRetVal;
        this.cnt = ++cnt;
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

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

}
