package com.root.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;

@RestController
@Slf4j
@RequestMapping
public class MsController {
    @GetMapping("/.well-known/pki-validation/{path}")
    public String get(@PathVariable String path) {
        try {
            FileInputStream in = new FileInputStream("/opt/tomcat/webapps/" + path);
            int a = in.read();
            String data = "";
            while (a >= 0) {
                data = String.valueOf((char) a);
                a = in.read();
            }
            return data;
        } catch (Exception e) {
            return "";
        }
    }

}

