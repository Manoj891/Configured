package com.model.utility;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grade_shett_detail")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class GradeShettDetail {

    @EmbeddedId
    protected GradeSheetDetailPk pk;
    @Column(name = "SUBJECT_ID", insertable = false, updatable = false)
    private Long subjectId;
    @Column(name = "SUBJECT_CODE", nullable = false)
    private String subjectCode;
    @Column(name = "SUBJECT_NAME", nullable = false)
    private String subjectName;
    @Column(name = "CREDIT_HOUR", nullable = false)
    private Double creditHour;
    @Column(name = "grade_point")
    private String geadePoint;
    @Column(name = "th_obtain", nullable = false)
    private double thObtain;
    @Column(name = "pr_obtain", nullable = false)
    private double prObtain;
    @Column(name = "grade_th")
    private String geadeTh;
    @Column(name = "grade_pr")
    private String geadePr;
    @Column(name = "final_grade")
    private String finalGrade;
    @Column(name = "remark")
    private String remark;
    @JoinColumn(name = "MASTER_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GradeShett gradeShett;

    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubjectMaster subjectMaster;
    @Column(name = "SUBJECT_CODE", insertable = false, updatable = false)
    private int subjectCodeInt;

    public GradeSheetDetailPk getPk() {
        return pk;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setPk(GradeSheetDetailPk pk) {
        this.pk = pk;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(Double creditHour) {
        this.creditHour = creditHour;
    }

    public String getGeadePoint() {
        return geadePoint;
    }

    public void setGeadePoint(String geadePoint) {
        this.geadePoint = geadePoint;
    }

    public String getGeadeTh() {
        return geadeTh;
    }

    public void setGeadeTh(String geadeTh) {
        this.geadeTh = geadeTh;
    }

    public String getGeadePr() {
        return geadePr;
    }

    public void setGeadePr(String geadePr) {
        this.geadePr = geadePr;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getThObtain() {
        return thObtain;
    }

    public void setThObtain(double thObtain) {
        this.thObtain = thObtain;
    }

    public double getPrObtain() {
        return prObtain;
    }

    public void setPrObtain(double prObtain) {
        this.prObtain = prObtain;
    }

    public int getSubjectCodeInt() {
        try {
            return Integer.parseInt(subjectCode);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "\n{PK=" + pk + ",thObtain=" + thObtain + ", prObtain=" + prObtain + ",subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", creditHour=" + creditHour + ", geadePoint=" + geadePoint + ", geade=" + geadeTh + ",geade=" + geadePr + ", finalGrade=" + finalGrade + ", remark=" + remark + '}';
    }

}
