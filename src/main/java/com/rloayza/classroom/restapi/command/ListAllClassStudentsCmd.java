package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.ListsAbstractCommand;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@RequestScope
public class ListAllClassStudentsCmd extends ListsAbstractCommand {

    @Autowired
    private StudentClassRepository studentClassRepository;

    private List<Student> students;

    private UUID classCode;

    @Override
    public void execute() {

        students = studentClassRepository.findClassStudents(classCode);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public UUID getClassCode() {
        return classCode;
    }

    public void setClassCode(UUID classCode) {
        this.classCode = classCode;
    }
}
