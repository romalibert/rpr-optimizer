package com.bcg.sibur.apps.ldt.rproptimizer.service;

import com.bcg.sibur.apps.ldt.rproptimizer.model.RprModel;

import java.io.IOException;

public interface MessageService {
    RprModel getResponse() throws InterruptedException, IOException;

    Boolean getCalcStatus();
}
