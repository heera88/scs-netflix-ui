package com.rdmstudios.webui.scsnetflixui;

import com.rdmstudios.webui.scsnetflixui.domain.Fortune;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

@Route(value = "ui")
@Theme(Lumo.class)
public class AppUI extends VerticalLayout {
    private final ScsNetflixUiApplication.FortuneClient client;
    final Grid<Fortune> grid;

    @Autowired
    public AppUI(ScsNetflixUiApplication.FortuneClient client) {
        this.client = client;
        this.grid = new Grid(Fortune.class);
        add(grid);
        getFortunes();
    }

    private void getFortunes() {
        Collection<Fortune> collection = new ArrayList<>();
        client.getFortunes().forEach(collection::add);
        grid.setItems(collection);
    }
}