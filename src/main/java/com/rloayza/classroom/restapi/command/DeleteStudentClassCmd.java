package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.model.StudentClass;
import com.rloayza.classroom.restapi.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RequestScope
public class DeleteStudentClassCmd implements Command {

    @Autowired
    private StudentClassRepository repository;

    private StudentClass studentClass;

    @Override
    public void execute() {

        repository.delete(studentClass);
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}
