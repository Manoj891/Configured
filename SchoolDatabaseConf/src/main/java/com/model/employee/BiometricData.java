package com.model.employee;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import model.DateConveter;

@Entity
@Table(name = "biometric_data")
public class BiometricData implements java.io.Serializable {

    @Id
    @Column(name = "PUNCH_ID")
    private Long punchId;
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Column(name = "EMP_ID")
    private Long empId;
    @Column(name = "PUNCH_TIME")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Date punchTime;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "COMPANY_NAME")
    private String companyName;

    public Long getPunchId() {
        return punchId;
    }

    public void setPunchId(Long punchId) {
        this.punchId = punchId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getPunchDate() {
        return DateConveter.adToBs(punchTime);
    }

    public String getPunchTime() {
        return punchTime.toString().replace(".0", "").substring(11, 19);
    }

    public void setPunchTime(Date punchTime) {
        this.punchTime = punchTime;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "\n{\"punchId\": \"" + punchId + "\",\"companyId\": \"" + companyId + "\",\"empId\": \"" + empId + "\",\"punchTime\": \"" + punchTime + "\"}";
    }
}
