/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.billing;

import com.model.setup.BillMaster;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.model.student.StudentInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import model.DateConveter;
import org.hibernate.annotations.Index;

@Entity
@Table(name = "stu_billing_detail")
public class StuBillingDetail implements Serializable {

    @EmbeddedId
    protected StuBillingDetailPK pk;
    @Column(name = "REG_NO")
    private Long regNo;
    @Index(columnNames = "index_stu_billing_detail_academic_year", name = "academic_year")
    @Column(name = "academic_year")
    private long academicYear;
    @Index(columnNames = "index_stu_billing_detail_program", name = "program")
    @Column(name = "program")
    private long program;
    @Index(columnNames = "index_stu_billing_detail_class_id", name = "class_id")
    @Column(name = "class_id")
    private long classId;
    @Column(name = "BILL_ID")
    private long billId;
    @Column(name = "DR")
    private double dr;
    @Column(name = "CR")
    private double cr;
    @Index(columnNames = "index_stu_billing_detail_payment_date", name = "payment_date")
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column(name = "IS_EXTRA", columnDefinition = "VARCHAR(1)")
    @Index(columnNames = "index_stu_billing_detail_is_extra", name = "is_extra")
    private String isExtra;
    @Column(name = "INVENTORY_ISSUE", columnDefinition = "VARCHAR(1)")
    private String inventoryIssue;
    @Column(name = "INVENTORY_ISSUE_BY", columnDefinition = "VARCHAR(30)")
    private String inventoryIssueBy;
    @Column(name = "INVENTORY_ISSUE_DATE", columnDefinition = "VARCHAR(10)")
    private String inventoryIssueDate;
    @JoinColumn(name = "BILL_NO", referencedColumnName = "BILL_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StuBillingMaster billingMaster;
    @JoinColumn(name = "BILL_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BillMaster billMaster;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "REG_NO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StudentInfo studentInfo;
    public StuBillingDetail() {
    }

    @Override
    public String toString() {
        return "\n{\"regNo\":\"" + regNo + "\",\"academicYear\":\"" + academicYear + "\",\"program\":\"" + program + "\",\"classId\":\"" + classId + "\",\"billId\":\"" + billId + "\",\"dr\":\"" + dr + "\",\"cr\":\"" + cr + "\",\"paymentDate\":\"" + paymentDate + "\",\"isExtra\":\"" + isExtra + "\",\"billId\":\"" + billId + "\",\"billSn\":\"" + pk.getBillSn() + "\"}";
    }

}
