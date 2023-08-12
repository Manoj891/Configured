package com.model.employee;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "biometric_attendance")
public class BiometricAttendance implements java.io.Serializable {

    @EmbeddedId
    protected BiometricAttendancePK pk;
    @Column(name = "PUNCH_DATE", columnDefinition = "DATE", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchDate;
    @Column(name = "PUNCH_USER_ID", columnDefinition = "BIGINT", insertable = false, updatable = false)
    private Long punchUserId;
    @Column(name = "COMPANY_ID", columnDefinition = "BIGINT", insertable = false, updatable = false)
    private Long companyId;
    @Column(name = "PUNCH_TIME_IN", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchIimeIn;
    @Column(name = "PUNCH_TIME_OUT", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchIimeOut;
    @Column(name = "PUNCH_MAX_ID", columnDefinition = "BIGINT", insertable = false, updatable = false)
    private Long punchMaxId;
    @Column(name = "STU_EMP_ID", columnDefinition = "BIGINT")
    private Long stuEmpId;

    public BiometricAttendancePK getPk() {
        return pk;
    }

    public void setPk(BiometricAttendancePK pk) {
        this.pk = pk;
    }

    public Date getPunchDate() {
        return punchDate;
    }

    public void setPunchDate(Date punchDate) {
        this.punchDate = punchDate;
    }

    public Long getPunchUserId() {
        return punchUserId;
    }

    public void setPunchUserId(Long punchUserId) {
        this.punchUserId = punchUserId;
    }

    public Long getStuEmpId() {
        return stuEmpId;
    }

    public void setStuEmpId(Long stuEmpId) {
        this.stuEmpId = stuEmpId;
    }

    public Date getPunchIimeIn() {
        return punchIimeIn;
    }

    public void setPunchIimeIn(Date punchIimeIn) {
        this.punchIimeIn = punchIimeIn;
    }

    public Date getPunchIimeOut() {
        return punchIimeOut;
    }

    public void setPunchIimeOut(Date punchIimeOut) {
        this.punchIimeOut = punchIimeOut;
    }

    public Long getPunchMaxId() {
        return punchMaxId;
    }

    public void setPunchMaxId(Long punchMaxId) {
        this.punchMaxId = punchMaxId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

}
