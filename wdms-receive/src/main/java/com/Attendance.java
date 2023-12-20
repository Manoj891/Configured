package com;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendance")
public class Attendance {
    @EmbeddedId
    protected AttendancePk pk;
    @Column(name = "emp_code", length = 15)
    private String empCode;
    @Column(name = "punchTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchTime;
    @Column(name = "emp_id")
    private Long empId;

    @Override
    public String toString() {
        return "{\"id\":\"" + pk.getId() + "\",\"empCode\":\"" + empCode + "\",\"branch\":\"" + pk.getBranch() + "\",\"punchTime\":\"" + punchTime + "\",\"empId\":\"" + empId + "\"}";
    }
}
