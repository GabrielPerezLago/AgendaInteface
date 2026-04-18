package com.gabriel.agenda.agnedainterface.components;

import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.utils.StageUtils;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ContactoCard extends HBox {
    private final StageUtils utils = new StageUtils();

    public ContactoCard(Contacto contacto) {
        VBox imageContainer = new VBox();
        imageContainer.getChildren().addAll(utils.renderizeImageView("/com/gabriel/agenda/agnedainterface/assets/images/user.png", 200));
        imageContainer.setAlignment(Pos.CENTER);
        VBox.getVgrow(imageContainer);

        // Creacion del padre de los datos de los usuarios
        VBox dataContainer = new VBox();


        HBox nombreContainer = new HBox();
        nombreContainer.setAlignment(Pos.CENTER);
        nombreContainer.setSpacing(20);

        HBox dataContactosContainer = new HBox();
        dataContactosContainer.setAlignment(Pos.CENTER);
        dataContactosContainer.setSpacing(20);

        // Datos de nombre del contacto
        Label nombre = new Label(contacto.getNombre().toUpperCase());
        nombreContainer.getChildren().add(nombre);

        if (contacto.getApellidos() != null) {
            Label apellido = new Label(contacto.getApellidos().toUpperCase());
            nombreContainer.getChildren().add(apellido);
        }

        // Daros de contacto del contacto
        Label email = new Label(contacto.getEmail());
        dataContactosContainer.getChildren().add(email);

        Label telefono = new Label(contacto.getTelefono());
        dataContactosContainer.getChildren().add(telefono);

        if (!this.noText(contacto.getDireccion())) {
            Label direccion = new Label(contacto.getDireccion());
            dataContactosContainer.getChildren().add(direccion);
        }

        this.setChildrenColor(dataContactosContainer, Color.BLACK);
        this.setChildrenColor(nombreContainer, Color.BLACK, 22);

        dataContainer.setSpacing(10);
        dataContainer.setAlignment(Pos.CENTER);
        dataContainer.setSpacing(30);
        dataContainer.getChildren().addAll(nombreContainer, dataContactosContainer);
        minWidth(200);

        VBox.getVgrow(dataContainer);
        HBox.setHgrow(dataContainer, Priority.ALWAYS);



        setSpacing(50);
        getStyleClass().addAll("card" , "border_radius");
        getChildren().addAll(imageContainer, dataContainer);
    }

    private void setChildrenColor(Node father, Color clr, int fontSize) {
        if (father instanceof VBox || father instanceof HBox) {
            for (Node lbl : ((javafx.scene.layout.Pane) father).getChildren()) {
                if (lbl instanceof Label) {
                    ((Label) lbl).setTextFill(clr);
                    ((Label) lbl).setStyle("-fx-font-size: " + fontSize + "px;");
                }
            }
        }
    }

    private void setChildrenColor(Node father, Color clr) {
        if (father instanceof VBox || father instanceof HBox) {
            for (Node lbl : ((javafx.scene.layout.Pane) father).getChildren()) {
                if (lbl instanceof Label) {
                    ((Label) lbl).setTextFill(clr);
                    ((Label) lbl).setStyle("-fx-font-size: 18px");
                }
            }
        }
    }


    private boolean noText(String text) {
        if (text == null) return true;
        return text.replace(",", "").trim().isEmpty();
    }
}
