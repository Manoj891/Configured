package com.model.student;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import model.DateConveter;

@Entity
@Table(name = "school_class_session", uniqueConstraints = @UniqueConstraint(columnNames = {"PROGRAM", "CLASS_ID", "ACADEMIC_YEAR"}, name = "UNIQUE_CLASS_OF_YEAR"))
public class SchoolClassSession implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PROGRAM", columnDefinition = "BIGINT NOT NULL")
    private Long program;
    @Column(name = "CLASS_ID", columnDefinition = "BIGINT NOT NULL")
    private Long classId;
    @Column(name = "ACADEMIC_YEAR", columnDefinition = "BIGINT NOT NULL")
    private Long academicYear;
    @Column(name = "START_DATE", columnDefinition = "DATE NOT NULL")
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate;
    @Column(name = "END_DATE", columnDefinition = "DATE NOT NULL")
    @Temporal(TemporalType.DATE)
    private java.util.Date endDate;
    @Column(name = "TOTAL_MONTH")
    private Integer totalMonth;

    public SchoolClassSession() {
    }

    public SchoolClassSession(Long id) {
        this.id = id;
    }

    public SchoolClassSession(String id) {
        this.id = Long.parseLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Long academicYear) {
        this.academicYear = academicYear;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStartDateBs() {
        return DateConveter.adToBs(startDate);
    }

    public void setStartDate(String startDate) {
        this.startDate = DateConveter.bsToAdDate(startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getEndDateBs() {
        return DateConveter.adToBs(endDate);
    }

    public void setEndDate(String endDate) {
        this.endDate = DateConveter.bsToAdDate(endDate);
    }

    public Integer getTotalMonth() {
        return totalMonth;
    }

    public void setTotalMonth(Integer totalMonth) {
        this.totalMonth = totalMonth;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"program\": \"" + program + "\",\"classId\": \"" + classId + "\",\"academicYear\": \"" + academicYear + "\",\"startDate\": \"" + startDate + "\",\"endDate\": \"" + endDate + "\",\"startDateBs\": \"" + getStartDateBs() + "\",\"endDateBS\": \"" + getEndDateBs() + "\",\"totalMonth\": \"" + totalMonth + "\"}";
    }
}
