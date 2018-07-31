package com.bcg.sibur.apps.ldt.rproptimizer;

import java.io.IOException;

public interface MessageService {
    RprModel getResponse() throws InterruptedException, IOException;
}
