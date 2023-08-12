package com.model.setup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "program_master")
public class ProgramMaster implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", unique = true, nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String name;

    public ProgramMaster() {
    }

    public ProgramMaster(Long id) {
        this.id = id;
    }

    public ProgramMaster(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProgramMaster(String id) {
        this.id = Long.parseLong(id);
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
