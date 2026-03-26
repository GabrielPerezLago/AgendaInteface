package com.gabriel.agenda.agnedainterface;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ScreenController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image icon = new Image(getClass().getResource("/com/gabriel/agenda/agnedainterface/assets/icons/icon.png").toString());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/gabriel/agenda/agnedainterface/layout/init_layout.fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1366, 768);
        scene.getStylesheets().addAll(
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/app_fonts.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/border_radius.css").toExternalForm(),
                getClass().getResource("/com/gabriel/agenda/agnedainterface/css/button_style.css").toExternalForm()
        );
        System.out.println( getClass().getResource("/com/gabriel/agenda/agnedainterface/css/border_radius.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Agneda Interface");
        primaryStage.getIcons().add(icon);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
