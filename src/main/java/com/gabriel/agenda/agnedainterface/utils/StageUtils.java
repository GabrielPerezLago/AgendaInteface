package com.gabriel.agenda.agnedainterface.utils;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageUtils {
    public void renderStage(Class<?> cls, Event event , String url) throws IOException {
        Parent root = FXMLLoader.load(cls.getResource(url));
        Scene scene = new Scene(root, 1366, 768);
        scene.getStylesheets().addAll(
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/app_fonts.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/border_radius.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/button_style.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/contacto_card.css").toExternalForm()
        );
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
