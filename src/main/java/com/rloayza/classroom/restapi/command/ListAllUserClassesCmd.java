package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.ListsAbstractCommand;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestScope
public class ListAllUserClassesCmd extends ListsAbstractCommand {

    @Autowired
    private StudentClassRepository studentClassRepository;

    private List<Clazz> clazzes;

    private Integer studentId;

    @Override
    public void execute() {

        clazzes = studentClassRepository.findStudentClasses(studentId);
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
