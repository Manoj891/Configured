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

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "class_transfer")
public class ClassTransfer {

    @EmbeddedId
    private ClassTransferPK pk;
    @Column(name = "PROGRAM")
    private Long program;
    @Column(name = "CLASS_ID")
    private Long classId;
    @Column(name = "SUBJECT_GROUP")
    private Long subjectGroup;
    @Column(name = "ROLL_NO")
    private Integer rollNo;
    @Column(name = "SECTION")
    private String section;


    @JoinColumn(name = "SUBJECT_GROUP", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubjectGroup group;

    @JoinColumn(name = "PROGRAM", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProgramMaster programMaster;
    @JoinColumn(name = "CLASS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClassMaster classMaster;
    @JoinColumn(name = "ACADEMIC_YEAR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AcademicYear academicYear;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StudentInfo studentInfo;

    public ClassTransfer() {
    }

    public ClassTransfer(long studentId, long academicYear, Long program, Long classId, Long subjectGroup, Integer rollNo, String section) {
        this.pk = new ClassTransferPK(studentId, academicYear);
        this.program = program;
        this.classId = classId;
        this.subjectGroup = subjectGroup;
        this.rollNo = rollNo;
        this.section = section;
    }

    public ClassTransferPK getPk() {
        return pk;
    }

    public void setPk(ClassTransferPK pk) {
        this.pk = pk;
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

    public Long getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(Long subjectGroup) {
        this.subjectGroup = subjectGroup;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "{\"academicYear\":\"" + pk.getAcademicYear() + "\",\"studentId\":\"" + pk.getStudentId() + "\",\"program\":\"" + program + "\",\"classId\":\"" + classId + "\",\"subjectGroup\":\"" + subjectGroup + "\",\"rollNo\":\"" + rollNo + "\",\"section\":\"" + section + "\"}";
    }

}
