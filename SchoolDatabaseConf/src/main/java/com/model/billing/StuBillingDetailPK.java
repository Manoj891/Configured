/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.billing;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StuBillingDetailPK implements Serializable {

    @Column(name = "BILL_NO")
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

}
