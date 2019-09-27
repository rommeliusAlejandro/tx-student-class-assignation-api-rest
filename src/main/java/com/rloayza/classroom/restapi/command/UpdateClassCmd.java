package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.exceptions.APIException;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.repository.ClassRepository;
import com.rloayza.classroom.restapi.request.ClassRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

@RequestScope
public class UpdateClassCmd implements Command {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private FindClassCmd findClassCmd;

    private UUID classCode;

    private ClassRequest classRequest;

    @Override
    public void execute() throws APIException  {

        findClassCmd.setCode(classCode);
        findClassCmd.execute();

        Clazz clazz = findClassCmd.getClazz();
        clazz.setDescription(this.getClassRequest().getDescription());
        clazz.setTitle(this.getClassRequest().getTitle());
        clazz.setCode(classCode);
        clazz.setUpdatedOn(new Date());

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
