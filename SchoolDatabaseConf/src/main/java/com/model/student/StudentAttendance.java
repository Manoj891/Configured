package com.model.student;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_attendance")
public class StudentAttendance implements java.io.Serializable {

    @EmbeddedId
    private StudentAttendancePK pk;
    @Column(name = "STU_ID", insertable = false, updatable = false)
    private Long stuId;
    @Column(name = "ATT_DATE", insertable = false, updatable = false)
    private String attDate;
    @Column(name = "STATUS", columnDefinition = "VARCHAR(1)")
    private String status;
    @Column(name = "IN_TIME", columnDefinition = "TIME")
    private String inTime;
    @Column(name = "OUT_TIME", columnDefinition = "TIME")
    private String outTime;
    @Column(name = "ENTER_BY", columnDefinition = "VARCHAR(100)")
    private String enterBy;
    @Column(name = "ENTER_DATE", columnDefinition = "DATETIME")
    private String enterDate;
    @Column(name = "remark", length = 50)
    private String remark;
    @JoinColumn(name = "STU_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StudentInfo studentInfo;

    public StudentAttendance() {
    }

    public StudentAttendance(String attDate, Long stuId, String status, String inTime, String outTime, String enterBy, String enterDate) {
        pk = new StudentAttendancePK(stuId, attDate);
        this.status = status;
        this.inTime = inTime;
        this.outTime = outTime;
        this.enterBy = enterBy;
        this.enterDate = enterDate;
    }

    public void setPk(StudentAttendancePK pk) {
        this.pk = pk;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getAttDate() {
        return attDate;
    }

    public void setAttDate(String attDate) {
        this.attDate = attDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    @Override
    public String toString() {
        return "\n{\"attDate\": \"" + attDate + "\",\"status\": \"" + status + "\",\"inTime\": \"" + inTime + "\",\"outTime\": \"" + outTime + "\"}";
    }
}
