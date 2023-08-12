package com.controller.rest.utility;

import com.config.DateConvert;
import com.config.JWTToken;
import com.model.utility.SMSSending;
import com.repository.utility.SMSSendingRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Utility")
public class SMSReceiveRestController {

    @Autowired
    SMSSendingRepository repository;

    @PostMapping("/SMSReceive")
    public Object doSave(@RequestBody String jsonData, @RequestHeader(value = "Authorization") String Authorization) {
        Message message = new Message();
        JWTToken td = new JWTToken();
        if (!td.smsToken(Authorization)) {
            return message.respondWithError("Invalid Authorization");
        }
        System.out.println("GET API CALL : "+DateConvert.now());
        String schoolCode, schoolName, mobileNo, text, id;
        schoolCode = td.getUserId();
        schoolName = td.getUserName();
        String now = DateConvert.now();
        try {
            SMSSending obj = new SMSSending();
            message.list = new com.fasterxml.jackson.databind.ObjectMapper().readValue(jsonData, new com.fasterxml.jackson.core.type.TypeReference<List>() {
            });
            Map map;
            List list = new ArrayList();
            for (int i = 0; i < message.list.size(); i++) {
                message.map = (Map) message.list.get(i);
                mobileNo = message.map.get("mobileNo").toString();
                text = message.map.get("message").toString();
                id = message.map.get("id").toString();

                obj.setId(repository.findNextId());
                obj.setMessage(text);
                obj.setMobileNo(mobileNo);
                obj.setSchool(schoolCode);
                obj.setSchoolName(schoolName);
                obj.setReceiveDate(now);
                try {
                    repository.save(obj);
                    map = new HashMap();
                    map.put("id", id);
                    map.put("serverId", obj.getId());
                    map.put("status", "Y");
                    list.add(map);
                } catch (Exception e) {
                }
            }
            return list;
        } catch (Exception e) {
            return message.respondWithError(e.getMessage());
        }
    }

    @GetMapping("/SMSSent")
    public Object getSMSSent(@RequestHeader(value = "Authorization") String Authorization, @RequestParam String dateFrom, @RequestParam String dateTo, @RequestParam String mobileNo) {
        Message message = new Message();
        JWTToken td = new JWTToken();
        if (!td.smsToken(Authorization)) {
            return message.respondWithError("Invalid Authorization");
        }
        String schoolCode = td.getUserId();
        if (mobileNo.length() != 10) {
            mobileNo = null;
        }
        return repository.findSent(schoolCode, dateFrom, dateTo, mobileNo);
    }

    @GetMapping("/SMSPending")
    public Object getPendingSMS() {
        List l = repository.findPending();
        return l;
    }

    @GetMapping("/SMSSentUpdate/{id}")
    public Object getPendingSMS(@PathVariable String id) {
        Message msg = new Message();
        try {
            String ss[] = id.split(",");
            System.out.println(ss.length);
            List ids = new ArrayList();
            for (int i = 0; i < ss.length; i++) {
                ids.add(ss[i]);
            }
            System.out.println("UPDATE API CALL : "+DateConvert.now());
            repository.updatePending(ids);
            return msg.respondWithMessage("Success");
        } catch (Exception e) {
            return msg.respondWithError(e.getMessage());
        }

    }
}
