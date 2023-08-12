package com.model.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee_info")
public class EmployeeInfo implements java.io.Serializable {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "code", columnDefinition = "VARCHAR(6)", unique = true, nullable = true)
    private String code;
    @Column(name = "emp_type", columnDefinition = "VARCHAR(15)")
    private String empType;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "province")
    private Integer province;
    @Column(name = "district")
    private String district;
    @Column(name = "municipal")
    private String municipal;
    @Column(name = "ward_no")
    private String wardNo;
    @Column(name = "house_no")
    private String houseNo;
    @Column(name = "SECTOR")
    private String sector;

    @Column(name = "temporary_address")
    private String temporaryAddress;
    @Column(name = "citizenship_no")
    private String citizenshipNo;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private java.util.Date dob;
    @Column(name = "email")
    private String email;
    @Column(name = "alternative_email")
    private String alternativeEmail;
    @Column(name = "emergency_contact_email")
    private String emergencyContactEmail;
    @Column(name = "emergency_contact_no")
    private String emergencyContactNo;
    @Column(name = "emergency_contact_person")
    private String emergencyContactPerson;
    @Column(name = "gender", columnDefinition = "VARCHAR(6)")
    private String gender;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "alternative_mobile")
    private String alternativeMobile;
    @Column(name = "working_status", columnDefinition = "VARCHAR(1)")
    private String workingStatus;
    @Column(name = "join_date")
    @Temporal(TemporalType.DATE)
    private java.util.Date joinDate;
    @Column(name = "holyday1", columnDefinition = "VARCHAR(3)")
    private String holyday1;
    @Column(name = "holyday2", columnDefinition = "VARCHAR(3)")
    private String holyday2;
    @Column(name = "late_status", columnDefinition = "VARCHAR(1)")
    private String lateStatus;
    @Column(name = "ot_status", columnDefinition = "VARCHAR(1)")
    private String otStatus;
    @Column(name = "pan_no", unique = true, nullable = true)
    private String panNo;
    @Column(name = "emp_level")
    private Long empLevel;
    @Column(name = "department")
    private Long department;
    @Column(name = "specialization", columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String specialization;
    @Column(name = "BIOMETRIC_COMPANY_ID", insertable = false, updatable = false)
    private Long biometricCompanyId;
    @Column(name = "BIOMETRIC_EMP_ID", insertable = false, updatable = false)
    private Long biometricEmpId;
    @Column(name = "PHOTO", nullable = true, updatable = false)
    private String photo;
    @Column(name = "ac_code")
    private String acCode;
    @Column(name = "QUALIFICATION")
    private String qualification;
    @Column(name = "RELIGION")
    private Long religion;
    @Column(name = "CAST_ETHNICITY")
    private Long castEthnicity;
    @Column(name = "LOGIN_PASSWORD", insertable = false, updatable = false)
    private String password;

    public EmployeeInfo() {
    }

    public EmployeeInfo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
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

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public String getCitizenshipNo() {
        return citizenshipNo;
    }

    public void setCitizenshipNo(String citizenshipNo) {
        this.citizenshipNo = citizenshipNo;
    }

    public java.util.Date getDob() {
        return dob;
    }

    public void setDob(java.util.Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    public String getEmergencyContactEmail() {
        return emergencyContactEmail;
    }

    public void setEmergencyContactEmail(String emergencyContactEmail) {
        this.emergencyContactEmail = emergencyContactEmail;
    }

    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlternativeMobile() {
        return alternativeMobile;
    }

    public void setAlternativeMobile(String alternativeMobile) {
        this.alternativeMobile = alternativeMobile;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public java.util.Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(java.util.Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getHolyday1() {
        return holyday1;
    }

    public void setHolyday1(String holyday1) {
        this.holyday1 = holyday1;
    }

    public String getHolyday2() {
        return holyday2;
    }

    public void setHolyday2(String holyday2) {
        this.holyday2 = holyday2;
    }

    public String getLateStatus() {
        return lateStatus;
    }

    public void setLateStatus(String lateStatus) {
        this.lateStatus = lateStatus;
    }

    public String getOtStatus() {
        return otStatus;
    }

    public void setOtStatus(String otStatus) {
        this.otStatus = otStatus;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public Long getEmpLevel() {
        return empLevel;
    }

    public void setEmpLevel(Long empLevel) {
        this.empLevel = empLevel;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public Long getBiometricCompanyId() {
        return biometricCompanyId;
    }

    public void setBiometricCompanyId(Long biometricCompanyId) {
        this.biometricCompanyId = biometricCompanyId;
    }

    public Long getBiometricEmpId() {
        return biometricEmpId;
    }

    public void setBiometricEmpId(Long biometricEmpId) {
        this.biometricEmpId = biometricEmpId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Long getReligion() {
        return religion;
    }

    public void setReligion(Long religion) {
        this.religion = religion;
    }

    public Long getCastEthnicity() {
        return castEthnicity;
    }

    public void setCastEthnicity(Long castEthnicity) {
        this.castEthnicity = castEthnicity;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", empType='" + empType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", province=" + province +
                ", district='" + district + '\'' +
                ", municipal='" + municipal + '\'' +
                ", wardNo='" + wardNo + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", sector='" + sector + '\'' +
                ", temporaryAddress='" + temporaryAddress + '\'' +
                ", citizenshipNo='" + citizenshipNo + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", alternativeEmail='" + alternativeEmail + '\'' +
                ", emergencyContactEmail='" + emergencyContactEmail + '\'' +
                ", emergencyContactNo='" + emergencyContactNo + '\'' +
                ", emergencyContactPerson='" + emergencyContactPerson + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", alternativeMobile='" + alternativeMobile + '\'' +
                ", workingStatus='" + workingStatus + '\'' +
                ", joinDate=" + joinDate +
                ", holyday1='" + holyday1 + '\'' +
                ", holyday2='" + holyday2 + '\'' +
                ", lateStatus='" + lateStatus + '\'' +
                ", otStatus='" + otStatus + '\'' +
                ", panNo='" + panNo + '\'' +
                ", empLevel=" + empLevel +
                ", department=" + department +
                ", specialization='" + specialization + '\'' +
                ", biometricCompanyId=" + biometricCompanyId +
                ", biometricEmpId=" + biometricEmpId +
                ", photo='" + photo + '\'' +
                ", acCode='" + acCode + '\'' +
                ", qualification='" + qualification + '\'' +
                ", religion=" + religion +
                ", castEthnicity=" + castEthnicity +
                ", password='" + password + '\'' +
                '}';
    }
}
