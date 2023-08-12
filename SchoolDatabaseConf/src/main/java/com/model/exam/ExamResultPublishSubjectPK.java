/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.exam;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExamResultPublishSubjectPK implements Serializable {

    @Column(name = "EXAM")
    private Long exam;
    @Column(name = "PROGRAM")
    private Long program;
    @Column(name = "CLASS_ID")
    private Long classId;
    @Column(name = "SUBJECT_GROUP")
    private Long subjectGroup;
    @Column(name = "SUBJECT")
    private Long subject;

    public ExamResultPublishSubjectPK() {
    }

    public ExamResultPublishSubjectPK(Long exam, Long program, Long classId, Long subjectGroup, Long subject) {
        this.exam = exam;
        this.program = program;
        this.classId = classId;
        this.subjectGroup = subjectGroup;
        this.subject = subject;
    }

    public Long getExam() {
        return exam;
    }

    public void setExam(Long exam) {
        this.exam = exam;
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

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

}
