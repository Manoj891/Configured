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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class BiometricAttendancePK implements Serializable {

    @Column(name = "PUNCH_DATE", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchDate;
    @Column(name = "PUNCH_USER_ID", columnDefinition = "BIGINT")
    private Long punchUserId;
   @Column(name = "COMPANY_ID", columnDefinition = "BIGINT")
    private Long companyId;

    public BiometricAttendancePK() {
    }

    public BiometricAttendancePK(Date punchDate, Long punchUserId, Long companyId) {
        this.punchDate = punchDate;
        this.punchUserId = punchUserId;
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.punchDate);
        hash = 59 * hash + Objects.hashCode(this.punchUserId);
      
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
        final BiometricAttendancePK other = (BiometricAttendancePK) obj;
      
        if (!Objects.equals(this.punchDate, other.punchDate)) {
            return false;
        }
        if (!Objects.equals(this.punchUserId, other.punchUserId)) {
            return false;
        }
        return true;
    }

}
