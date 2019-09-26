package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.StudentClass;
import com.rloayza.classroom.restapi.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@RequestScope
public class FindStudentClassByClazzCodeCmd implements Command {

    @Autowired
    private StudentClassRepository studentClassRepository;

    private UUID clazzCode;

    private List<StudentClass> studentClass;

    @Override
    public void execute() {
        studentClass  = studentClassRepository.findByClazzCode(clazzCode);
    }

    public void setClazzCode(UUID clazzCode) {
        this.clazzCode = clazzCode;
    }

    public List<StudentClass> getStudentClass() {
        return studentClass;
    }
}
