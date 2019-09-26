package com.rloayza.classroom.restapi.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Class")
public class Clazz {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    @Column
    private String title;

    @Column
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
