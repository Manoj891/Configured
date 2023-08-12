/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.employee;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import model.DateConveter;

@Entity
@Table(name = "emp_attendance")
public class EmpAttendance implements java.io.Serializable {

    @EmbeddedId
    private EmpAttendancePK pk;
    @Column(name = "IN_TIME", columnDefinition = "TIME")
    private String inTime;
    @Column(name = "OUT_TIME", columnDefinition = "TIME")
    private String outTime;
    @Column(name = "EMP_START_TIME", columnDefinition = "TIME")
    private String empStartTime;
    @Column(name = "EMP_END_TIME", columnDefinition = "TIME")
    private String empEndTime;
    @Column(name = "LATE_MINUTE")
    private Integer lateMinute;
    @Column(name = "OT_MINUTE")
    private Integer otMinute;
    @Column(name = "ATT_DATE", insertable = false, updatable = false)
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date attDate;
    @JoinColumn(name = "TEACHER", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private EmployeeInfo teacher;

    public EmpAttendancePK getPk() {
        return pk;
    }

    public void setPk(EmpAttendancePK pk) {
        this.pk = pk;
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

    public String getEmpStartTime() {
        return empStartTime;
    }

    public void setEmpStartTime(String empStartTime) {
        this.empStartTime = empStartTime;
    }

    public String getEmpEndTime() {
        return empEndTime;
    }

    public void setEmpEndTime(String empEndTime) {
        this.empEndTime = empEndTime;
    }

    public Integer getLateMinute() {
        return lateMinute;
    }

    public void setLateMinute(Integer lateMinute) {
        this.lateMinute = lateMinute;
    }

    public Integer getOtMinute() {
        return otMinute;
    }

    public void setOtMinute(Integer otMinute) {
        this.otMinute = otMinute;
    }

    public java.util.Date getAttDateAd() {
        return attDate;
    }

    public String getAttDate() {
        return DateConveter.adToBs(attDate);
    }

    public void setAttDate(String attDate) {
        this.attDate = DateConveter.bsToAdDate(attDate);
    }

    public EmployeeInfo getTeacher() {
        return teacher;
    }

    public void setTeacher(EmployeeInfo teacher) {
        this.teacher = teacher;
    }

}
