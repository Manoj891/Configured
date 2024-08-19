package com.model.utility;

import com.model.account.ChartOfAccount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "organization_user_info")
public class OrganizationUserInfo implements java.io.Serializable {
    
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "LOGIN_ID", unique = true, nullable = false, columnDefinition = "VARCHAR(30)")
    private String loginId;
    @Column(name = "EMP_NAME", nullable = false, columnDefinition = "VARCHAR(30)")
    private String empName;
    @Column(name = "EMAIL", unique = true, nullable = true)
    private String email;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "LOGIN_PASS", updatable = false)
    private String loginPass;
    @Column(name = "TOKEN", updatable = false)
    private String token;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "USER_TYPE")
    private String userType;
    @Column(name = "CASH_ACCOUNT")
    private String cashAccount;
    @Column(name = "voucher_un_approve", columnDefinition = "varchar(1) default 'N'")
    private String voucherUnApprove;
    @JoinColumn(name = "CASH_ACCOUNT", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ChartOfAccount chartOfAccount;
    
    public OrganizationUserInfo() {
    }
    
    public OrganizationUserInfo(Long id) {
        this.id = id;
    }

    public OrganizationUserInfo(String id) {
        this.id = Long.parseLong(id);
    }
    
    public Long getId() {
        return id;
    }
    
    public String getEmpName() {
        return empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLoginId() {
        return loginId;
    }
    
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getLoginPass() {
        return "******************";
    }
    
    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getCashAccount() {
        return cashAccount;
    }
    
    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }
    
    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"loginId\": \"" + loginId + "\",\"email\": \"" + email + "\",\"mobile\": \"" + mobile + "\",\"loginPass\": \"" + loginPass + "\",\"token\": \"" + token + "\",\"status\": \"" + status + "\",\"userType\": \"" + userType + "\"}";
    }
}
