/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.employee;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MS
 */
@Embeddable
public class MonthlyAllowancePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EMP_ID")
    private long empId;
    @Basic(optional = false)
    @Column(name = "YEAR")
    private Integer year;
    @Basic(optional = false)
    @Column(name = "MONTH")
    private Integer month;
    @Basic(optional = false)
    @Column(name = "ALLOWANCE")
    private long allowance;

    public MonthlyAllowancePK() {
    }

    public MonthlyAllowancePK(long empId, Integer year, Integer month, long allowance) {
        this.empId = empId;
        this.year = year;
        this.month = month;
        this.allowance = allowance;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public long getAllowance() {
        return allowance;
    }

    public void setAllowance(long allowance) {
        this.allowance = allowance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empId;
        hash += (year != null ? year.hashCode() : 0);
        hash += (month != null ? month.hashCode() : 0);
        hash += (int) allowance;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonthlyAllowancePK)) {
            return false;
        }
        MonthlyAllowancePK other = (MonthlyAllowancePK) object;
        if (this.empId != other.empId) {
            return false;
        }
        if ((this.year == null && other.year != null) || (this.year != null && !this.year.equals(other.year))) {
            return false;
        }
        if ((this.month == null && other.month != null) || (this.month != null && !this.month.equals(other.month))) {
            return false;
        }
        if (this.allowance != other.allowance) {
            return false;
        }
        return true;
    }

   
    
}
