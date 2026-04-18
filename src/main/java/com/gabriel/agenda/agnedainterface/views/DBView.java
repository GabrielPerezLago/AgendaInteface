package com.gabriel.agenda.agnedainterface.views;

import com.gabriel.agenda.agnedainterface.instances.AgendaInstance;
import com.gabriel.agenda.agnedainterface.utils.StageUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DBView {
    private static final StageUtils STAGE_UTILS = new StageUtils();
    private AgendaInstance inst = AgendaInstance.getInstance();
    private StageUtils sUtils = new StageUtils();


    @FXML
    private Button JButtonMongo;

    @FXML
    private Button JButtonMysql;


    @FXML
    public void initialize(){
        setEvent(JButtonMongo, "mongo");
        setEvent(JButtonMysql, "mysql");

        JButtonMongo.setGraphic(STAGE_UTILS.renderizeImageView("/com/gabriel/agenda/agnedainterface/assets/images/mongo.png", 50));
        JButtonMysql.setGraphic(STAGE_UTILS.renderizeImageView("/com/gabriel/agenda/agnedainterface/assets/images/mysql.png", 40));
    }

    private void setEvent(Button btn, String db){
        btn.setOnAction(event -> {
            try {
                inst.setDbSelect(db);
                sUtils.renderStage(DBView.class, event, "/com/gabriel/agenda/agnedainterface/layout/home_layout.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
