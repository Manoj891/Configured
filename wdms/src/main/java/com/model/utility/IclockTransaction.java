/*
@JoinColumn(name = "COLUMN_NAME", referencedColumnName = "ID")
 @ManyToOne(optional = false)
 private ModelName columnName;
SELECT id,emp_code,punch_time,punch_state,verify_type,work_code,terminal_sn,terminal_alias,area_alias,longitude,latitude,gps_location,mobile,source,purpose,crc,is_attendance,reserved,upload_time,sync_status,sync_time,emp_id,terminal_id,company_id,mask_flag,temperature FROM  iclock_transaction;
SELECT id AS id,emp_code AS empCode,punch_time AS punchTime,punch_state AS punchState,verify_type AS verifyType,work_code AS workCode,terminal_sn AS terminalSn,terminal_alias AS terminalAlias,area_alias AS areaAlias,longitude AS longitude,latitude AS latitude,gps_location AS gpsLocation,mobile AS mobile,source AS source,purpose AS purpose,crc AS crc,is_attendance AS isAttendance,reserved AS reserved,upload_time AS uploadTime,sync_status AS syncStatus,sync_time AS syncTime,emp_id AS empId,terminal_id AS terminalId,company_id AS companyId,mask_flag AS maskFlag,temperature AS temperature FROM  iclock_transaction;

 String colHead[]={"id","empCode","punchTime","punchState","verifyType","workCode","terminalSn","terminalAlias","areaAlias","longitude","latitude","gpsLocation","mobile","source","purpose","crc","isAttendance","reserved","uploadTime","syncStatus","syncTime","empId","terminalId","companyId","maskFlag","temperature"};
 */
package com.model.utility;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "iclock_transaction", indexes = {
        @Index(name = "index_iclock_transaction_synced", columnList = "synced"),
        @Index(name = "index_iclock_transaction_punch_time", columnList = "punch_time")
})
public class IclockTransaction {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "emp_code")
    private String empCode;
    @Column(name = "punch_time")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date punchTime;
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
    String gpsLocation;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "source")
    String source;
    @Column(name = "purpose")
    String purpose;
    @Column(name = "crc")
    private String crc;
    @Column(name = "is_attendance")
    String isAttendance;
    @Column(name = "reserved")
    private String reserved;
    @Column(name = "upload_time")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date uploadTime;
    @Column(name = "sync_status")
    private String syncStatus;
    @Column(name = "sync_time")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date syncTime;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Date getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(Date punchTime) {
        this.punchTime = punchTime;
    }

    public String getPunchState() {
        return punchState;
    }

    public void setPunchState(String punchState) {
        this.punchState = punchState;
    }

    public Integer getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(Integer verifyType) {
        this.verifyType = verifyType;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getTerminalSn() {
        return terminalSn;
    }

    public void setTerminalSn(String terminalSn) {
        this.terminalSn = terminalSn;
    }

    public String getTerminalAlias() {
        return terminalAlias;
    }

    public void setTerminalAlias(String terminalAlias) {
        this.terminalAlias = terminalAlias;
    }

    public String getAreaAlias() {
        return areaAlias;
    }

    public void setAreaAlias(String areaAlias) {
        this.areaAlias = areaAlias;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getIsAttendance() {
        return isAttendance;
    }

    public void setIsAttendance(String isAttendance) {
        this.isAttendance = isAttendance;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Integer getMaskFlag() {
        return maskFlag;
    }

    public void setMaskFlag(Integer maskFlag) {
        this.maskFlag = maskFlag;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"empCode\": \"" + empCode + "\",\"punchTime\": \"" + punchTime + "\",\"punchState\": \"" + punchState + "\",\"verifyType\": \"" + verifyType + "\",\"workCode\": \"" + workCode + "\",\"terminalSn\": \"" + terminalSn + "\",\"terminalAlias\": \"" + terminalAlias + "\",\"areaAlias\": \"" + areaAlias + "\",\"longitude\": \"" + longitude + "\",\"latitude\": \"" + latitude + "\",\"gpsLocation\": \"" + gpsLocation + "\",\"mobile\": \"" + mobile + "\",\"source\": \"" + source + "\",\"purpose\": \"" + purpose + "\",\"crc\": \"" + crc + "\",\"isAttendance\": \"" + isAttendance + "\",\"reserved\": \"" + reserved + "\",\"uploadTime\": \"" + uploadTime + "\",\"syncStatus\": \"" + syncStatus + "\",\"syncTime\": \"" + syncTime + "\",\"empId\": \"" + empId + "\",\"terminalId\": \"" + terminalId + "\",\"companyId\": \"" + companyId + "\",\"maskFlag\": \"" + maskFlag + "\",\"temperature\": \"" + temperature + "\"}";
    }
}
