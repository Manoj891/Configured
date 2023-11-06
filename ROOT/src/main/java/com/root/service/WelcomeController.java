package com.root.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {
    @GetMapping()
    public String get() {
        return "Welcome DIT Solution";
    }

    @GetMapping(".well-known/pki-validation/F8F862EC218B1C8E3EDFDB4D2584A935.txt")
    public String ssl() {
        return "29D6EA42696D5168C4819BE7943621C62964D1FB3B8831D727ABDAA92AB80454\n" +
                "comodoca.com\n" +
                "ff0fcbb5051a6ac";
    }
}
