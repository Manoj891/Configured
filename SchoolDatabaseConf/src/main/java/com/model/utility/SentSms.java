
package com.model.utility;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sent_sms")
public class SentSms {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "sms", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String sms;
    @Column(name = "send_by", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String sendBy;
    @Column(name = "send_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date sendDate;
    @Column(name = "status", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String status;
    @Column(name = "rate")
    private Float rate;
    @Column(name = "sms_count", columnDefinition = "INT DEFAULT 1")
    private int smsCount;
    @Column(name = "amount")
    private Float amount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public String getSendDateTime() {
        return sendDate.toString();
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }


    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"mobile\": \"" + mobile + "\",\"sms\": \"" + sms + "\",\"sendBy\": \"" + sendBy + "\",\"sendDate\": \"" + sendDate + "\",\"status\": \"" + status + "\"}";
    }
}
