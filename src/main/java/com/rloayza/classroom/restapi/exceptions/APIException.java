package com.rloayza.classroom.restapi.exceptions;

public class APIException extends Throwable {

    public APIException() {
    }

    public APIException(String s) {
        super(s);
    }

    public APIException(Throwable throwable) {
        super(throwable);
    }
}
