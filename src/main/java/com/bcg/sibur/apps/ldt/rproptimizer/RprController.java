package com.bcg.sibur.apps.ldt.rproptimizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RprController {
    @Autowired
    private MessageService msg;
    @RequestMapping(value = "/run-script", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RprModel getMessage() throws IOException, InterruptedException {
        return msg.getResponse();
    }
}

