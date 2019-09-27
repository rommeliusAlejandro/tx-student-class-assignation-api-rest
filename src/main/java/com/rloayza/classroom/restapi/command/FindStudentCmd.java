package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.exceptions.APIException;
import com.rloayza.classroom.restapi.exceptions.EntityNotFoundException;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RequestScope
public class FindStudentCmd implements Command {

    @Autowired
    private StudentRepository studentRepository;

    private Integer studentId;

    private Student student;

    @Override
    public void execute() throws APIException {
        Optional<Student> optional = studentRepository.findById(studentId);

        if(!optional.isPresent()) {
            throw new EntityNotFoundException("Student cant be found by studentId "+studentId);
        }

        student = optional.get();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
