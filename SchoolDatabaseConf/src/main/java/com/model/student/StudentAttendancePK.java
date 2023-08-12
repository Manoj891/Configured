/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.student;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import model.DateConveter;

@Embeddable
public class StudentAttendancePK implements Serializable {

    @Column(name = "STU_ID")
    private Long stuId;
    @Column(name = "ATT_DATE")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date attDate;

    public StudentAttendancePK() {
    }

    public StudentAttendancePK(Long stuId, Date attDate) {
        this.stuId = stuId;
        this.attDate = attDate;
    }

    public StudentAttendancePK(Long stuId, String attDate) {
        this.stuId = stuId;
        this.attDate = DateConveter.toDate(attDate);
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Date getAttDate() {
        return attDate;
    }

    public String getDate() {
        return DateConveter.toString(attDate);
    }

    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

}
