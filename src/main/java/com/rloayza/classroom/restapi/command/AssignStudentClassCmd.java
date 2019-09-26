package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@RequestScope
public class AssignStudentClassCmd implements Command {

    @Autowired
    private CreateStudentClassCmd createStudentClassCmd;

    @Autowired
    private FindStudentCmd findStudentCmd;

    @Autowired
    private FindClassCmd findClassCmd;

    private UUID clazzCode;

    private Integer studentId;

    @Override
    public void execute() {
        createStudentClassCmd.setClazzCode(clazzCode);
        createStudentClassCmd.setStudentId(studentId);
        createStudentClassCmd.execute();
    }


    public void setClazzCode(UUID clazzCode) {
        this.clazzCode = clazzCode;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
