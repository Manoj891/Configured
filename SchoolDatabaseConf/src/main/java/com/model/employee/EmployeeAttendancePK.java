
package com.model.employee;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class EmployeeAttendancePK implements Serializable {

    @Column(name = "emp_id")
    private Long stuId;
    @Column(name = "punch_date")
    @Temporal(TemporalType.DATE)
    private Date punchDate;


}
