package com.model.student;

import com.model.setup.BillMaster;
import com.model.setup.HostalTypeMaster;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.DateConveter;

@Entity
@Table(name = "school_hostal")
public class SchoolHostal implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private java.util.Date endDate;
    @Column(name = "MONTHLY_CHARGE")
    private Float monthlyCharge;
    @Column(name = "REG_NO")
    private Long regNo;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "BILL_ID", updatable = false)
    private Long billId = (-2l);
    @Column(name = "HOSTEL_TYPE")
    private Long hostelType;
    @JoinColumn(name = "REG_NO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private StudentInfo studentInfo;

    @JoinColumn(name = "BILL_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BillMaster BillMaster;

    @JoinColumn(name = "HOSTEL_TYPE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HostalTypeMaster hostalTypeMaster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(Float monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public Long getRegNo() {
        return regNo;
    }

    public void setRegNo(Long regNo) {
        this.regNo = regNo;
    }

    public String getStartDate() {
        return DateConveter.adToBs(startDate);
    }

    public void setStartDate(String startDate) {
        this.startDate = DateConveter.bsToAdDate(startDate);
    }

    public String getEndDate() {
        try {
            if (endDate != null) {
                return DateConveter.adToBs(endDate);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public void setEndDate(String endDate) {
        try {
            if (endDate.length() == 10) {
                this.endDate = DateConveter.bsToAdDate(endDate);
                status = "N";
                return;
            }
        } catch (Exception e) {
        }
        status = "Y";
        this.endDate = null;
    }

    public String getStatus() {
        return status;
    }

    public Long getBillId() {
        return (-2l);
    }

    public void setBillId(Long billId) {
        this.billId = (-2l);
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Long getHostelType() {
        return hostelType;
    }

    public void setHostelType(Long hostelType) {
        this.hostelType = hostelType;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"endDate\": \"" + endDate + "\",\"monthlyCharge\": \"" + monthlyCharge + "\",\"regNo\": \"" + regNo + "\",\"startDate\": \"" + startDate + "\",\"status\": \"" + status + "\",\"billId\": \"" + billId + "\"}";
    }
}
