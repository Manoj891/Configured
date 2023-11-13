package com.model.account;

import com.model.billing.StuBillingMaster;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import model.DateConveter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "voucher", uniqueConstraints = @UniqueConstraint(name = "VOUCHER_SN", columnNames = {"VOUCHER_TYPE", "FISCAL_YEAR", "VOUCHER_SN"}))
public class Voucher implements java.io.Serializable {

    @Id
    @Column(name = "VOUCHER_NO")
    private String voucherNo;
    @Column(name = "VOUCHER_TYPE")
    private String voucherType;
    @Column(name = "FISCAL_YEAR")
    private Long fiscalYear;
    @Column(name = "VOUCHER_SN")
    private Integer voucherSn;
    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;
    @Column(name = "ENTER_BY")
    private String enterBy;
    @Column(name = "ENTER_DATE")
    @Temporal(TemporalType.DATE)
    private java.util.Date enterDate;
    @Column(name = "APPROVE_BY", updatable = false, insertable = false, nullable = true)
    private String approveBy;
    @Column(name = "APPROVE_DATE", updatable = false, insertable = false, nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date approveDate;

    @Column(name = "REJECT_BY", updatable = false, insertable = false, nullable = true)
    private String rejectBy;
    @Column(name = "REJECT_DATE", updatable = false, insertable = false, nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date rejectDate;

    @Column(name = "created_at", columnDefinition = " timestamp default now()")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "NARRATION", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String narration;
    @Column(name = "CHEQUE_NO")
    private String chequeNo;
    @Column(name = "FEE_RECEIPT_NO", unique = true, nullable = true)
    private String feeReceiptNo;
    @JoinColumn(name = "FEE_RECEIPT_NO", referencedColumnName = "BILL_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StuBillingMaster stuBillingMaster;
    @JoinColumn(name = "FISCAL_YEAR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private FiscalYear fiscalYearMaster;
    @Fetch(value = FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucher", fetch = FetchType.EAGER)
    private List<VoucherDetail> detail;

    public Voucher() {
    }

    public Voucher(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public Long getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Long fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Integer getVoucherSn() {
        return voucherSn;
    }

    public void setVoucherSn(Integer voucherSn) {
        this.voucherSn = voucherSn;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public String getEnterDate() {
        return DateConveter.adToBs(enterDate);
    }

    public Date getEnterDateAd() {
        return enterDate;
    }

    public void setEnterDateAd(String enterDate) {
        this.enterDate = DateConveter.toDate(enterDate);
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = DateConveter.bsToAdDate(enterDate);
    }

    public void setEnterDateAd(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(String approveBy) {
        this.approveBy = approveBy;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getFeeReceiptNo() {
        return feeReceiptNo;
    }

    public void setFeeReceiptNo(String feeReceiptNo) {
        this.feeReceiptNo = feeReceiptNo;
    }

    public List<VoucherDetail> getObj() {
        return detail;
    }

    public void setObj(List<VoucherDetail> detail) {
        this.detail = detail;
    }

    public List<VoucherDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<VoucherDetail> detail) {
        this.detail = detail;
    }

    public String getRejectBy() {
        return rejectBy;
    }

    public void setRejectBy(String rejectBy) {
        this.rejectBy = rejectBy;
    }

    public Date getRejectDate() {
        return rejectDate;
    }

    public void setRejectDate(Date rejectDate) {
        this.rejectDate = rejectDate;
    }

    @Override
    public String toString() {
        return "\n{\"voucherNo\": \"" + voucherNo + "\",\"voucherType\": \"" + voucherType + "\",\"fiscalYear\": \"" + fiscalYear + "\",\"voucherSn\": \"" + voucherSn + "\",\"totalAmount\": \"" + totalAmount + "\",\"enterBy\": \"" + enterBy + "\",\"enterDate\": \"" + enterDate + "\",\"approveBy\": \"" + approveBy + "\",\"approveDate\": \"" + approveDate + "\",\"narration\": \"" + narration + "\",\"chequeNo\": \"" + chequeNo + "\",\"feeReceiptNo\": \"" + feeReceiptNo + "\",\"detail\": \"" + detail + "\"}";
    }
}
