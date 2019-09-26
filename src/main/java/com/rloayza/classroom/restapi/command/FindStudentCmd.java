package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RequestScope
public class FindStudentCmd implements Command {

    @Autowired
    private StudentRepository studentRepository;

    private Integer studentId;

    private Student student;

    @Override
    public void execute() {
        student = studentRepository.findById(studentId).get();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
