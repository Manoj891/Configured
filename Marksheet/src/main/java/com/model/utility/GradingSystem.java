package com.model.utility;

import com.config.DateConvert;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "grading_system")
public class GradingSystem implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "RANG_FROM", nullable = false)
    private Float rangFrom;
    @Column(name = "GRADE", nullable = false, columnDefinition = "VARCHAR(3)")
    private String grade;
    @Column(name = "GPA", nullable = false)
    private Float gpa;
    @Column(name = "REMARK", nullable = false, columnDefinition = "VARCHAR(30)")
    private String remark;
    @Column(name = "EFFECTIVE_DATE_FROM", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date effectiveDateFrom;
    @Column(name = "EFFECTIVE_DATE_TO", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date effectiveDateTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRangFrom() {
        return rangFrom;
    }

    public void setRangFrom(Float rangFrom) {
        this.rangFrom = rangFrom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    public void setEffectiveDateFrom(Date effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }

    public String getEffectiveDateTo() {
        if(effectiveDateTo==null)return "";
        return DateConvert.toString(effectiveDateTo);
    }

    public void setEffectiveDateTo(Date effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"rangFrom\": \"" + rangFrom + "\",\"grad\": \"" + grade + "\",\"gpa\": \"" + gpa + "\",\"remark\": \"" + remark + "\",\"effectiveDateFrom\": \"" + effectiveDateFrom + "\",\"effectiveDateTo\": \"" + effectiveDateTo + "\"}";
    }
}
