package com.bcg.sibur.apps.ldt.rproptimizer.service;

import com.bcg.sibur.apps.ldt.rproptimizer.ConfigProperties;
import com.bcg.sibur.apps.ldt.rproptimizer.model.RprModel;
import com.bcg.sibur.apps.ldt.rproptimizer.service.MessageService;
import com.bcg.sibur.apps.ldt.rproptimizer.service.RprModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Profile("dev")
public class RunDev implements MessageService {

    @Autowired
    private ConfigProperties configProperties = new ConfigProperties();

    @Autowired
    private RprModelService rprModelService;

    @Override
    public RprModel getResponse() throws InterruptedException, IOException {

        rprModelService.setBatPath(configProperties.getBatPath());
        rprModelService.setBatFile(configProperties.getBatFile());
        rprModelService.setBatParmHost(configProperties.getBatParmHost());
        rprModelService.setBatParmDbname(configProperties.getBatParmDbname());
        rprModelService.setBatParmUser(configProperties.getBatParmUser());
        rprModelService.setBatParmPass(configProperties.getBatParmPass());

        rprModelService.setPytInter(configProperties.getPytInter());
        rprModelService.setPytPath(configProperties.getPytPath());
        rprModelService.setPytFile(configProperties.getPytFile());

        return rprModelService.getResponse();

    }

    @Override
    public Boolean getCalcStatus() {
        return rprModelService.getCalcStatus();
    }
}
