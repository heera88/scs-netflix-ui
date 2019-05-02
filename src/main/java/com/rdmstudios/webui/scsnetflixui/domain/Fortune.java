package com.rdmstudios.webui.scsnetflixui.domain;

import com.vaadin.flow.component.polymertemplate.Id;

public class Fortune {

    private Long id;

    private String text;

    protected Fortune() {}

    public Fortune(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }
}