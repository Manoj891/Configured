/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.rest.utility;

import com.config.JWTToken;
import com.repository.utility.SchoolListRepository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import model.Message;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/Payment/Verification")
public class PaymentVerificationRestController {

    @Autowired
    SchoolListRepository repository;

    @GetMapping
    public Object index(@RequestParam String schoolCode, @RequestParam String regNo, @RequestParam String referenceId, @RequestHeader(value = "Authorization") String Authorization) {

        Message message = new Message();
        JWTToken td = new JWTToken();
        if (!td.paymentTokenDecode(Authorization)) {
            return message.respondWithError("Invalid Authorization");
        }

        String uri = "";
        try {
            uri = repository.findSchoolCode(schoolCode);
            if (uri.length() < 10) {
                return message.respondWithError("Invalid School Code");
            }
        } catch (Exception e) {
            uri = "";
        }

        if (uri.length() < 10) {
            return message.respondWithError("Invalid School Code");
        }
        uri = uri + "/Payment/Billing/PaymentVerification";
        Map map = new HashMap();
        map.put("schoolCode", schoolCode);
        map.put("regNo", regNo);
        map.put("ReferenceID", referenceId);
        map.put("token", "infoweb@onlinepayment" + schoolCode + ".msware9@gmail.com");

        StringBuilder postData = new StringBuilder();
        try {
            postData.append(new ObjectMapper().writeValueAsString(map));
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();
            return response.toString();
        } catch (Exception e) {
            return message.respondWithError("your school server is currently unreachable please try again late");
        }

    }
}
