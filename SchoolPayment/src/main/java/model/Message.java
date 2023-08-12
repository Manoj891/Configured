package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.dao.DataIntegrityViolationException;

public class Message {

    public Map map;
    public List list;

    public static String exceptionMsg(Exception e) {
        try {
            return e.getCause().getMessage();
        } catch (Exception ex) {
        }
        return e.getMessage();
    }

    public String exceptionMsg(DataIntegrityViolationException e) {
        try {
            String msg = e.getRootCause().getMessage();
            return msg;
        } catch (Exception ex) {
        }
        return e.getMessage();
    }

    public Object respondWithError(String message) {
        Map map = new HashMap();
        map.put("timestamp", new Date());
        map.put("message", message);
        map.put("error", "server response");
        map.put("status", 400);
        return map;
    }

    public String respondWithMessage(String message) {
        return "{\"message\":\"" + message + "\"}";
    }

    public Object callAPI(Map map, String uri) {
        StringBuilder postData = new StringBuilder();
        try {
            postData.append(new ObjectMapper().writeValueAsString(map));
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
//            conn.setDoOutput(true);
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
            return respondWithError("your school server is currently unreachable please try again late");
        }
    }
}
