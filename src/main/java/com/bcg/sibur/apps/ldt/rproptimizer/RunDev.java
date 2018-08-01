package com.bcg.sibur.apps.ldt.rproptimizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

    private Integer callCnt = 0;

    /*
        @RequestMapping(value = "/run-rpr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public String get() {
            return "run rpr";
        }
    */
    @Override
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

        String s = "See tmp.log for ".concat(pytPath.concat(pytFile).concat(" output."));
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
