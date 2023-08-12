package com.model.student;

import com.model.setup.BillMaster;
import com.model.setup.BusStationMaster;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import model.DateConveter;

@Entity
@Table(name = "student_transportation", uniqueConstraints = @UniqueConstraint(columnNames = {"REG_NO", "STATUS"}))
public class StudentTransportation implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "REG_NO", nullable = false)
    private Long regNo;
    @Column(name = "BILL_ID", updatable = false, nullable = false)
    private Long billId;
    @Column(name = "STATION", nullable = false)
    private Long station;
    @Column(name = "STATUS", nullable = true)
    private String status;
    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate;
    @Column(name = "END_DATE", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date endDate;
    @Column(name = "MONTHLY_CHARGE")
    private Float monthlyCharge;
    @JoinColumn(name = "REG_NO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private StudentInfo studentInfo;

    @JoinColumn(name = "BILL_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BillMaster BillMaster;
    @JoinColumn(name = "STATION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BusStationMaster busStationMaster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegNo() {
        return regNo;
    }

    public void setRegNo(Long regNo) {
        this.regNo = regNo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public String getStatus() {
        return status;
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

    public Float getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(Float monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getStation() {
        return station;
    }

    public void setStation(Long station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"regNo\": \"" + regNo + "\",\"monthlyCharge\": \"" + monthlyCharge + "\",\"status\": \"" + status + "\",\"startDate\": \"" + startDate + "\",\"endDate\": \"" + endDate + "\"}";
    }
}
