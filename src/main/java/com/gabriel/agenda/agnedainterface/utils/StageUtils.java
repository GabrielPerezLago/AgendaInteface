package com.gabriel.agenda.agnedainterface.utils;

import com.fasterxml.jackson.annotation.JsonMerge;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.bytebuddy.utility.nullability.NeverNull;

import java.io.IOException;

public class StageUtils {
    public void renderStage(Class<?> cls, Event event , String url) throws IOException {
        Parent root = FXMLLoader.load(cls.getResource(url));
        Scene scene = new Scene(root, 1366, 768);
        scene.getStylesheets().addAll(
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/app_fonts.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/border_radius.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/button_style.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/contacto_card.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/mini_text.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/tittles.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/colorts.css").toExternalForm()
        );
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public ImageView renderizeImageView(@NeverNull String url, double width) {
        Image image = new Image(getClass().getResourceAsStream(url), width, width, true, true);
        image.getWidth();
        return new ImageView(image);
    }
}
