package com.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "voucher_detail", uniqueConstraints = @UniqueConstraint(name = "VOUCHER_NO", columnNames = {"VOUCHER_NO", "VOUCHER_SN"}))
public class VoucherDetail implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "VOUCHER_NO")
    private String voucherNo;
    @Column(name = "VOUCHER_SN")
    private Integer voucherSn;
    @Column(name = "AC_CODE", nullable = false)
    private String acCode;
    @Column(name = "PARTICULAR", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String particular;
    @Column(name = "DR_AMT", nullable = false)
    private Double drAmt;
    @Column(name = "CR_AMT", nullable = false)
    private Double crAmt;
    @Column(name = "BILL_NO")
    private String billNo;
    @Column(name = "CHEQUE_NO")
    private String chequeNo;
    @Column(name = "CREATED_DATETIME", columnDefinition = "DATETIME DEFAULT now()")
    private Date created = new Date();
    @JoinColumn(name = "AC_CODE", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ChartOfAccount chartOfAccount;
    @JoinColumn(name = "VOUCHER_NO", referencedColumnName = "VOUCHER_NO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Voucher voucher;

    public VoucherDetail() {
    }

    public VoucherDetail(String voucherNo, Integer voucherSn, String acCode, String particular, Double drAmt, Double crAmt, String billNo, String chequeNo) {
        this.id = voucherNo + "-" + voucherSn;
        this.voucherNo = voucherNo;
        this.voucherSn = voucherSn;
        this.acCode = acCode;
        this.particular = particular;
        this.drAmt = drAmt;
        this.crAmt = crAmt;
        this.billNo = billNo;
        this.chequeNo = chequeNo;
    }

    public VoucherDetail(String acCode, String particular, Double drAmt, Double crAmt) {
        this.acCode = acCode;
        this.particular = particular;
        this.drAmt = drAmt;
        this.crAmt = crAmt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getVoucherSn() {
        return voucherSn;
    }

    public void setVoucherSn(Integer voucherSn) {
        this.voucherSn = voucherSn;
    }

    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public Double getDrAmt() {
        return drAmt;
    }

    public void setDrAmt(Double drAmt) {
        this.drAmt = drAmt;
    }

    public Double getCrAmt() {
        return crAmt;
    }

    public void setCrAmt(Double crAmt) {
        this.crAmt = crAmt;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"voucherNo\": \"" + voucherNo + "\",\"voucherSn\": \"" + voucherSn + "\",\"acCode\": \"" + acCode + "\",\"particular\": \"" + particular + "\",\"drAmt\": \"" + drAmt + "\",\"crAmt\": \"" + crAmt + "\"}";
    }
}
