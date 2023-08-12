package com.model.utility;

import javax.persistence.*;

import com.model.student.StudentInfo;
import lombok.*;

@Data
@Entity
@Table(name = "notes")
public class Notes implements java.io.Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;

    @Column(name = "student_id")
    private Long studentId;
    @Setter(lombok.AccessLevel.NONE)
    @Getter(lombok.AccessLevel.NONE)
    @JoinColumn(name = "student_id", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StudentInfo studentInfo;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created;

    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updated;

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"title\": \"" + title + "\",\"body\": \"" + body + "\",\"created\": \"" + created + "\"}";
    }
}