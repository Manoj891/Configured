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
public class Annex4bDetailPK implements Serializable {

    @Column(name = "MASTER_ID")
    private String masterId;
    @Column(name = "SUBJECT")
    private Long subject;

    public Annex4bDetailPK() {
    }

    public Annex4bDetailPK(String masterId, Long subject) {
        this.masterId = masterId;
        this.subject = subject;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

}
