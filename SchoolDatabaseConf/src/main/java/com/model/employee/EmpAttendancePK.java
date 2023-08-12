/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.employee;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import model.DateConveter;

@Embeddable
public class EmpAttendancePK implements Serializable {

    @Column(name = "TEACHER")
    private Long teacher;
    @Column(name = "ATT_DATE",columnDefinition = "DATE")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date attDate;

    public EmpAttendancePK(Long teacher, Date attDate) {
        this.teacher = teacher;
        this.attDate = attDate;
    }

    public EmpAttendancePK(Long teacher, String attDate) {
        this.teacher = teacher;
        this.attDate = DateConveter.bsToAdDate(attDate);
    }

    public Long getTeacher() {
        return teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }

    public Date getAttDate() {
        return attDate;
    }

    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.teacher);
        hash = 37 * hash + Objects.hashCode(this.attDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpAttendancePK other = (EmpAttendancePK) obj;
        if (!Objects.equals(this.teacher, other.teacher)) {
            return false;
        }
        if (!Objects.equals(this.attDate, other.attDate)) {
            return false;
        }
        return true;
    }

}
