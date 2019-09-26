package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.repository.ClassRepository;
import com.rloayza.classroom.restapi.request.ClassRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@RequestScope
public class UpdateClassCmd implements Command {

    @Autowired
    private ClassRepository classRepository;

    private UUID classCode;

    private ClassRequest classRequest;

    @Override
    public void execute() {
        Clazz clazz = new Clazz();
        clazz.setDescription(this.getClassRequest().getDescription());
        clazz.setTitle(this.getClassRequest().getTitle());
        clazz.setCode(classCode);

        classRepository.save(clazz);
    }

    public UUID getClassCode() {
        return classCode;
    }

    public void setClassCode(UUID classCode) {
        this.classCode = classCode;
    }

    public ClassRequest getClassRequest() {
        return classRequest;
    }

    public void setClassRequest(ClassRequest classRequest) {
        this.classRequest = classRequest;
    }
}
