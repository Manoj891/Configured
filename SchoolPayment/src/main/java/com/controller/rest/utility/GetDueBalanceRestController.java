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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/Utility/DueBalance")
public class GetDueBalanceRestController {

    @Autowired
    SchoolListRepository repository;

    @GetMapping
    public Object index(@RequestParam String schoolCode, @RequestParam String regNo, @RequestParam String year, @RequestParam String month, @RequestHeader(value = "Authorization") String Authorization) {
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
        uri = uri + "/Payment/Billing/Due";
//            uri = "http://localhost:8084/SchoolKing/Payment/Billing/Due";
        System.out.println(uri);
        Map map = new HashMap();
        map.put("schoolCode", schoolCode);
        map.put("regNo", regNo);
        map.put("year", year);
        map.put("month", month);
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
            System.out.println(e);
            return message.respondWithError("your school server is currently unreachable please try again late");
        }

    }

    @PostMapping
    public Object doPayment(@RequestBody String jsonData, @RequestHeader(value = "Authorization") String Authorization) {
        Message message = new Message();
        String schoolCode = "", regNo = "", year, month, referenceId;
        float payAmount = 0;

        JWTToken td = new JWTToken();
        if (!td.paymentTokenDecode(Authorization)) {
            return message.respondWithError("Invalid Authorization");
        }
        Map map;
        try {
            map = new org.codehaus.jackson.map.ObjectMapper().readValue(jsonData, new org.codehaus.jackson.type.TypeReference<Map<String, String>>() {
            });
            schoolCode = map.get("schoolCode").toString();
            regNo = map.get("regNo").toString();
            year = map.get("year").toString();
            month = map.get("month").toString();
            try {
                referenceId = map.get("referenceId").toString();
            } catch (Exception e) {
               return message.respondWithError("Please provide referenceId!!");
            }
            try {
                payAmount = Float.parseFloat("0" + map.get("payAmount").toString());
                if (payAmount < 10) {
                    return message.respondWithError("Amount less than 10 not accept");
                }
            } catch (Exception e) {
                return message.respondWithError("Amount less than 10 not accept");
            }
        } catch (Exception e) {
            return message.respondWithError("Missing parameter!!");
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
        uri = uri + "/Payment/Billing/Payment";
        map = new HashMap();
        map.put("schoolCode", schoolCode);
        map.put("regNo", regNo);
        map.put("payAmount", payAmount);
        map.put("month", month);
        map.put("year", year);
        map.put("referenceId", referenceId);
        map.put("token", "infoweb@onlinepayment" + schoolCode + ".msware9@gmail.com");
        map.put("paymentFromId", td.getUserId());
        map.put("paymentFromName", td.getUserName());
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
            return message.respondWithError("your school server is currently unreachable please try again later");
        }

    }
}
