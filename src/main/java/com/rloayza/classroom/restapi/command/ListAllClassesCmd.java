package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.ClassSpecification;
import com.rloayza.classroom.restapi.framework.ListsAbstractCommand;
import com.rloayza.classroom.restapi.framework.SearchCriteria;
import com.rloayza.classroom.restapi.framework.StudentSpecification;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.repository.ClassRepository;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestScope
public class ListAllClassesCmd extends ListsAbstractCommand {

    @Autowired
    private ClassRepository classRepository;

    private List<Clazz> clazzes;

    @Override
    public void execute() {

        if(null != getSearch()) {
            String[] searchQuery = getSearch().split(":");
            SearchCriteria searchCriteria = new SearchCriteria(searchQuery[0], searchQuery[1]);
            ClassSpecification classSpecification = new ClassSpecification();
            classSpecification.setCriteria(searchCriteria);
            clazzes = classRepository.findAll(classSpecification);
            return;
        }

        clazzes = classRepository.findAll(getPageable())
                .getContent();
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
}
