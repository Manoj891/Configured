/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MarkEntryPK implements Serializable {
    @Column(name = "exam")
    private long exam;
    @Column(name = "REG_NO")
    private long regNo;
    @Column(name = "SUBJECT_CODE")
    private String subCode;


    public long getExam() {
        return exam;
    }

    public void setExam(long exam) {
        this.exam = exam;
    }

    public long getRegNo() {
        return regNo;
    }

    public void setRegNo(long regNo) {
        this.regNo = regNo;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkEntryPK)) return false;
        MarkEntryPK that = (MarkEntryPK) o;
        return getExam() == that.getExam() && getRegNo() == that.getRegNo() && Objects.equals(getSubCode(), that.getSubCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExam(), getRegNo(), getSubCode());
    }
}
