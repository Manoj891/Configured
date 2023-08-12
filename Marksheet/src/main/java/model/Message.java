package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

public class Message {

    public Map map;

    public String exceptionMsg(DataIntegrityViolationException e) {
        try {
            String msg = e.getRootCause().getMessage();
            return msg;
        } catch (Exception ex) {
        }
        return e.getMessage();
    }

    public ResponseEntity respondWithError(String message) {
        map = new HashMap();
        map.put("timestamp", new Date());
        map.put("message", message);
        map.put("error", "server response");
        return ResponseEntity.status(400).body(map);
    }

    public ResponseEntity respondWithMessage(String message) {
        map = new HashMap();
        map.put("message", message);
        return ResponseEntity.status(200).body(map);
    }

    public ResponseEntity respondWithMessage(String message, Object data) {
        map = new HashMap();
        map.put("message", message);
        map.put("data", data);
        return ResponseEntity.status(200).body(map);
    }
}