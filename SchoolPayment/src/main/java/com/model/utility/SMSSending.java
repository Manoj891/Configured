package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_sending")
public class SMSSending {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SCHOOL")
    private String school;
    @Column(name = "SCHOOL_NAME")
    private String schoolName;
    @Column(name = "MOBILE_NO", columnDefinition = "VARCHAR(10)")
    private String mobileNo;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "RECEIVE_DATE", columnDefinition = "DATETIME", updatable = false)
    private String receiveDate;
    @Column(name = "SENT_DATE", columnDefinition = "DATETIME", updatable = false)
    private String sendDate;
    @Column(name = "STATUS", columnDefinition = "VARCHAR(1)")
    private String status;

    public SMSSending() {
    }

    public SMSSending(Long id) {
        this.id = id;
    }

    public SMSSending(String id) {
        this.id = Long.parseLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "\n{\"id\":\"" + id + "\",\"school\":\"" + school + "\",\"schoolName\":\"" + schoolName + "\",\"mobileNo\":\"" + mobileNo + "\",\"message\":\"" + message + "\",\"receiveDate\":\"" + receiveDate + "\",\"sendDate\":\"" + sendDate + "\",\"status\":\"" + status + "\"}";
    }

}
