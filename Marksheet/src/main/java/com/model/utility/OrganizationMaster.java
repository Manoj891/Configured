/*
@JoinColumn(name = "COLUMN_NAME", referencedColumnName = "ID")
 @ManyToOne(optional = false)
 private ModelName columnName;
SELECT ID,ABOUT_SCHOOL,ADDRESS,DISTRICT,EMAIL,ESTABLISH_YEAR,MUNICIPAL,NAME,PROVINCE,SCHOOL_CODE,TEL,URL,WARD_NO FROM  organization_master;
SELECT ID AS id,ABOUT_SCHOOL AS aboutSchool,ADDRESS AS address,DISTRICT AS district,EMAIL AS email,ESTABLISH_YEAR AS establishYear,MUNICIPAL AS municipal,NAME AS name,PROVINCE AS province,SCHOOL_CODE AS schoolCode,TEL AS tel,URL AS url,WARD_NO AS wardNo FROM  organization_master;

 String colHead[]={"id","aboutSchool","address","district","email","establishYear","municipal","name","province","schoolCode","tel","url","wardNo"};
 */
package com.model.utility;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "organization_master")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class OrganizationMaster {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ABOUT_SCHOOL")
    String aboutSchool;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "DISTRICT")
    private String district;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ESTABLISH_YEAR")
    private String establishYear;
    @Column(name = "MUNICIPAL")
    private String municipal;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "SCHOOL_CODE")
    private String schoolCode;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "URL")
    private String url;
    @Column(name = "WARD_NO")
    private String wardNo;
    @Column(name = "LOGO", unique = true, nullable = true)
    private String logo;

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"aboutSchool\": \"" + aboutSchool + "\",\"address\": \"" + address + "\",\"district\": \"" + district + "\",\"email\": \"" + email + "\",\"establishYear\": \"" + establishYear + "\",\"municipal\": \"" + municipal + "\",\"name\": \"" + name + "\",\"province\": \"" + province + "\",\"schoolCode\": \"" + schoolCode + "\",\"tel\": \"" + tel + "\",\"url\": \"" + url + "\",\"wardNo\": \"" + wardNo + "\"}";
    }
}
