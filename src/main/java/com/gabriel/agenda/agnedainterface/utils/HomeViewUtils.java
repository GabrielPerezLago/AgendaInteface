package com.gabriel.agenda.agnedainterface.utils;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class HomeViewUtils {
    public void filterWhite(List<TextField> inputs, Label errorLbl) {
        for(TextField input: inputs) {
            if (input.getText().trim().length() == 0) {
                errorLbl.getStyleClass().add("failed");
                errorLbl.setText("Los parametros marcados con ' * ' no pueden estar vacios ");
            }
        }
    }
}
