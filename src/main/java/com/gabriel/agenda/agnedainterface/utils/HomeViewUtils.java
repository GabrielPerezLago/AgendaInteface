package com.gabriel.agenda.agnedainterface.utils;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.util.List;

public class HomeViewUtils {
    public Boolean isEmtyFields(List<TextField> inputs) {
        for(TextField input: inputs) {
            if (input.getText().trim().length() == 0) {
                return true;
            }
        }
        return false;
    }

    public PauseTransition toHiddeLabel(Label lbl) {
        PauseTransition pause = new PauseTransition(Duration.seconds(10));
        pause.setOnFinished(e -> {
            lbl.setText("");
            lbl.getStyleClass().removeAll("failed", "success");
        });
        return pause;
    }
}
