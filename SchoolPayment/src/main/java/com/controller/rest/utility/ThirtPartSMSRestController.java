/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.rest.utility;

import com.config.JWTToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Map;
import model.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Utility/ThirtPartSMS")
public class ThirtPartSMSRestController {

    @PostMapping
    public Object doSave(@RequestBody List<Map> list, @RequestHeader(value = "Authorization") String Authorization) throws JsonProcessingException {
        Message message = new Message();
        JWTToken td = new JWTToken();
        if (!td.thirdPartysmsToken(Authorization)) {
            return message.respondWithError("Invalid Authorization");
        }
        String smsAPI = "http://api.sparrowsms.com/v2/sms/";
        Map map;
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            map.put("token", "v2_tFlmL0d7pcfNEz02QcjUaqUs9MP.fmD5 (infowebnepal@gmail.com)");
            map.put("from", "Demo");
            System.out.println(message.callAPI(map, smsAPI));

        }
//        return message.list;
        return list;
    }

    public static void main(String[] args) {
        JWTToken t = new JWTToken();
        System.out.println(t.thirdPartysmsToken("1", "Test"));
    }
}
