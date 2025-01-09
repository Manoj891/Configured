package com.model.setup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_master")
public class ClassMaster implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String name;
    @Column(name = "level")
    private String level;
    @Column(name = "degree_name")
    private String degreeName;
    public ClassMaster() {
    }

    public ClassMaster(Long id) {
        this.id = id;
    }

    public ClassMaster(String id) {
        this.id = Long.parseLong(id);
    }

    public ClassMaster(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"name\": \"" + name + "\"}";
    }
}
