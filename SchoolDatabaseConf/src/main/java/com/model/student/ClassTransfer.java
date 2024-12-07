/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.student;

import com.model.setup.AcademicYear;
import com.model.setup.ClassMaster;
import com.model.setup.ProgramMaster;
import com.model.setup.SubjectGroup;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "class_transfer")
public class ClassTransfer {

    @EmbeddedId
    private ClassTransferPK pk;
    @Column(name = "PROGRAM")
    private Long program;
    @Column(name = "SUBJECT_GROUP")
    private Long subjectGroup;
    @Column(name = "ROLL_NO")
    private Integer rollNo;
    @Column(name = "SECTION")
    private String section;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "SUBJECT_GROUP", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubjectGroup group;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "PROGRAM", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProgramMaster programMaster;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "CLASS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClassMaster classMaster;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "ACADEMIC_YEAR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AcademicYear academicYear;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StudentInfo studentInfo;

    public ClassTransfer() {
    }

    public ClassTransfer(long studentId, long academicYear, Long program, Long classId, Long subjectGroup, Integer rollNo, String section) {
        this.pk = new ClassTransferPK(studentId, academicYear, classId);
        this.program = program;
        this.subjectGroup = subjectGroup;
        this.rollNo = rollNo;
        this.section = section;
    }

    @Override
    public String toString() {
        return "{\"academicYear\":\"" + pk.getAcademicYear() + "\",\"studentId\":\"" + pk.getStudentId() + "\",\"program\":\"" + program + "\",\"classId\":\"" + pk.getClassId() + "\",\"subjectGroup\":\"" + subjectGroup + "\",\"rollNo\":\"" + rollNo + "\",\"section\":\"" + section + "\"}";
    }

}
