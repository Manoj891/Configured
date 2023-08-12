/*
@JoinColumn(name = "COLUMN_NAME", referencedColumnName = "ID")
 @ManyToOne(optional = false)
 private ModelName columnName;
SELECT ID,EMAIL,EMP_NAME,LOGIN_ID,LOGIN_PASS,MOBILE,STATUS,TOKEN FROM  organization_user;
SELECT ID AS id,EMAIL AS email,EMP_NAME AS empName,LOGIN_ID AS loginId,LOGIN_PASS AS loginPass,MOBILE AS mobile,STATUS AS status,TOKEN AS token FROM  organization_user;

 String colHead[]={"id","email","empName","loginId","loginPass","mobile","status","token"};
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
@Table(name = "organization_user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class OrganizationUser {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "EMAIL", unique = true)
    private String email;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOGIN_ID", unique = true)
    private String loginId;
    @Column(name = "LOGIN_PASS", updatable = false)
    private String loginPass;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "STATUS")
    private String status;

    @Column(name = "SCHOOL")
    private Long school;
    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"email\": \"" + email + "\",\"name\": \"" + name + "\",\"loginId\": \"" + loginId + "\",\"loginPass\": \"" + loginPass + "\",\"mobile\": \"" + mobile + "\",\"status\": \"" + status + "\"}";
    }
}
