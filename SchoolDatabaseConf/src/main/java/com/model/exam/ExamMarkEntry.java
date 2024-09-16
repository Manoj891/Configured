/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.exam;


import com.model.setup.SubjectMaster;
import com.model.student.StudentInfo;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "exam_mark_entry", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"STUDENT_REG_NO", "EXAM", "SUBJECT"})
})
public class ExamMarkEntry {

    @EmbeddedId
    protected ExamMarkEntryPK pk;
    @Column(name = "EXAM_ROLL_NO", nullable = false)
    private String examRollNo;
    @Column(name = "STUDENT_REG_NO", nullable = false)
    private long studentRegNo;
    @Column(name = "EXAM", nullable = false)
    private long exam;
    @Column(name = "TH_OM", columnDefinition = "float(5,3) default 0")
    private Float thOm;
    @Column(name = "PR_OM", columnDefinition = "float(5,3)  default 0")
    private Float prOm;
    @Column(name = "extra_activity", columnDefinition = "varchar(1) default ''")
    private String extraActivity;

    @Column(name = "t1t", columnDefinition = "float default 0")
    private Float t1t;
    @Column(name = "t2t", columnDefinition = "float default 0")
    private Float t2t;
    @Column(name = "t3t", columnDefinition = "float default 0")
    private Float t3t;
    @Column(name = "t1p", columnDefinition = "float default 0")
    private Float t1p;
    @Column(name = "t2p", columnDefinition = "float default 0")
    private Float t2p;
    @Column(name = "t3p", columnDefinition = "float default 0")
    private Float t3p;

    @Column(name = "ENTER_BY", nullable = false)
    private String enterBy;
    @Column(name = "APPROVE_BY")
    private String approveBy;
    @Column(name = "ENTER_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date enterDate;
    @Column(name = "APPROVE_DATE")
    @Temporal(TemporalType.DATE)
    private Date approveDate;

    @JoinColumn(name = "STUDENT_REG_NO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StudentInfo studentInfo;
    @JoinColumn(name = "EXAM_REG_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ExamStudentRegistration examStudentRegistration;
    @JoinColumn(name = "SUBJECT", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubjectMaster subjectMaster;
    @JoinColumn(name = "EXAM", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ExamMaster examMaster;

    public ExamMarkEntry() {
    }

    public ExamMarkEntry(long examRegId, long subject, long exam, String examRollNo, long studentRegNo, Float thOm, Float prOm, String enterBy, Date enterDate) {
        pk = new ExamMarkEntryPK(examRegId, subject);
        this.examRollNo = examRollNo;
        this.studentRegNo = studentRegNo;
        this.thOm = thOm;
        this.prOm = prOm;
        this.enterBy = enterBy;
        this.enterDate = enterDate;
        this.exam = exam;
    }

    public ExamMarkEntryPK getPk() {
        return pk;
    }

    public void setPk(ExamMarkEntryPK pk) {
        this.pk = pk;
    }

    public String getExamRollNo() {
        return examRollNo;
    }

    public void setExamRollNo(String examRollNo) {
        this.examRollNo = examRollNo;
    }

    public long getStudentRegNo() {
        return studentRegNo;
    }

    public void setStudentRegNo(long studentRegNo) {
        this.studentRegNo = studentRegNo;
    }

    public Float getThOm() {
        return thOm;
    }

    public void setThOm(Float thOm) {
        this.thOm = thOm;
    }

    public Float getPrOm() {
        return prOm;
    }

    public void setPrOm(Float prOm) {
        this.prOm = prOm;
    }

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public String getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(String approveBy) {
        this.approveBy = approveBy;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public long getExam() {
        return exam;
    }

    public void setExam(long exam) {
        this.exam = exam;
    }

}
