package net.autorisiert.eventservice.model;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;


public class EventDto {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
