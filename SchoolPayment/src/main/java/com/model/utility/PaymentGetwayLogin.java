package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_getway_login")
public class PaymentGetwayLogin implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MOBILE_NO")
    private String mobileNo;
    @Column(name = "CONTACT_PERSON")
    private String contactPerson;
    @Column(name = "PERSON_NO")
    private String personNo;
    @Column(name = "LOGIN_PASS", insertable = false, updatable = false)
    private String loginPass;
    @Column(name = "TOKEN", insertable = false, updatable = false)
    private String token;

    public PaymentGetwayLogin() {
    }

    public PaymentGetwayLogin(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"name\": \"" + name + "\",\"email\": \"" + email + "\",\"mobileNo\": \"" + mobileNo + "\",\"contactPerson\": \"" + contactPerson + "\",\"personNo\": \"" + personNo + "\"}";
    }
}
