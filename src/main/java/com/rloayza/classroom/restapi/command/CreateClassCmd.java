package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.repository.ClassRepository;
import com.rloayza.classroom.restapi.request.ClassRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RequestScope
public class CreateClassCmd implements Command {

    @Autowired
    private ClassRepository classRepository;

    private ClassRequest classRequest;

    @Override
    public void execute() {
        Clazz clazz = new Clazz();
        clazz.setDescription(this.getClassRequest().getDescription());
        clazz.setTitle(this.getClassRequest().getTitle());

        classRepository.save(clazz);

        this.classRequest.setCode(clazz.getCode());
    }

    public ClassRequest getClassRequest() {
        return classRequest;
    }

    public void setClassRequest(ClassRequest classRequest) {
        this.classRequest = classRequest;
    }
}
