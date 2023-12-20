package com;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AttendanceReq {
    private long id;
    private String empCode;
    private String punchTime;
    private long empId;

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"empCode\":\"" + empCode + "\",\"punchTime\":\"" + punchTime + "\",\"empId\":\"" + empId + "\"}";
    }
}
