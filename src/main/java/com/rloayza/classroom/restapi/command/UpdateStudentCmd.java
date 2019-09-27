package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.exceptions.APIException;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import com.rloayza.classroom.restapi.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@RequestScope
public class UpdateStudentCmd implements Command {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FindStudentCmd findStudentCmd;

    private StudentRequest studentRequest;

    private Integer studentId;

    @Override
    public void execute() throws APIException {
        findStudentCmd.setStudentId(studentId);
        findStudentCmd.execute();
        Student student = findStudentCmd.getStudent();

        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setStudentId(getStudentId());
        student.setUpdatedOn(new Date());

        studentRepository.save(student);
    }

    public StudentRequest getStudentRequest() {
        return studentRequest;
    }

    public void setStudentRequest(StudentRequest studentRequest) {
        this.studentRequest = studentRequest;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
