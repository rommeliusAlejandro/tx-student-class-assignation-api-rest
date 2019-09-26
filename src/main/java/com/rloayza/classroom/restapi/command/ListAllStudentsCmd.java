package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.ListsAbstractCommand;
import com.rloayza.classroom.restapi.framework.SearchCriteria;
import com.rloayza.classroom.restapi.framework.StudentSpecification;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestScope
public class ListAllStudentsCmd extends ListsAbstractCommand {

    @Autowired
    private StudentRepository studentRepository;

    private List<Student> students;

    @Override
    public void execute() {

        if(null != getSearch()) {
            String[] searchQuery = getSearch().split(":");
            SearchCriteria searchCriteria = new SearchCriteria(searchQuery[0], searchQuery[1]);
            StudentSpecification studentSpecification = new StudentSpecification();
            studentSpecification.setCriteria(searchCriteria);
            students = studentRepository.findAll(studentSpecification);
            return;
        }

        students = studentRepository.findAll(getPageable())
                .getContent();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
