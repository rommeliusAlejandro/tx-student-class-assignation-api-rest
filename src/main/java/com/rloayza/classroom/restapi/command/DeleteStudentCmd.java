package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.StudentClass;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequestScope
public class DeleteStudentCmd implements Command {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FindStudentClassByStudentIdCmd findStudentClassByStudentIdCmd;

    @Autowired
    private DeleteStudentClassCmd deleteStudentClassCmd;

    private Integer studentId;


    @Override
    public void execute() {

        findStudentClassByStudentIdCmd.setStudentId(studentId);
        findStudentClassByStudentIdCmd.execute();

        List<StudentClass> studentClass = findStudentClassByStudentIdCmd.getStudentClass();

        studentClass.forEach(
                record -> {
                    deleteStudentClassCmd.setStudentClass(record);
                    deleteStudentClassCmd.execute();
                }
        );

        studentRepository.deleteById(studentId);
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
