package com.model.utility;

import com.model.account.ChartOfAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.DateConveter;

@Entity
@Table(name = "organization_master")
public class OrganizationMaster implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String name;
    @Column(name = "ADDRESS", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String address;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "DISTRICT", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String district;
    @Column(name = "MUNICIPAL", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String municipal;
    @Column(name = "WARD_NO", columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String wardNo;
    @Column(name = "ESTABLISH_YEAR")
    private String establishYear;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "URL")
    private String url;

    @Column(name = "BIOMETRIC_DATA_ID", insertable = false, updatable = false)
    private String biometricDataId;
    @Column(name = "BIOMETRIC_DATA_URL", insertable = false, updatable = false)
    private String biometricDataUrl;

    @Column(name = "SMS_SEND_API", updatable = false, insertable = false)
    private String smsSendApi;
    @Column(name = "SCHOOL_CODE", updatable = false, insertable = false)
    private String schoolCode;
    @Column(name = "STUDENT_FEE_INCOME_ACCOUNT", columnDefinition = "VARCHAR(30)")
    private String studentFeeIncomeAccount;
    @Column(name = "CASH_ACCOUNT", columnDefinition = "VARCHAR(30)")
    private String cashAccount;
    @Column(name = "INVENTORY_ACCOUNT", columnDefinition = "VARCHAR(30)")
    private String inventoryAccount;
    @Column(name = "STUDENT_INVENTORY_ACCOUNT", columnDefinition = "VARCHAR(30)")
    private String studentInventoryAccount;
    @Column(name = "SUNDRY_CREDITORS", columnDefinition = "VARCHAR(30)")
    private String sundryCreditors;
    @Column(name = "SUNDRY_DEBTORS", columnDefinition = "VARCHAR(30)")
    private String sundryDebtors;

    @Column(name = "RESERVES_AND_SURPLUS", columnDefinition = "VARCHAR(30)")
    private String reservesAndSurplus;

    @Column(name = "employee_fund_payable", columnDefinition = "VARCHAR(30)")
    private String employeeFundPayable;

    @Column(name = "cit_payable", columnDefinition = "VARCHAR(30)")
    private String citPayable;

    @Column(name = "pf_payable", columnDefinition = "VARCHAR(30)")
    private String pfPayable;
    @Column(name = "sst_payable", columnDefinition = "VARCHAR(30)")
    private String sstPayable;
    @Column(name = "income_tax_payable", columnDefinition = "VARCHAR(30)")
    private String incomeTaxPayable;

    @Column(name = "salary_expenses", columnDefinition = "VARCHAR(30)")
    private String salaryExpenses;

    @Column(name = "DOCUMENT_FOLDER_LOCATION")
    private String documentFolderLocation;
    @Column(name = "KHALTI_PAYMENT_ACTIVE", columnDefinition = "VARCHAR(1)", updatable = false, insertable = false)
    private String khaltiPaymentActive;
    @Column(name = "INSTALLATION_DATE", columnDefinition = "DATE")
    private String installationDate;

    @JoinColumn(name = "STUDENT_FEE_INCOME_ACCOUNT", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ChartOfAccount chartofaccountstudentFeeIncomeAccount;

    @JoinColumn(name = "INVENTORY_ACCOUNT", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ChartOfAccount chartofaccountinventoryAccount;

    @JoinColumn(name = "STUDENT_FEE_INCOME_ACCOUNT", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ChartOfAccount chartofaccountstudentInventoryAccount;
    @JoinColumn(name = "SUNDRY_CREDITORS", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ChartOfAccount chartofaccountsundryCreditors;

    @Column(name = "ABOUT_SCHOOL", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String aboutSchool;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEstablishYear() {
        return establishYear;
    }

    public void setEstablishYear(String establishYear) {
        this.establishYear = establishYear;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStudentFeeIncomeAccount() {
        return studentFeeIncomeAccount;
    }

    public void setStudentFeeIncomeAccount(String studentFeeIncomeAccount) {
        this.studentFeeIncomeAccount = studentFeeIncomeAccount;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }

    public String getInventoryAccount() {
        return inventoryAccount;
    }

    public void setInventoryAccount(String inventoryAccount) {
        this.inventoryAccount = inventoryAccount;
    }

    public String getStudentInventoryAccount() {
        return studentInventoryAccount;
    }

    public void setStudentInventoryAccount(String studentInventoryAccount) {
        this.studentInventoryAccount = studentInventoryAccount;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMunicipal() {
        return municipal;
    }

    public void setMunicipal(String municipal) {
        this.municipal = municipal;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getSundryCreditors() {
        return sundryCreditors;
    }

    public void setSundryCreditors(String sundryCreditors) {
        this.sundryCreditors = sundryCreditors;
    }

    public String getDocumentFolderLocation() {
        return documentFolderLocation;
    }

    public void setDocumentFolderLocation(String documentFolderLocation) {
        this.documentFolderLocation = documentFolderLocation;
    }

    public String getSundryDebtors() {
        return sundryDebtors;
    }

    public void setSundryDebtors(String sundryDebtors) {
        this.sundryDebtors = sundryDebtors;
    }

    public String getReservesAndSurplus() {
//         System.out.println("reservesAndSurplus "+reservesAndSurplus);
        return reservesAndSurplus;
    }

    public void setReservesAndSurplus(String reservesAndSurplus) {
        this.reservesAndSurplus = reservesAndSurplus;
    }

    public String getSmsSendApi() {
        return smsSendApi;
    }

    public void setSmsSendApi(String smsSendApi) {
        this.smsSendApi = smsSendApi;
    }

    public String getAboutSchool() {
        return aboutSchool;
    }

    public void setAboutSchool(String aboutSchool) {
        this.aboutSchool = aboutSchool;
    }

    public String getInstallationDate() {
        return DateConveter.adToBs(installationDate);
    }

    public void setInstallationDate(String installationDate) {
        this.installationDate = DateConveter.bsToAd(installationDate);
    }

    public String getKhaltiPaymentActive() {
        return khaltiPaymentActive;
    }

    public void setKhaltiPaymentActive(String khaltiPaymentActive) {
        this.khaltiPaymentActive = "N";
    }

    public String getEmployeeFundPayable() {
        return employeeFundPayable;
    }

    public void setEmployeeFundPayable(String employeeFundPayable) {
        this.employeeFundPayable = employeeFundPayable;
    }

    public String getCitPayable() {
        return citPayable;
    }

    public void setCitPayable(String citPayable) {
        this.citPayable = citPayable;
    }

    public String getPfPayable() {
        return pfPayable;
    }

    public void setPfPayable(String pfPayable) {
        this.pfPayable = pfPayable;
    }

    public String getSalaryExpenses() {
        return salaryExpenses;
    }

    public void setSalaryExpenses(String salaryExpenses) {
        this.salaryExpenses = salaryExpenses;
    }

    public String getSstPayable() {
        return sstPayable;
    }

    public void setSstPayable(String sstPayable) {
        this.sstPayable = sstPayable;
    }

    public String getIncomeTaxPayable() {
        return incomeTaxPayable;
    }

    public void setIncomeTaxPayable(String incomeTaxPayable) {
        this.incomeTaxPayable = incomeTaxPayable;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"municipal\": \"" + municipal + "\",\"district\": \"" + district + "\",\"wardNo\": \"" + wardNo + "\",\"name\": \"" + name + "\",\"address\": \"" + address + "\",\"province\": \"" + province + "\",\"establishYear\": \"" + establishYear + "\",\"tel\": \"" + tel + "\",\"email\": \"" + email + "\",\"url\": \"" + url + "\"}";
    }
}
