package com.rloayza.classroom.restapi.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "StudentClass")
public class StudentClass {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer studentId;

    @Column
    private UUID classCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public UUID getClassCode() {
        return classCode;
    }

    public void setClassCode(UUID classCode) {
        this.classCode = classCode;
    }
}
