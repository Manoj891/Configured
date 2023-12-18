package com.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.DaywiseBiomatrix;
import com.model.PushData;
import com.repository.DaywiseBiomatrixRepository;
import com.repository.IclockTransactionRepository;
import com.repository.ServerUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class IclockTransactionServicesImp {

    @Autowired
    private IclockTransactionRepository repository;
    @Autowired
    private ServerUrlRepository urlRepository;
    @Autowired
    private DaywiseBiomatrixRepository biomatrixRepository;
    private String serverUrl = "http://localhost:8084/Device/Data/Push";


    @PostConstruct
    public void init() {
        urlRepository.findById(1L).ifPresent(s -> serverUrl = s.getUrl());
        pussStart();
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void pussStart() {
        if (serverUrl == null) {
            serverUrl = urlRepository.findById(1L).orElseThrow(() -> new RuntimeException("Please define server url")).getUrl();
        }
        syncData();
    }

    private Date add15Min(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 15);
        return cal.getTime();
    }

    public void syncData() {
        System.out.println(serverUrl);

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            List<PushData> data = new ArrayList<>();
            repository.findByUpdatedFalse().forEach(i -> {
                String dd = date.format(i.getPunchTime());
                long empId = Long.parseLong(i.getEmpId());
                String id = dd + "-" + empId;
                if (biomatrixRepository.countByEmpIdAndAttDate(empId, dd) == 0) {
                    biomatrixRepository.save(DaywiseBiomatrix.builder().id(id).attDate(dd).inTime(i.getPunchTime()).outTime(null).lastUpdateId(i.getId()).updateAt(new Date()).build());
                } else {
                    biomatrixRepository.save(DaywiseBiomatrix.builder().id(id).attDate(dd).outTime(i.getPunchTime()).lastUpdateId(i.getId()).updateAt(new Date()).build());
                }

            });
            repository.findBySyncedIsFalse(PageRequest.of(0, 100, Sort.by("id").ascending())).forEach(d -> data.add(PushData.builder().id(d.getId()).empCode(d.getEmpCode()).empId(d.getEmpId()).punchTime(dateFormat.format(add15Min(d.getPunchTime()))).build()));
            if (data.isEmpty()) return;
            String dd = new ObjectMapper().writeValueAsString(data);
            System.out.println(dd);
            byte[] postDataBytes = dd.getBytes(StandardCharsets.UTF_8);
            URL url = new URL(serverUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();
            List<Long> list = new com.fasterxml.jackson.databind.ObjectMapper().readValue(response.toString(), new com.fasterxml.jackson.core.type.TypeReference<List<Long>>() {
            });
            repository.updateSyncData(list);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

    }

}
