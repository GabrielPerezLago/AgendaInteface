package com.gabriel.agenda.agnedainterface.components;

import com.gabriel.agenda.agnedainterface.utils.StageUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class ErrorScreen extends VBox {
    private final StageUtils utils = new StageUtils();
    public ErrorScreen(Runnable event) {
        ImageView image = utils.renderizeImageView("/com/gabriel/agenda/agnedainterface/assets/images/err_conexion.png", 300);
        Label fcfLbl = new Label("Error 404");
        fcfLbl.getStyleClass().addAll("h1", "white");
        Label errMsgLbl = new Label("No se a podigo conectar");
        errMsgLbl.getStyleClass().addAll("h2",  "white");

        Button reloadBtn = new Button("Reintentar");
        reloadBtn.getStyleClass().addAll("df_button", "white");
        reloadBtn.setOnAction(e -> {
            event.run();
        });

        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        VBox.setVgrow(this, Priority.ALWAYS);
        this.getChildren().addAll(image,fcfLbl,errMsgLbl, reloadBtn);

    }



}
