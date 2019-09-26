package com.rloayza.classroom.restapi.rest;

import com.rloayza.classroom.restapi.command.CreateClassCmd;
import com.rloayza.classroom.restapi.framework.CommandFactory;
import com.rloayza.classroom.restapi.request.ClassRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/class"
)
public class ClassController {

    @Autowired
    private CommandFactory commandFactory;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ClassRequest create(@RequestBody ClassRequest classRequest) {
        CreateClassCmd createClassCmd = (CreateClassCmd) commandFactory.getCommand(CreateClassCmd.class);

        createClassCmd.setClassRequest(classRequest);
        createClassCmd.execute();

        return createClassCmd.getClassRequest();
    }
}
