package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school_list")
public class SchoolList implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DISTRICT")
    private String district;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "SCHOOL_API")
    private String schoolApi;
    @Column(name = "REMOTE_URL")
    private String remoteUrl;
    @Column(name = "SCHOOL_LOGO")
    private String schoolLogo;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CONTACT_NO")
    private String contactNo;
    private String schoolRegistrationCertificate;
    private String panRegistrationCertificate;
    private String taxClearanceCertificate;

    public SchoolList() {
    }

    public SchoolList(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolApi() {
        return schoolApi;
    }

    public void setSchoolApi(String schoolApi) {
        this.schoolApi = schoolApi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchoolLogo() {
        return schoolLogo;
    }

    public void setSchoolLogo(String schoolLogo) {
        this.schoolLogo = schoolLogo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"name\": \"" + name + "\",\"district\": \"" + district + "\",\"address\": \"" + address + "\",\"schoolApi\": \"" + schoolApi + "\",\"email\": \"" + email + "\",\"accountNo\": \"" + accountNo + "\",\"status\": \"" + status + "\"}";
    }

    public String getSchoolRegistrationCertificate() {
        return schoolRegistrationCertificate;
    }

    public void setSchoolRegistrationCertificate(String schoolRegistrationCertificate) {
        this.schoolRegistrationCertificate = schoolRegistrationCertificate;
    }

    public String getPanRegistrationCertificate() {
        return panRegistrationCertificate;
    }

    public void setPanRegistrationCertificate(String panRegistrationCertificate) {
        this.panRegistrationCertificate = panRegistrationCertificate;
    }

    public String getTaxClearanceCertificate() {
        return taxClearanceCertificate;
    }

    public void setTaxClearanceCertificate(String taxClearanceCertificate) {
        this.taxClearanceCertificate = taxClearanceCertificate;
    }
}
