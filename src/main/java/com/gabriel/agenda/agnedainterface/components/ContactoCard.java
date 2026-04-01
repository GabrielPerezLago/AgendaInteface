package com.gabriel.agenda.agnedainterface.components;

import com.gabriel.agenda.agnedainterface.models.Contacto;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContactoCard extends VBox {

    public ContactoCard(Contacto contacto) {
        Label nombre = new Label(contacto.getNombre().toUpperCase());
        nombre.setTextFill(Color.WHITE);
        getChildren().add(nombre);

        if (contacto.getApellidos() != null) {
            Label apellido = new Label(contacto.getApellidos().toUpperCase());
            apellido.setTextFill(Color.WHITE);
            getChildren().add(apellido);
        }

        Label email = new Label(contacto.getEmail());
        email.setTextFill(Color.WHITE);
        getChildren().add(email);

        Label telefono = new Label(contacto.getTelefono());
        telefono.setTextFill(Color.WHITE);
        getChildren().add(telefono);

        if (contacto.getDireccion() != null) {
            Label direccion = new Label(contacto.getDireccion());
            direccion.setTextFill(Color.WHITE);
            getChildren().add(direccion);
        }
        setSpacing(5);
        getStyleClass().addAll("card" , "border_radius");

    }
}
