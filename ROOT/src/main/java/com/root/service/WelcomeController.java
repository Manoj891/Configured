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

    @GetMapping(".well-known/pki-validation/8C5DFF7D769EAA518F603F29EB7489CB.txt")
    public String ssl() {
        return "D2FD731C634643AD21732DBE31EB786B2C4767048D36050788A993449774FC10\n" +
                "comodoca.com\n" +
                "dcf055353206ca7";
//        https://manage.sslforfree.com/dashboard
//        openssl pkcs12 -export -in certificate.crt -inkey private.key -out dg-trade-ssl-key.p12 -passout pass:1234
    }
}
