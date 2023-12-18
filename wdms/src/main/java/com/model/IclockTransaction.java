
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
@Table(name = "iclock_transaction", indexes = {
        @Index(name = "index_iclock_transaction_synced", columnList = "synced"),
        @Index(name = "index_iclock_transaction_updated", columnList = "updated"),
        @Index(name = "index_iclock_transaction_punch_time", columnList = "punch_time")
})
public class IclockTransaction {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "emp_code")
    private String empCode;
    @Column(name = "punch_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchTime;
    @Column(name = "punch_state")
    private String punchState;
    @Column(name = "verify_type")
    private Integer verifyType;
    @Column(name = "work_code")
    private String workCode;
    @Column(name = "terminal_sn")
    private String terminalSn;
    @Column(name = "terminal_alias")
    private String terminalAlias;
    @Column(name = "area_alias")
    private String areaAlias;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "gps_location")
    private String gpsLocation;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "source")
    private String source;
    @Column(name = "purpose")
    private String purpose;
    @Column(name = "crc")
    private String crc;
    @Column(name = "is_attendance")
    private String isAttendance;
    @Column(name = "reserved")
    private String reserved;
    @Column(name = "upload_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;
    @Column(name = "sync_status")
    private String syncStatus;
    @Column(name = "sync_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncTime;
    @Column(name = "emp_id")
    private String empId;
    @Column(name = "terminal_id")
    private Integer terminalId;
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "mask_flag")
    private Integer maskFlag;
    @Column(name = "temperature")
    private String temperature;
    @Column(name = "synced", columnDefinition = "boolean default false")
    private boolean synced;

    @Column(name = "updated", columnDefinition = "boolean default false")
    private boolean updated;

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"empCode\": \"" + empCode + "\",\"punchTime\": \"" + punchTime + "\",\"punchState\": \"" + punchState + "\",\"verifyType\": \"" + verifyType + "\",\"workCode\": \"" + workCode + "\",\"terminalSn\": \"" + terminalSn + "\",\"terminalAlias\": \"" + terminalAlias + "\",\"areaAlias\": \"" + areaAlias + "\",\"longitude\": \"" + longitude + "\",\"latitude\": \"" + latitude + "\",\"gpsLocation\": \"" + gpsLocation + "\",\"mobile\": \"" + mobile + "\",\"source\": \"" + source + "\",\"purpose\": \"" + purpose + "\",\"crc\": \"" + crc + "\",\"isAttendance\": \"" + isAttendance + "\",\"reserved\": \"" + reserved + "\",\"uploadTime\": \"" + uploadTime + "\",\"syncStatus\": \"" + syncStatus + "\",\"syncTime\": \"" + syncTime + "\",\"empId\": \"" + empId + "\",\"terminalId\": \"" + terminalId + "\",\"companyId\": \"" + companyId + "\",\"maskFlag\": \"" + maskFlag + "\",\"temperature\": \"" + temperature + "\"}";
    }
}
