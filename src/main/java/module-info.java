module com.gabriel.agenda.agnedainterface {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.graphics;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires javafx.base;

    opens com.gabriel.agenda.agnedainterface to javafx.fxml;
    exports com.gabriel.agenda.agnedainterface;
    opens  com.gabriel.agenda.agnedainterface.views to javafx.fxml;
    exports  com.gabriel.agenda.agnedainterface.views;
    opens com.gabriel.agenda.agnedainterface.layout to javafx.fxml;
    opens com.gabriel.agenda.agnedainterface.models to javafx.fxml;
    opens com.gabriel.agenda.agnedainterface.services to javafx.fxml;
    exports  com.gabriel.agenda.agnedainterface.models ;
    exports com.gabriel.agenda.agnedainterface.services;
    exports com.gabriel.agenda.agnedainterface.controllers;
    exports com.gabriel.agenda.agnedainterface.components;
    opens com.gabriel.agenda.agnedainterface.components to javafx.fxml;


}