package com.rloayza.classroom.restapi.request;

import java.util.UUID;

public class ClassRequest {

    private UUID code;

    private String title;

    private String description;


    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
