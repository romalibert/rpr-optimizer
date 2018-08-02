package com.bcg.sibur.apps.ldt.rproptimizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Profile("dev")
public class RunDev implements MessageService {

    @Value("${batpath}")
    private String batPath;

    @Value("${batfile}")
    private String batFile;

    @Value("${batparmtst}")
    private String batParmTst;

    @Value("${batparmhost}")
    private String batParmHost;

    @Value("${batparmdbname}")
    private String batParmDbname;

    @Value("${batparmuser}")
    private String batParmUser;

    @Value("${batparmpass}")
    private String batParmPass;

    @Value("${pytpath}")
    private String pytPath;

    @Value("${pytfile}")
    private String pytFile;

    @Autowired
    private RprModelService rprModelService;

    @Override
    public RprModel getResponse() throws InterruptedException, IOException {

        rprModelService.setBatPath(batPath);
        rprModelService.setBatFile(batFile);
        rprModelService.setBatParmHost(batParmHost);
        rprModelService.setBatParmDbname(batParmDbname);
        rprModelService.setBatParmUser(batParmUser);
        rprModelService.setBatParmPass(batParmPass);

        rprModelService.setPytPath(pytPath);
        rprModelService.setPytFile(pytFile);

        return rprModelService.getResponse();

    }
}
