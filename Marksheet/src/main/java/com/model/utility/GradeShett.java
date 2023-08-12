package com.model.utility;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Comparator;
import java.util.List;
import javax.persistence.CascadeType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "grade_shett", uniqueConstraints = @UniqueConstraint(columnNames = {"YEAR", "SCHOOL", "REG_NO"}))
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class GradeShett {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SCHOOL", updatable = false)
    private Long school;
    @Column(name = "YEAR", updatable = false)
    private Long year;
    @Column(name = "REG_NO")
    private String regNo;
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "SYMBOL_NO")
    private String symbolNo;
    @Column(name = "GRADE")
    private String grade;
    @Column(name = "GPA")
    private String gpa;
    @Column(name = "DATE_OF_ISSUE")
    private String dateOfIssue;
    @Column(name = "ENTER_BY")
    private String enterBy;
    @Column(name = "ENTER_DATE")
    private String enterDate;
    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradeShett", fetch = FetchType.EAGER)
    private List<GradeShettDetail> detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchool() {
        return school;
    }

    public void setSchool(Long school) {
        this.school = school;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSymbolNo() {
        return symbolNo;
    }

    public void setSymbolNo(String symbolNo) {
        this.symbolNo = symbolNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public List<GradeShettDetail> getDetail() {
        try {
            detail.sort(Comparator.comparingInt(GradeShettDetail::getSubjectCodeInt));
        } catch (Exception e) {
        }
        return detail;
    }

    public void setDetail(List<GradeShettDetail> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"school\": \"" + school + "\",\"regNo\": \"" + regNo + "\",\"studentName\": \"" + studentName + "\",\"dob\": \"" + dob + "\",\"symbolNo\": \"" + symbolNo + "\",\"grade\": \"" + grade + "\",\"gpa\": \"" + gpa + "\",\"dateOfIssue\": \"" + dateOfIssue + "\",\"enterBy\": \"" + enterBy + "\",\"enterDate\": \"" + enterDate + "\",\"detail\": \"" + detail + "\"}";
    }
}
