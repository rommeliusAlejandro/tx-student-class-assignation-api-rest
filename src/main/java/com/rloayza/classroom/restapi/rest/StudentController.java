package com.rloayza.classroom.restapi.rest;

import com.rloayza.classroom.restapi.command.*;
import com.rloayza.classroom.restapi.exceptions.APIException;
import com.rloayza.classroom.restapi.framework.CommandFactory;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/{id}"
    )
    public void update(@RequestBody StudentRequest studentRequest, @PathVariable Integer id) {

        UpdateStudentCmd updateStudentCmd = (UpdateStudentCmd) commandFactory.getCommand(UpdateStudentCmd.class);
        updateStudentCmd.setStudentId(id);
        updateStudentCmd.setStudentRequest(studentRequest);

        try {
            updateStudentCmd.execute();
        } catch (APIException e) {
            //TODO: Handle properly the error
            e.printStackTrace();
        }
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public void delete(@PathVariable Integer id) {

        DeleteStudentCmd deleteStudentCmd = (DeleteStudentCmd) commandFactory.getCommand(DeleteStudentCmd.class);
        deleteStudentCmd.setStudentId(id);
        deleteStudentCmd.execute();
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<Student> getAll(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                @RequestParam(required = false) Integer pageSize,
                                @RequestParam(required = false) String search) {

        ListAllStudentsCmd listAllStudentsCmd = (ListAllStudentsCmd) commandFactory.getCommand(ListAllStudentsCmd.class);

        listAllStudentsCmd.setPageNumber(pageNumber);
        listAllStudentsCmd.setPageSize(pageSize);
        listAllStudentsCmd.setSearch(search);
        listAllStudentsCmd.execute();

        return listAllStudentsCmd.getStudents();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{studentId}/classes"
    )
    public List<Clazz> getAllUserClasses(@PathVariable Integer studentId) {
        ListAllUserClassesCmd listAllUserClassesCmd = (ListAllUserClassesCmd) commandFactory.getCommand(ListAllUserClassesCmd.class);
        listAllUserClassesCmd.setStudentId(studentId);
        listAllUserClassesCmd.execute();

        return listAllUserClassesCmd.getClazzes();

    }



}
