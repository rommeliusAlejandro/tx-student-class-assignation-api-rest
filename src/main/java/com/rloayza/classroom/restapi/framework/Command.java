package com.rloayza.classroom.restapi.framework;

import com.rloayza.classroom.restapi.exceptions.APIException;

public interface Command {

    void execute() throws APIException;
}
