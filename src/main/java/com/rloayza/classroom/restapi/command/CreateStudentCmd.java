package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import com.rloayza.classroom.restapi.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RequestScope
public class CreateStudentCmd implements Command {

    @Autowired
    private StudentRepository repository;

    private StudentRequest studentRequest;

    @Override
    public void execute() {
        Student student =  new Student();
        student.setFirstName(this.getStudentRequest().getFirstName());
        student.setLastName(this.getStudentRequest().getLastName());

        repository.save(student);

        this.studentRequest.setStudentId(student.getStudentId());
    }

    public void setStudentRequest(StudentRequest studentRequest) {
        this.studentRequest = studentRequest;
    }

    public StudentRequest getStudentRequest() {
        return studentRequest;
    }
}
