package com.services.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repository.utility.IclockTransactionRepository;
import com.repository.utility.ServerUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class IclockTransactionServicesImp {

    @Autowired
    private IclockTransactionRepository repository;
    @Autowired
    private ServerUrlRepository urlRepository;

    public void syncData() {
        String serverUrl = urlRepository.findById(1l).orElseThrow(() -> new RuntimeException("Please define server url")).getUrl();
        StringBuilder postData = new StringBuilder();
        try {
            postData.append(new ObjectMapper().writeValueAsString(repository.findSyncData()));
            byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);
            URL url = new URL(serverUrl + "Device/Data/Push");
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
