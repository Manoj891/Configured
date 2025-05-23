package com.model.utility;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ad_bs_calender", indexes = {
        @Index(name = "index_ad_bs_calender_bs_date", columnList = "bs_date", unique = true)
})
public class AdBsCalender implements java.io.Serializable {

    @Id
    @Column(name = "ad_date")
    @Temporal(TemporalType.DATE)
    private Date adDate;
    @Column(name = "bs_date", length = 10)
    private String bsDate;
    @Column(name = "day", length = 3)
    private String day;
    @Column(name = "SCHOOL_HOLYDAY", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String schoolHolyday;
    @Column(name = "STUDENT_HOLYDAY", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String studentHolyday;
    @Column(name = "EVENT", columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String event;

    public Date getAdDate() {
        return adDate;
    }

    public void setAdDate(Date adDate) {
        this.adDate = adDate;
    }

    public String getBsDate() {
        return bsDate;
    }

    public void setBsDate(String bsDate) {
        this.bsDate = bsDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSchoolHolyday() {
        return schoolHolyday;
    }

    public void setSchoolHolyday(String schoolHolyday) {
        this.schoolHolyday = schoolHolyday;
    }

    public String getStudentHolyday() {
        return studentHolyday;
    }

    public void setStudentHolyday(String studentHolyday) {
        this.studentHolyday = studentHolyday;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "\n{\"adDate\": \"" + adDate + "\",\"bsDate\": \"" + bsDate + "\",\"day\": \"" + day + "\",\"schoolHolyday\": \"" + schoolHolyday + "\",\"studentHolyday\": \"" + studentHolyday + "\",\"event\": \"" + event + "\"}";
    }
}
