package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.model.StudentClass;
import com.rloayza.classroom.restapi.repository.StudentClassRepository;
import com.rloayza.classroom.restapi.request.StudentClassRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RequestScope
public class CreateStudentClassCmd implements Command {

    @Autowired
    private StudentClassRepository repository;

    private Student student;

    private Clazz clazz;

    @Override
    public void execute() {
        StudentClass studentClass = new StudentClass();
        studentClass.setStudent(getStudent());
        studentClass.setClazz(getClazz());

        repository.save(studentClass);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
