
package com.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "daywise_biomatrix")
public class DaywiseBiomatrix {

    @Id
    @Column(name = "id", length = 60)
    private String id;

    @Column(name = "emp_id")
    private long empId;

    @Column(name = "att_date", length = 10)
    private String attDate;

    @Column(name = "in_time", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inTime;

    @Column(name = "out_time", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date outTime;

    @Column(name = "last_update_id")
    private long lastUpdateId;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

}
