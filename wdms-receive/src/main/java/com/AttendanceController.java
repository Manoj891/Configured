package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping
public class AttendanceController {
    @Autowired
    private AttendanceRepository repository;
    private final SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @GetMapping
    public String status() {
        return "{\"status\":\"active\"}";
    }

    @PostMapping
    public ResponseEntity<List<Long>> receiveData(@RequestParam int branch, @RequestBody List<AttendanceReq> req) {
        List<Long> res = new ArrayList<>();
        req.forEach(r -> {
            try {
                log.info(r.toString());
                repository.save(Attendance.builder().punchTime(d.parse(r.getPunchTime())).empId(r.getEmpId()).empCode(r.getEmpCode()).pk(AttendancePk.builder().branch(branch).id(r.getId()).build()).build());
                res.add(r.getId());
                log.info("Saved " + r.getId() + "-" + branch);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
