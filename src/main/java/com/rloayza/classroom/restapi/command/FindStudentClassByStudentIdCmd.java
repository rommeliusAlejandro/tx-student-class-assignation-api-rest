package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.StudentClass;
import com.rloayza.classroom.restapi.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestScope
public class FindStudentClassByStudentIdCmd implements Command {

    @Autowired
    private StudentClassRepository studentClassRepository;

    private Integer studentId;

    private List<StudentClass> studentClass;

    @Override
    public void execute() {
        studentClass  = studentClassRepository.findByStudentId(studentId);
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public List<StudentClass> getStudentClass() {
        return studentClass;
    }
}
