package com.gabriel.agenda.agnedainterface.views;

import com.gabriel.agenda.agnedainterface.utils.StageUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InitView {
    private StageUtils stageUtils = new StageUtils();
    @FXML
    private Button JInitButton;

    @FXML
    public void initialize(){
        JInitButton.setOnAction(event -> {
            try {
                stageUtils.renderStage(InitView.class, event, "/com/gabriel/agenda/agnedainterface/layout/select_db_layout.fxml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }
}
