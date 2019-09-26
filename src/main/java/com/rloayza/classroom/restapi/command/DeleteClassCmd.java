package com.rloayza.classroom.restapi.command;

import com.rloayza.classroom.restapi.config.RequestScope;
import com.rloayza.classroom.restapi.framework.Command;
import com.rloayza.classroom.restapi.model.StudentClass;
import com.rloayza.classroom.restapi.repository.ClassRepository;
import com.rloayza.classroom.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@RequestScope
public class DeleteClassCmd implements Command {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private FindStudentClassByClazzCodeCmd findStudentClassByClazzCodeCmd;

    @Autowired
    private DeleteStudentClassCmd deleteStudentClassCmd;

    private UUID classCode;


    @Override
    public void execute() {

        findStudentClassByClazzCodeCmd.setClazzCode(classCode);
        findStudentClassByClazzCodeCmd.execute();

        List<StudentClass> studentClass = findStudentClassByClazzCodeCmd.getStudentClass();

        studentClass.forEach(
                record -> {
                    deleteStudentClassCmd.setStudentClass(record);
                    deleteStudentClassCmd.execute();
                }
        );

        classRepository.deleteById(classCode);
    }

    public void setClassCode(UUID classCode) {
        this.classCode = classCode;
    }
}
