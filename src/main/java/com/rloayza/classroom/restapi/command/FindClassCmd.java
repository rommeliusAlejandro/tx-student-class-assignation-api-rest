package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.exceptions.APIException;
import com.rloayza.classroom.restapi.exceptions.EntityNotFoundException;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

@RequestScope
public class FindClassCmd implements Command {

    @Autowired
    private ClassRepository classRepository;

    private UUID code;

    private Clazz clazz;

    @Override
    public void execute() throws APIException {
        Optional<Clazz> optional = classRepository.findById(code);

        if(!optional.isPresent()) {
            throw new EntityNotFoundException("Class cant be found by code "+code);
        }
        clazz = optional.get();
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setCode(UUID code) {
        this.code = code;
    }
}
