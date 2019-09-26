package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@RequestScope
public class FindClassCmd implements Command {

    @Autowired
    private ClassRepository classRepository;

    private UUID code;

    private Clazz clazz;

    @Override
    public void execute() {
        clazz = classRepository.findById(code).get();
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setCode(UUID code) {
        this.code = code;
    }
}
