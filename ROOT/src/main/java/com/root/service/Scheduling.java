package com.root.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Slf4j
public class Scheduling {
    @Scheduled(cron = "00 00 03 * * ?")
    public void morning03() {
        execute();
    }

    @Scheduled(cron = "00 00 16 * * ?")
    public void afternoon16() {
        execute();
    }

    public void execute() {
        String cmd = "reboot";
        Process p = null;
        try {
            FileInputStream in = new FileInputStream("D:/opt/tomcat/webapps/reboot.txt");
            StringBuilder data = new StringBuilder();
            int a = 0;
            while (a >= 0) {
                a = in.read();
                data.append((char) a);
            }
            FileOutputStream out = new FileOutputStream("D:/opt/tomcat/webapps/reboot.txt");
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
