package com.rloayza.classroom.restapi.request;

import java.util.UUID;

public class StudentClassRequest {

    private UUID classCode;

    private Integer studentId;

    public UUID getClassCode() {
        return classCode;
    }

    public void setClassCode(UUID classCode) {
        this.classCode = classCode;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
