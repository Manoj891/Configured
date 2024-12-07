package com.model.account;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Index;

@Entity
@Table(name = "ledger")
public class Ledger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "AC_CODE")
    private String acCode;
    @Column(name = "VOUCHER_NO")
    private String voucherNo;
    @Column(name = "DR_AMT", nullable = false)
    private Float drAmt;
    @Column(name = "CR_AMT", nullable = false)
    private Float crAmt;
    @Column(name = "PARTICULAR", columnDefinition = "TEXT")
    private String particular;
    @Column(name = "FEE_RECEIPT_NO", nullable = true, columnDefinition = "VARCHAR(30)")
    private String feeReceiptNo;
    @Index(columnNames = "index_ledger_enter_date", name = "ENTER_DATE")
    @NotNull
    @Column(name = "ENTER_DATE")
    @Temporal(TemporalType.DATE)
    private Date enterDate;
    @Size(max = 30)
    @Column(name = "ENTER_BY")
    private String enterBy;
    @Index(columnNames = "index_ledger_post_date", name = "POST_DATE")
    @Column(name = "POST_DATE")
    @Temporal(TemporalType.DATE)
    private Date postDate;
    @Size(max = 30)
    @Column(name = "POST_BY")
    private String postBy;
    @Size(max = 30)
    @Column(name = "CHEQUE_NO")
    private String chequeNo;
    @Column(name = "NARRATION", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String narration;
    @JoinColumn(name = "AC_CODE", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ChartOfAccount chartOfAccount;
    @JoinColumn(name = "VOUCHER_NO", referencedColumnName = "VOUCHER_NO", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Voucher voucher;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private VoucherDetail voucherDetail;
    @Column(name = "BANK_RECONCILIATION", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String bankReconciliation;

    @Column(name = "BANK_RECONCILIATION_DATE", columnDefinition = "VARCHAR(30) DEFAULT NULL")
    private String bankReconciliationDate;

    public Ledger() {
    }

    public Ledger(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Float getDrAmt() {
        return drAmt;
    }

    public void setDrAmt(Float drAmt) {
        this.drAmt = drAmt;
    }

    public Float getCrAmt() {
        return crAmt;
    }

    public void setCrAmt(Float crAmt) {
        this.crAmt = crAmt;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public String getFeeReceiptNo() {
        return feeReceiptNo;
    }

    public void setFeeReceiptNo(String feeReceiptNo) {
        this.feeReceiptNo = feeReceiptNo;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getBankReconciliation() {
        return bankReconciliation;
    }

    public void setBankReconciliation(String bankReconciliation) {
        this.bankReconciliation = bankReconciliation;
    }

    public String getBankReconciliationDate() {
        return bankReconciliationDate;
    }

    public void setBankReconciliationDate(String bankReconciliationDate) {
        this.bankReconciliationDate = bankReconciliationDate;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", acCode=" + acCode + ", voucherNo=" + voucherNo + ", drAmt=" + drAmt + ", crAmt=" + crAmt + ", particular=" + particular + ", feeReceiptNo=" + feeReceiptNo + ", enterDate=" + enterDate + ", enterBy=" + enterBy + ", postDate=" + postDate + ", postBy=" + postBy + ", chequeNo=" + chequeNo + ", narration=" + narration + ", chartOfAccount=" + chartOfAccount + ", voucher=" + voucher + ", voucherDetail=" + voucherDetail + '}';
    }

}
