package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
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
        findStudentCmd.setStudentId(studentId);
        findStudentCmd.execute();
        Student student = findStudentCmd.getStudent();

        findClassCmd.setCode(clazzCode);
        findClassCmd.execute();
        Clazz clazz = findClassCmd.getClazz();

        createStudentClassCmd.setClazz(clazz);
        createStudentClassCmd.setStudent(student);
        createStudentClassCmd.execute();
    }


    public void setClazzCode(UUID clazzCode) {
        this.clazzCode = clazzCode;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
