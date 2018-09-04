package com.bcg.sibur.apps.ldt.rproptimizer.controller;

import com.bcg.sibur.apps.artifact.HttpResponse;
import com.bcg.sibur.apps.ldt.rproptimizer.model.RprModel;
import com.bcg.sibur.apps.ldt.rproptimizer.service.MessageService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RprController {

    private Logger log = LoggerFactory.getLogger(RprController.class);



    @Autowired
    private MessageService msg;

    @Autowired
    private TaskExecutor taskExecutor;

    @RequestMapping(
            value = "/status",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpResponse getStatus() {
        return new HttpResponse().setResponse(
                new Gson().toJson(msg.getCalcStatus())
                // new Gson().toJson(calcStatus.get())
        );
    }

    @RequestMapping(
            value = "/runopt",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpResponse getMessage() throws IOException, InterruptedException {

        if (!msg.getCalcStatus()) {
            log.info(" calc run [{}]", System.currentTimeMillis());

            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        RprModel ret = msg.getResponse();
                    } catch (InterruptedException | IOException e) {
                        log.error("", e);
                    }
                }
            });
        }

        return new HttpResponse("Ведется пересчет оптимальных маршрутов", HttpStatus.OK);

    }

}

