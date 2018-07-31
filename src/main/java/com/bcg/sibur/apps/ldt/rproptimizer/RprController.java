package com.bcg.sibur.apps.ldt.rproptimizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RprController {
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

/*
    @RequestMapping(value = "/run-rpr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String get() {
        return "run rpr";
    }
*/
    @RequestMapping(value = "/run-script", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RprModel script() throws IOException, InterruptedException {
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
        res = new RprModel (batParam, s, errLvl, batRetVal);

        return res;

    }

}