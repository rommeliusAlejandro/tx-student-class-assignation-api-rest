package com.rloayza.classroom.restapi.rest;

import com.rloayza.classroom.restapi.command.*;
import com.rloayza.classroom.restapi.framework.CommandFactory;
import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.request.ClassRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/{classCode}"
    )
    public void update(@RequestBody ClassRequest classRequest, @PathVariable UUID classCode) {
        UpdateClassCmd updateClassCmd = (UpdateClassCmd) commandFactory.getCommand(UpdateClassCmd.class);

        updateClassCmd.setClassCode(classCode);
        updateClassCmd.setClassRequest(classRequest);

        updateClassCmd.execute();
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{classCode}"
    )
    public void delete(@PathVariable UUID classCode) {

        DeleteClassCmd deleteClassCmd = (DeleteClassCmd) commandFactory.getCommand(DeleteClassCmd.class);
        deleteClassCmd.setClassCode(classCode);

        deleteClassCmd.execute();
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<Clazz> getAll(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                              @RequestParam(required = false) Integer pageSize,
                              @RequestParam(required = false) String search) {

        ListAllClassesCmd listAllClassesCmd = (ListAllClassesCmd) commandFactory.getCommand(ListAllClassesCmd.class);

        listAllClassesCmd.setPageNumber(pageNumber);
        listAllClassesCmd.setPageSize(pageSize);
        listAllClassesCmd.setSearch(search);
        listAllClassesCmd.execute();

        return listAllClassesCmd.getClazzes();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{classCode}/students"
    )
    public List<Student> getAllClassStudents(@PathVariable UUID classCode) {
        ListAllClassStudentsCmd listAllClassStudentsCmd = (ListAllClassStudentsCmd) commandFactory.getCommand(ListAllClassStudentsCmd.class);
        listAllClassStudentsCmd.setClassCode(classCode);
        listAllClassStudentsCmd.execute();

        return listAllClassStudentsCmd.getStudents();

    }
}
