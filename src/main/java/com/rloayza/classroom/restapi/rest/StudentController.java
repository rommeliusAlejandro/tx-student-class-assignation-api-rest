package com.rloayza.classroom.restapi.rest;

import com.rloayza.classroom.restapi.command.CreateStudentCmd;
import com.rloayza.classroom.restapi.framework.CommandFactory;
import com.rloayza.classroom.restapi.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/student"
)
public class StudentController {

    @Autowired
    private CommandFactory commandFactory;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public StudentRequest create(@RequestBody StudentRequest studentRequest) {

        CreateStudentCmd createStudentCmd = (CreateStudentCmd) commandFactory.getCommand(CreateStudentCmd.class);
        createStudentCmd.setStudentRequest(studentRequest);
        createStudentCmd.execute();

        return createStudentCmd.getStudentRequest();
    }

}
