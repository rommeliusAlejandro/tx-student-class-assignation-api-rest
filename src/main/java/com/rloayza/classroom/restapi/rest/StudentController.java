package com.rloayza.classroom.restapi.rest;

import com.rloayza.classroom.restapi.command.CreateStudentCmd;
import com.rloayza.classroom.restapi.command.DeleteStudentCmd;
import com.rloayza.classroom.restapi.command.ListAllStudentsCmd;
import com.rloayza.classroom.restapi.command.UpdateStudentCmd;
import com.rloayza.classroom.restapi.framework.CommandFactory;
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

        updateStudentCmd.execute();
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



}
