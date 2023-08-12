/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.utility;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GradeSheetDetailPk implements Serializable {

    @Column(name = "MASTER_ID")
    private Long masterId;
    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    public GradeSheetDetailPk() {
    }

    public GradeSheetDetailPk(Long masterId, Long subjectId) {
        this.masterId = masterId;
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "{\"masterId\":\"" + masterId + "\",\"subjectId\":\"" + subjectId + "\"}";
    }

}
