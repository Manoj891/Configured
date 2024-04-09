package com.root.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


@Service
@Slf4j
public class Scheduling {
    @Scheduled(cron = "00 00 03 * * ?")
    public void morning03() {
        execute();
    }


    public void execute() {
        try {
            for (String s : Objects.requireNonNull(new File("/opt/tomcat/logs/").list())) {
                if (!s.endsWith(".log")) {
                    s = "/opt/tomcat/logs/" + s;
                    log.info("removed " + s + " " + new File(s).delete());
                }
            }
        } catch (Exception ignored) {
        }
        String cmd = "reboot";
        Process p = null;
        try {
            FileInputStream in = new FileInputStream("/opt/tomcat/webapps/reboot.txt");
            StringBuilder data = new StringBuilder();
            int a = 0;
            while (a >= 0) {
                a = in.read();
                data.append((char) a);
            }
            FileOutputStream out = new FileOutputStream("/opt/tomcat/webapps/reboot.txt");
            data.append("\nReboot Time ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            out.write(data.toString().getBytes(StandardCharsets.UTF_8));
            out.close();
            p = new ProcessBuilder().command("bash", "-c", cmd).start();
            String line;
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            do {
                line = r.readLine();
            } while (line != null);
            p.destroy();
        } catch (Exception e) {
            log.info(e.getMessage());
            assert p != null;
            p.destroy();
        }

    }
}
