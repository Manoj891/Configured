//package com.model.utility;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "emis_data_import")
//public class EmisDataImport {
//    @Id
//    @Column(name = "reg_no")
//    private Long id;
//    @Column(name = "class_id")
//    private Long class_id;
//    @Column(name = "stu_name", length = 60)
//    private String stu_name;
//    @Column(name = "date_of_birth", length = 15)
//    private String date_of_birth;
//    @Column(name = "gender", length = 8)
//    private String gender;
//    @Column(name = "caste", length = 20)
//    private String caste;
//    @Column(name = "fathers_name", length = 60)
//    private String fathers_name;
//    @Column(name = "mothers_name", length = 60)
//    private String mothers_name;
//    @Column(name = "address", length = 160)
//    private String address;
//
//    public EmisDataImport(long id, long class_id, String stu_name, String date_of_birth, String gender, String caste, String fathers_name, String mothers_name, String address) {
//        this.id = id;
//        this.class_id = class_id;
//        this.stu_name = stu_name;
//        this.date_of_birth = date_of_birth;
//        this.gender = gender;
//        this.caste = caste;
//        this.fathers_name = fathers_name;
//        this.mothers_name = mothers_name;
//        this.address = address;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getClass_id() {
//        return class_id;
//    }
//
//    public void setClass_id(Long class_id) {
//        this.class_id = class_id;
//    }
//
//    public String getStu_name() {
//        return stu_name;
//    }
//
//    public void setStu_name(String stu_name) {
//        this.stu_name = stu_name;
//    }
//
//    public String getDate_of_birth() {
//        return date_of_birth;
//    }
//
//    public void setDate_of_birth(String date_of_birth) {
//        this.date_of_birth = date_of_birth;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getCaste() {
//        return caste;
//    }
//
//    public void setCaste(String caste) {
//        this.caste = caste;
//    }
//
//    public String getFathers_name() {
//        return fathers_name;
//    }
//
//    public void setFathers_name(String fathers_name) {
//        this.fathers_name = fathers_name;
//    }
//
//    public String getMothers_name() {
//        return mothers_name;
//    }
//
//    public void setMothers_name(String mothers_name) {
//        this.mothers_name = mothers_name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//}
