/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.billing;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StuBillingDetailPK implements Serializable {

    @Column(name = "bill_no")
    private String billNo;
    @Column(name = "BILL_SN")
    private int billSn;

    public StuBillingDetailPK() {
    }

    public StuBillingDetailPK(String billNo, int billSn) {
        this.billNo = billNo;
        this.billSn = billSn;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public int getBillSn() {
        return billSn;
    }

    public void setBillSn(int billSn) {
        this.billSn = billSn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuBillingDetailPK that = (StuBillingDetailPK) o;
        return billSn == that.billSn && Objects.equals(billNo, that.billNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billNo, billSn);
    }
}
