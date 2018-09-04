package com.bcg.sibur.apps.ldt.rproptimizer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "py")
public class ConfigProperties {

    private String batPath;

    private String batFile;

    private String batParmHost;

    private String batParmDbname;

    private String batParmUser;

    private String batParmPass;

    private String pytPath;

    private String pytFile;

    private String pytInter;

    public String getBatPath() {
        return batPath;
    }

    public void setBatPath(String batPath) {
        this.batPath = batPath;
    }

    public String getBatFile() {
        return batFile;
    }

    public void setBatFile(String batFile) {
        this.batFile = batFile;
    }

    public String getBatParmHost() {
        return batParmHost;
    }

    public void setBatParmHost(String batParmHost) {
        this.batParmHost = batParmHost;
    }

    public String getBatParmDbname() {
        return batParmDbname;
    }

    public void setBatParmDbname(String batParmDbname) {
        this.batParmDbname = batParmDbname;
    }

    public String getBatParmUser() {
        return batParmUser;
    }

    public void setBatParmUser(String batParmUser) {
        this.batParmUser = batParmUser;
    }

    public String getBatParmPass() {
        return batParmPass;
    }

    public void setBatParmPass(String batParmPass) {
        this.batParmPass = batParmPass;
    }

    public String getPytPath() {
        return pytPath;
    }

    public void setPytPath(String pytPath) {
        this.pytPath = pytPath;
    }

    public String getPytFile() {
        return pytFile;
    }

    public void setPytFile(String pytFile) {
        this.pytFile = pytFile;
    }

    public String getPytInter() {
        return pytInter;
    }

    public void setPytInter(String pytInter) {
        this.pytInter = pytInter;
    }
}
