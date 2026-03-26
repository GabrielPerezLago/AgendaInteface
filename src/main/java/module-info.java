module com.gabriel.agenda.agnedainterface {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.graphics;

    opens com.gabriel.agenda.agnedainterface to javafx.fxml;
    exports com.gabriel.agenda.agnedainterface;
    opens  com.gabriel.agenda.agnedainterface.views to javafx.fxml;
    exports  com.gabriel.agenda.agnedainterface.views;
    opens com.gabriel.agenda.agnedainterface.layout to javafx.fxml;

}