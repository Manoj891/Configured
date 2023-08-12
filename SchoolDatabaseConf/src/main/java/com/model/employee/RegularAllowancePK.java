/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.employee;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author MS
 */
@Embeddable
public class RegularAllowancePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EMP_ID")
    private long empId;
    @Basic(optional = false)
    @Column(name = "ALLOWANCE")
    private long allowance;

    public RegularAllowancePK() {
    }

    public RegularAllowancePK(long empId, long allowance) {
        this.empId = empId;
        this.allowance = allowance;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getAllowance() {
        return allowance;
    }

    public void setAllowance(long allowance) {
        this.allowance = allowance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegularAllowancePK that = (RegularAllowancePK) o;
        return empId == that.empId && allowance == that.allowance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, allowance);
    }
}
