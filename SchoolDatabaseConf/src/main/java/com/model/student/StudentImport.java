package com.model.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_import")
public class StudentImport {

    @Id
    @Column(name = "id")
    private long id;
    private String studentsName;
    @Column(name = "program")
    private Long program;
    @Column(name = "program_name")
    private String programName;
    @Column(name = "class_id")
    private Long classId;
    @Column(name = "class_name")
    private String className;
    @Column(name = "group_id")
    private Long groupId;
    @Column(name = "group_name")
    private String groupName;
    private String section;
    private String gender;
    private Integer rollNo;
    private String dateOfBirth;
    private String mobileNo;
    private String fathersName;
    private String fathersContactNo;
    private String fathersOccupation;
    private String mothersName;
    private String mothersOccupation;
    private String mothersContactNo;
    private String permanentAddress;
    private String correspondingAddress;
    private String guardiansName;
    private String registrationDate;
    @Column(name = "approved")
    private boolean approved;

    @Override
    public String toString() {
        return "\"id\":\"" + id + "\",\"studentsName\":\"'" + studentsName + "\",\"program\":\"" + program + "\",\"programName\":\"'" + programName + "\",\"classId\":\"" + classId + "\",\"className\":\"'" + className + "\",\"groupId\":\"" + groupId + "\",\"groupName\":\"'" + groupName + "\",\"section\":\"'" + section + "\",\"rollNo\":\"" + rollNo + "\",\"dateOfBirth\":\"'" + dateOfBirth + "\",\"mobileNo\":\"'" + mobileNo + "\",\"fathersName\":\"'" + fathersName + "\",\"fathersContactNo\":\"'" + fathersContactNo + "\",\"fathersOccupation\":\"'" + fathersOccupation + "\",\"mothersName\":\"'" + mothersName + "\",\"mothersOccupation\":\"'" + mothersOccupation + "\",\"mothersContactNo\":\"'" + mothersContactNo + "\",\"permanentAddress\":\"'" + permanentAddress + "\",\"correspondingAddress\":\"'" + correspondingAddress + "\",\"guardiansName\":\"'" + guardiansName + "\",\"registrationDate\":\"'" + registrationDate + "\",\"approved\":\"'" + approved + "\"}";
    }
}
