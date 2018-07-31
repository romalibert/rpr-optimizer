package com.bcg.sibur.apps.ldt.rproptimizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("devsib")
public class RunDevSib implements MessageService {
    @Value("${batdir}")
    private String batDir;

    @Value("${batpath}")
    private String batPath;

    @Value("${batfile}")
    private String batFile;

    @Value("${batparam}")
    private String batParam;

    @Value("${pytdir}")
    private String pytDir;

    @Value("${pytpath}")
    private String pytPath;

    @Value("${pytfile}")
    private String pytFile;

    private Integer callCnt = 0;

    /*
        @RequestMapping(value = "/run-rpr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public String get() {
            return "run rpr";
        }
    */
    @Override
    public RprModel getResponse() throws InterruptedException, IOException {
        List<String> args = new ArrayList<String>();
        RprModel res ;
        args.add (batDir.concat(batPath).concat(batFile)); // command name
        args.add (batParam); // parameter passed in batfile
        args.add (pytDir.concat(pytPath).concat(pytFile)); // path to the python script
        ProcessBuilder pb = new ProcessBuilder (args);
        Process p = null;

        p = pb.start();
        BufferedReader stdInput = new BufferedReader(
                new InputStreamReader( p.getInputStream() ));

        String s ;
        Integer errLvl;
        Integer batRetVal;

        s = stdInput.readLine();
        errLvl = Integer.valueOf(stdInput.readLine());
        batRetVal =  p.waitFor();

        ++callCnt;

        res = new RprModel (batParam, s, errLvl, batRetVal, callCnt);

        return res;

    }
}
