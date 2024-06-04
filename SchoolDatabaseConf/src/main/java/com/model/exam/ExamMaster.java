package com.model.exam;

import com.model.setup.AcademicYear;

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
@Table(name = "exam_master", uniqueConstraints = @UniqueConstraint(name = "TERMINAL_CLASS_ID", columnNames = {"TERMINAL", "ACADEMIC_YEAR"}))
public class ExamMaster implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "EXAM_NAME", unique = true, nullable = false)
    private String examName;
    @Column(name = "year_ad")
    private Long yearAd;

    @Column(name = "ANNOUNCED_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date announcedDate;
    @JoinColumn(name = "ACADEMIC_YEAR", referencedColumnName = "ID", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private AcademicYear academicYear;
    @JoinColumn(name = "TERMINAL", referencedColumnName = "ID", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ExamTerminal terminal;

    public ExamMaster() {
    }

    public ExamMaster(Long id) {
        this.id = id;
    }

    public ExamMaster(String id) {
        this.id = Long.parseLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public ExamTerminal getTerminal() {
        return terminal;
    }

    public void setTerminal(ExamTerminal terminal) {
        this.terminal = terminal;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getAnnouncedDate() {
        return DateConveter.adToBs(announcedDate);
    }

    public void setAnnouncedDate(String announcedDate) {
        this.announcedDate = DateConveter.bsToAdDate(announcedDate);
    }

    public Long getYearAd() {
        return yearAd;
    }

    public void setYearAd(Long yearAd) {
        this.yearAd = yearAd;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"terminal\": \"" + terminal + "\",\"academicYear\": \"" + academicYear + "\",\"examName\": \"" + examName + "\"}";
    }
}
