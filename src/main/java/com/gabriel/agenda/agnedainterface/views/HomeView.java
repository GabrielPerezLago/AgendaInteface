package com.gabriel.agenda.agnedainterface.views;

import com.gabriel.agenda.agnedainterface.services.AgendaInstance;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeView {
    private AgendaInstance instance = AgendaInstance.getInstance();
    @FXML
    private Label JDBLabel;
    @FXML
    public void initialize(){
        JDBLabel.setText(instance.getDbSelect().toUpperCase());
    }
}
