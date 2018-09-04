package com.bcg.sibur.apps.ldt.rproptimizer.service;

import com.bcg.sibur.apps.ldt.rproptimizer.model.RprModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class RprModelService {

    private Logger log = LoggerFactory.getLogger(RprModelService.class);

    private AtomicBoolean calcStatus;

    public RprModelService() {
        this.calcStatus = new AtomicBoolean(false);
    }


    private Integer callCnt = 0;
    private String batPath;
    private String batFile;
    private String batParmTst;
    private String batParmHost;
    private String batParmDbname;
    private String batParmUser;
    private String batParmPass;

    private String pytInter;
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

    public Boolean getCalcStatus() {
        return calcStatus.get();
    }

    public void setPytInter(String pytInter) {
        this.pytInter = pytInter;
    }

    public RprModelService(Integer callCnt, String batPath, String batFile, String batParmTst, String batParmHost, String batParmDbname, String batParmUser, String batParmPass, String pytInter, String pytPath, String pytFile) {
        this.callCnt = callCnt;
        this.batPath = batPath;
        this.batFile = batFile;
        this.batParmTst = batParmTst;
        this.batParmHost = batParmHost;
        this.batParmDbname = batParmDbname;
        this.batParmUser = batParmUser;
        this.batParmPass = batParmPass;
        this.pytInter = pytInter;
        this.pytPath = pytPath;
        this.pytFile = pytFile;
    }

    public RprModel getResponse() throws InterruptedException, IOException {

        RprModel res = null;


            String batScript = batPath.concat(batFile);


            String pytInterpret = pytInter;
            String pytScript = pytPath.concat(pytFile);
            String connStr = batParmHost.concat(" ").concat(batParmDbname).concat(" ").concat(batParmUser).concat(" ").concat(batParmPass);

            List<String> args = new ArrayList<String>();
            args.add(batScript); // command name
            //System.out.println(batDir.concat(batPath).concat(batFile));

            args.add(pytInterpret);

            args.add(pytScript); // path to the python script
            args.add(connStr); // connect string
            //System.out.println(connStr);

            System.out.println(batScript.concat(pytInterpret).concat(pytScript).concat(connStr));
            ProcessBuilder pb = new ProcessBuilder(args);
            Process p = null;

            p = pb.start();
            BufferedReader stdInput = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "See ".concat(batPath).concat("/alien-runner.log").concat(" for ").concat(pytPath.concat(pytFile).concat(" output."));
            Integer errLvl = 0;
            Integer batRetVal = 0;

            //s = stdInput.readLine();
//            errLvl = Integer.valueOf(stdInput.readLine());
//
//            batRetVal = p.waitFor();

            ++callCnt;

            res = new RprModel(batParmHost.concat(" ").concat(batParmDbname).concat(" ").concat(batParmUser).concat(" ").concat("***"), s, errLvl, batRetVal, callCnt);

//            calcStatus.getAndSet(false);

//            log.info(" calc end [{}]", System.currentTimeMillis());
//
//        }
//
//
        return res;

    }

}
