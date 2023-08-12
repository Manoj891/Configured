/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "mark_insert")
public class MarkEntry {

    @EmbeddedId
    protected MarkEntryPK pk;
    @Column(name = "REG_NO", insertable = false, updatable = false)
    private long regNo;

    @Column(name = "GROUP_ID")
    private long groupId;
    @Column(name = "program")
    private long program;
    @Column(name = "class_id")
    private long classId;
    @Column(name = "SUBJECT_CODE", insertable = false, updatable = false)
    private String subCode;
    @Column(name = "TH_OM")
    private float thOm;
    @Column(name = "PR_OM")
    private float prOm;
    @Column(name = "SUB_ID")
    private Long subId;
    @Column(name = "EXAM_REG_ID")
    private Long examRegNo;
    @Column(name = "EXAM_ROLL_NO")
    private String examRollNo;
    @Column(name = "POSTED", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String posted;

    public MarkEntryPK getPk() {
        return pk;
    }

    public void setPk(MarkEntryPK pk) {
        this.pk = pk;
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

    public float getThOm() {
        return thOm;
    }

    public void setThOm(float thOm) {
        this.thOm = thOm;
    }

    public float getPrOm() {
        return prOm;
    }

    public void setPrOm(float prOm) {
        this.prOm = prOm;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public Long getExamRegNo() {
        return examRegNo;
    }

    public void setExamRegNo(Long examRegNo) {
        this.examRegNo = examRegNo;
    }

    public String getExamRollNo() {
        return examRollNo;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setExamRollNo(String examRollNo) {
        this.examRollNo = examRollNo;
    }
}
