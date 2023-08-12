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
public class ExamResultPublishPK implements Serializable {

    @Column(name = "EXAM")
    private Long exam;
    @Column(name = "PROGRAM")
    private Long program;
    @Column(name = "CLASS_ID")
    private Long classId;

    public ExamResultPublishPK() {
    }

    public ExamResultPublishPK(Long exam, Long program, Long classId) {
        this.exam = exam;
        this.program = program;
        this.classId = classId;
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

}
