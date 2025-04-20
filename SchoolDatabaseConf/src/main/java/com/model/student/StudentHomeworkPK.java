/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.student;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
public class StudentHomeworkPK implements Serializable {

    @Column(name = "STU_ID")
    private Long stuId;
    @Column(name = "HOMEWORK")
    private Long homework;

    public StudentHomeworkPK() {
    }

    public StudentHomeworkPK(Long stuId, Long homework) {
        this.stuId = stuId;
        this.homework = homework;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getHomework() {
        return homework;
    }

    public void setHomework(Long homework) {
        this.homework = homework;
    }

}
