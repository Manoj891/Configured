/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.student;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClassTransferPK implements Serializable {

    @Column(name = "ACADEMIC_YEAR")
    private long academicYear;
    @Column(name = "STUDENT_ID")
    private long studentId;

    public ClassTransferPK() {
    }

    public ClassTransferPK(long studentId, long academicYear) {
        this.studentId = studentId;
        this.academicYear = academicYear;
    }

    public long getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(long academicYear) {
        this.academicYear = academicYear;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

}
