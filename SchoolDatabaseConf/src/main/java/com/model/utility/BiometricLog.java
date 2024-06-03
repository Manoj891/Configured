package com.model.utility;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "biometric_log", indexes = {
        @Index(name = "index_biometric_log_user_id", columnList = "user_id"),
        @Index(name = "index_biometric_log_punch_date", columnList = "punch_date"),
        @Index(name = "index_biometric_log_status", columnList = "status")
})
public class BiometricLog {
    @Id
    @Column(name = "id", length = 50)
    private String id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "branch")
    private int branch;
    @Column(name = "punch_date", columnDefinition = "date")
    private String punchDate;
    @Column(name = "punch_time", columnDefinition = "time")
    private String punchTime;
    @Column(name = "status", columnDefinition = "bit default 0")
    private boolean status;
}
