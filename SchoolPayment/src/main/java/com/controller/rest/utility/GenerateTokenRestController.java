/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.rest.utility;

import com.config.EmailService;
import com.config.JWTToken;
import model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Utility/GenerateToken")
public class GenerateTokenRestController {

    @PostMapping
    public Object getToken(@RequestHeader(value = "Authorization") String Authorization) {

        Message message = new Message();
        JWTToken td = new JWTToken(Authorization);
        if (!td.isStatus()) {
            return message.respondWithError("invalid token");
        }

        String userId = td.getUserId();
        String userName = td.getUserName();
        String userType = td.getUserType();
        try {
            String token = td.getPaymentToken(userId, userName, userType);
            EmailService es = new EmailService();
            String status = es.sendmail(userType, "Token Generated from info web nepal", "Your Payment api token is Bearer " + token);

            if (status.equalsIgnoreCase("Sent")) {
                return message.respondWithError(" Token sent in your register email!!");
            } else {
                return message.respondWithError(status);
            }
        } catch (Exception e) {
            return message.respondWithError(e.getMessage());
        }
    }
}
