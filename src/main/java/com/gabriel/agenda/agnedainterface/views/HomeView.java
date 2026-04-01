package com.gabriel.agenda.agnedainterface.views;

import com.gabriel.agenda.agnedainterface.components.ContactoCard;
import com.gabriel.agenda.agnedainterface.controllers.ContactosController;
import com.gabriel.agenda.agnedainterface.instances.AgendaInstance;
import com.gabriel.agenda.agnedainterface.instances.ContactosInstance;
import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.services.thread.MongoThreadService;
import com.gabriel.agenda.agnedainterface.services.thread.MySqlThreadService;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;

public class HomeView {
    private AgendaInstance agendaInstance = AgendaInstance.getInstance();
    private ContactosInstance contactosInstance = ContactosInstance.getInstance();
    private List<Contacto> contactos;
    private ContactosController controller = new ContactosController();


    @FXML
    private Label JDBLabel;

    @FXML
    private Tab contactosTab;


    //CREATE
    @FXML
    private TextField TlfCreateTextFiel;
    @FXML
    private TextField NombreCreateTextField;
    @FXML
    private TextField ApellidosCreateTextField;
    @FXML
    private TextField EmailCreateTextField;
    @FXML
    private TextField NumDireccion;
    @FXML
    private TextField CalleDireccion;
    @FXML
    private TextField LocalidadDireccion;
    @FXML
    private TextField ProvinciaDireccion;
    @FXML
    private TextField PaisDireccion;
    @FXML
    private Label ErrorLbl;

    //DELETE
    @FXML
    private TextField DeleteParamsTextField;

    //Buttons
    @FXML
    private Button CreateBtn;
    @FXML
    private Button DeleteBtn;

    @FXML
    public void initialize(){
        try {

            JDBLabel.setText(agendaInstance.getDbSelect().toUpperCase());

            if (agendaInstance.getDbSelect() != null && !agendaInstance.getDbSelect().isEmpty()) {
                renderContactosThread();
            }


            CreateBtn.setOnAction(e -> {
                createContacto();
            });
            DeleteBtn.setOnAction(e -> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void renderCardsContactos() {
        Platform.runLater(() -> {
            VBox contactosContainer = new VBox();
            contactosContainer.setSpacing(20);
            contactosContainer.setPadding(new Insets(20, 20, 20, 10));
            for (Contacto contacto : contactos) {
                contactosContainer.getChildren().add(new ContactoCard(contacto));
            }
            contactosTab.setContent(contactosContainer);
        });
    }



    //Rendering Data
    private void renderContactosThread() {
        Thread thread;
        if (agendaInstance.getDbSelect().equals("mongo")) {
            thread = new MongoThreadService(this::onContactosLoad);
        } else {
            thread = new MySqlThreadService(this::onContactosLoad);
        }
        thread.start();
    }

    private void onContactosLoad(List<Contacto> list){
        Platform.runLater(() -> {
            this.contactos = list;
            renderCardsContactos();
        });
    }


    private void createContacto() {
        try {
            String[] direccionArr = {NumDireccion.getText(), CalleDireccion.getText(), LocalidadDireccion.getText(), ProvinciaDireccion.getText(), PaisDireccion.getText()};
            String direccion = String.join(", ", direccionArr);

            Contacto contacto = new Contacto(
                    NombreCreateTextField.getText(),
                    ApellidosCreateTextField.getText(),
                    EmailCreateTextField.getText(),
                    TlfCreateTextFiel.getText(),
                    direccion
            );

            String txt = controller.createContacto(agendaInstance.getDbSelect(), contacto);
            if (txt.contains("Error")) {
                ErrorLbl.getStyleClass().add("failed");
            } else {
                ErrorLbl.getStyleClass().add("success");
            }
            ErrorLbl.setText(txt);
            renderContactosThread();
            clearCreateFields();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void clearCreateFields() {
        TlfCreateTextFiel.clear();
        NombreCreateTextField.clear();
        ApellidosCreateTextField.clear();
        EmailCreateTextField.clear();
        NumDireccion.clear();
        CalleDireccion.clear();
        LocalidadDireccion.clear();
        ProvinciaDireccion.clear();
        PaisDireccion.clear();

        PauseTransition pause = new PauseTransition(Duration.seconds(10));
        pause.setOnFinished(e -> {
            ErrorLbl.setText("");
            ErrorLbl.getStyleClass().removeAll("failed", "success");
        });
        pause.play();
    }
}
