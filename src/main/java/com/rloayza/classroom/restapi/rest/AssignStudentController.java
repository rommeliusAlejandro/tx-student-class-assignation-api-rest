package com.rloayza.classroom.restapi.rest;

import com.rloayza.classroom.restapi.command.AssignStudentClassCmd;
import com.rloayza.classroom.restapi.framework.CommandFactory;
import com.rloayza.classroom.restapi.request.StudentClassRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/assignStudent"
)
public class AssignStudentController {

    @Autowired
    private CommandFactory commandFactory;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public void assignStudent(@RequestBody StudentClassRequest request) {
        AssignStudentClassCmd assignStudentClassCmd = (AssignStudentClassCmd) commandFactory.getCommand(AssignStudentClassCmd.class);
        assignStudentClassCmd.setClazzCode(request.getClassCode());
        assignStudentClassCmd.setStudentId(request.getStudentId());

        assignStudentClassCmd.execute();
    }
}
