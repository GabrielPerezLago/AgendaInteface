package com.gabriel.agenda.agnedainterface.views;

import com.gabriel.agenda.agnedainterface.components.ContactoCard;
import com.gabriel.agenda.agnedainterface.components.ErrorScreen;
import com.gabriel.agenda.agnedainterface.controllers.ContactosController;
import com.gabriel.agenda.agnedainterface.instances.AgendaInstance;
import com.gabriel.agenda.agnedainterface.instances.ContactosInstance;
import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.services.thread.MongoThreadService;
import com.gabriel.agenda.agnedainterface.services.thread.MySqlThreadService;
import com.gabriel.agenda.agnedainterface.utils.HomeViewUtils;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;

public class HomeView {
    private AgendaInstance agendaInstance = AgendaInstance.getInstance();
    private ContactosInstance contactosInstance = ContactosInstance.getInstance();
    private List<Contacto> contactos;
    private ContactosController controller = new ContactosController();
    private HomeViewUtils utils = new HomeViewUtils();
    @FXML
    private Label JDBLabel;


    @FXML
    private ScrollPane ContactosContainer;


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
    @FXML
    private Label ErrLbl;
    //Buttons
    @FXML
    private Button CreateBtn;
    @FXML
    private Button DeleteBtn;


    //FIND

    @FXML
    private TextField FindTextField;
    @FXML
    private ScrollPane FindContainer;



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
            DeleteBtn.setOnAction(e -> {
                deleteContacto();
            });

            FindTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filterContactos(newValue);
            });

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
            ContactosContainer.setContent(contactosContainer);
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
            if (list == null) {
                ContactosContainer.setContent(new ErrorScreen(() -> {
                    renderContactosThread();
                }));
                return;
            }
            this.contactos = list;
            renderCardsContactos();
        });
    }

    // Create, Delete & FindByCriteria

    private void createContacto() {
        try {
            List<TextField> fileds = Arrays.asList(
                    NombreCreateTextField,
                    TlfCreateTextFiel,
                    EmailCreateTextField
            );
            if (utils.isEmtyFields(fileds)) {
                ErrorLbl.getStyleClass().add("failed");
                ErrorLbl.setText("Campos obligatorios '*' no pueden estar en blanco");
                PauseTransition pause = utils.toHiddeLabel(ErrorLbl);
                pause.play();
                return;
            }
            String[] direccionArr = {NumDireccion.getText(), CalleDireccion.getText(), LocalidadDireccion.getText(), ProvinciaDireccion.getText(), PaisDireccion.getText()};
            String direccion = String.join(", ", direccionArr);

            Contacto contacto = new Contacto(
                    NombreCreateTextField.getText(),
                    ApellidosCreateTextField.getText(),
                    EmailCreateTextField.getText(),
                    TlfCreateTextFiel.getText().replaceAll("\\s+", ""),
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

    private void deleteContacto() {
        try {
            List<TextField> fields = Arrays.asList( DeleteParamsTextField);
            if (utils.isEmtyFields(fields)) {
                ErrLbl.getStyleClass().add("failed");
                ErrLbl.setText("Dos parametros no pueden estar en blanco");
                PauseTransition pause = utils.toHiddeLabel(ErrLbl);
                pause.play();
                return;
            }
            String response = controller.deleteContacto(agendaInstance.getDbSelect(), DeleteParamsTextField.getText().toLowerCase());
            if (response.contains("Error")) {
                ErrLbl.getStyleClass().add("failed");
            } else {
                ErrLbl.getStyleClass().add("success");
            }
            ErrLbl.setText(response);
            renderContactosThread();
            clearDeleteFields();
        } catch(Exception ex) {
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

        PauseTransition pause = utils.toHiddeLabel(ErrorLbl);
        pause.play();
    }

    private void clearDeleteFields() {
        DeleteParamsTextField.clear();
        PauseTransition pause = utils.toHiddeLabel(ErrLbl);
        pause.play();
    }


    //Find

    private void filterContactos(String txt) {
        if (contactos == null) {
            return;
        }

        String filter = txt.toLowerCase().replaceAll("\\s+", "");

        VBox container = new VBox();
        container.setSpacing(10);
        container.setAlignment(Pos.CENTER);
        container.setFillWidth(true);
        container.setPadding(new Insets(10, 10, 10, 10));

        for (Contacto contacto : contactos) {
            String content = contacto.getNombre().toUpperCase();
            if(contacto.getApellidos() != null) content += contacto.getApellidos().toUpperCase();
            content += contacto.getEmail() + contacto.getTelefono();
            if(contacto.getDireccion() != null) content += contacto.getDireccion();

            if (content.contains(filter)) {
                container.getChildren().add(new ContactoCard(contacto));
            }
        }

        FindContainer.setContent(container);
    }

}
