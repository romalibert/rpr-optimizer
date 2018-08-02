package com.bcg.sibur.apps.ldt.rproptimizer;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class RprModelService {

    private Integer callCnt = 0;
    private String batPath;
    private String batFile;
    private String batParmTst;
    private String batParmHost;
    private String batParmDbname;
    private String batParmUser;
    private String batParmPass;
    private String pytPath;
    private String pytFile;

    public void setCallCnt(Integer callCnt) {
        this.callCnt = callCnt;
    }

    public void setBatPath(String batPath) {
        this.batPath = batPath;
    }

    public void setBatFile(String batFile) {
        this.batFile = batFile;
    }

    public void setBatParmTst(String batParmTst) {
        this.batParmTst = batParmTst;
    }

    public void setBatParmHost(String batParmHost) {
        this.batParmHost = batParmHost;
    }

    public void setBatParmDbname(String batParmDbname) {
        this.batParmDbname = batParmDbname;
    }

    public void setBatParmUser(String batParmUser) {
        this.batParmUser = batParmUser;
    }

    public void setBatParmPass(String batParmPass) {
        this.batParmPass = batParmPass;
    }

    public void setPytPath(String pytPath) {
        this.pytPath = pytPath;
    }

    public void setPytFile(String pytFile) {
        this.pytFile = pytFile;
    }

    public RprModelService() {
    }

    public RprModelService(Integer callCnt, String batPath, String batFile, String batParmTst, String batParmHost, String batParmDbname, String batParmUser, String batParmPass, String pytPath, String pytFile) {
        this.callCnt = callCnt;
        this.batPath = batPath;
        this.batFile = batFile;
        this.batParmTst = batParmTst;
        this.batParmHost = batParmHost;
        this.batParmDbname = batParmDbname;
        this.batParmUser = batParmUser;
        this.batParmPass = batParmPass;
        this.pytPath = pytPath;
        this.pytFile = pytFile;
    }

    public RprModel getResponse() throws InterruptedException, IOException {
        String connStr = "\"".concat(batParmHost).concat(" ").concat(batParmDbname).concat(" ").concat(batParmUser).concat(" ").concat(batParmPass).concat("\"");

        List<String> args = new ArrayList<String>();
        RprModel res ;
        args.add (batPath.concat(batFile)); // command name
        //System.out.println(batDir.concat(batPath).concat(batFile));
        args.add (connStr); // connect string
        //System.out.println(connStr);
        args.add (pytPath.concat(pytFile)); // path to the python script
        //System.out.println(pytDir.concat(pytPath).concat(pytFile));
        ProcessBuilder pb = new ProcessBuilder (args);
        Process p = null;

        p = pb.start();
        BufferedReader stdInput = new BufferedReader(
                new InputStreamReader( p.getInputStream() ));

        String s = "See runbat.log for ".concat(pytPath.concat(pytFile).concat(" output."));
        Integer errLvl;
        Integer batRetVal;

        //s = stdInput.readLine();
        errLvl = Integer.valueOf(stdInput.readLine());

        batRetVal =  p.waitFor();

        ++callCnt;

        res = new RprModel (connStr, s, errLvl, batRetVal, callCnt);

        return res;

    }

}
