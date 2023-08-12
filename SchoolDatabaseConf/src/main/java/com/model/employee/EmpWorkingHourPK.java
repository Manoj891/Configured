/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.employee;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpWorkingHourPK implements Serializable {

@Column(name = "EMP_ID")
private Long empId;
@Column(name = "WORKING_DAY", columnDefinition = "VARCHAR(3)")
private String workingDay;

    public EmpWorkingHourPK(Long empId, String workingDay) {
        this.empId = empId;
        this.workingDay = workingDay;
    }

    public EmpWorkingHourPK() {
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(String workingDay) {
        this.workingDay = workingDay;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.empId);
        hash = 29 * hash + Objects.hashCode(this.workingDay);
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
        final EmpWorkingHourPK other = (EmpWorkingHourPK) obj;
        if (!Objects.equals(this.workingDay, other.workingDay)) {
            return false;
        }
        if (!Objects.equals(this.empId, other.empId)) {
            return false;
        }
        return true;
    }

}
