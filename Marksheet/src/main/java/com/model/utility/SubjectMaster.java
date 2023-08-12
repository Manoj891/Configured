/*
@JoinColumn(name = "COLUMN_NAME", referencedColumnName = "ID")
 @ManyToOne(optional = false)
 private ModelName columnName;
SELECT ID,SCHOOL,SUBJECT_CODE,SUBJECT_NAME FROM  subject_master;
SELECT ID AS id,SCHOOL AS school,SUBJECT_CODE AS subjectCode,SUBJECT_NAME AS subjectName FROM  subject_master;

 String colHead[]={"id","school","subjectCode","subjectName"};
 */
package com.model.utility;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "subject_master", uniqueConstraints = @UniqueConstraint(columnNames = {"SCHOOL", "SUBJECT_CODE"}))
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class SubjectMaster {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SCHOOL", nullable = false, updatable = false)
    private Long school;
    @Column(name = "SUBJECT_CODE", nullable = false)
    private String subjectCode;
    @Column(name = "SUBJECT_NAME", nullable = false)
    private String subjectName;
    @Column(name = "CREDIT_HOUR", nullable = false)
    private Double creditHour;
    @Column(name = "TH_FM", nullable = false)
    private Double thFm;
    @Column(name = "PR_FM", nullable = false)
    private Double prFm;
    @Column(name = "PR_SUBJECT", updatable = false, insertable = false, nullable = true)
    private Long prSubject;

    public long getPrSub() {
        try {
            if (prSubject == null) {
                return 0;
            }
            return prSubject;
        } catch (Exception e) {
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"school\": \"" + school + "\",\"subjectCode\": \"" + subjectCode + "\",\"subjectName\": \"" + subjectName + "\",\"prSubject\": \"" + prSubject + "\"}";
    }
}
