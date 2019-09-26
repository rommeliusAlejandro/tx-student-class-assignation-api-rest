package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.StudentClass;
import com.rloayza.classroom.restapi.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@RequestScope
public class CreateStudentClassCmd implements Command {

    @Autowired
    private StudentClassRepository repository;

    private Integer studentId;

    private UUID clazzCode;

    @Override
    public void execute() {
        StudentClass studentClass = new StudentClass();
        studentClass.setStudentId(getStudentId());
        studentClass.setClassCode(getClazzCode());

        repository.save(studentClass);
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public UUID getClazzCode() {
        return clazzCode;
    }

    public void setClazzCode(UUID clazzCode) {
        this.clazzCode = clazzCode;
    }
}
