package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/data-receive")
public class AttendanceController {
    @Autowired
    private AttendanceRepository repository;
    private final SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @PostMapping
    public ResponseEntity<List<Long>> paymentGenerate(@RequestBody List<AttendanceReq> req) {
        List<Long> res = new ArrayList<>();
        req.forEach(r -> {
            try {
                repository.save(Attendance.builder().punchTime(d.parse(r.getPunchTime())).empId(r.getEmpId()).empCode(r.getEmpCode())
                        .pk(AttendancePk.builder().branch(r.getBranch()).id(r.getId()).build()).build());
                res.add(r.getId());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
