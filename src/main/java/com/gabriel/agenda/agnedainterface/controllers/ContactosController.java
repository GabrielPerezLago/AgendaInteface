package com.gabriel.agenda.agnedainterface.controllers;

import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.services.MongoConnService;
import com.gabriel.agenda.agnedainterface.services.MySqlConnService;
import com.gabriel.agenda.agnedainterface.services.interfaces.DataServiceImpl;
import com.gabriel.agenda.agnedainterface.utils.DataUtils;
import javafx.util.Pair;

public class ContactosController {
    private DataServiceImpl dataService;
    private static DataUtils utils = new DataUtils();

    public String createContacto(String service, Contacto contacto) throws Exception {
        initialiceService(service);
        String created = dataService.createContactos(contacto);
        return created;
    }

    public String deleteContacto(String service, String param) throws Exception {
        initialiceService(service);
        Pair<String, String> data;
        if (param.contains("+")) {
            utils.cleanWhite(param);
            data = new Pair<String, String>("telefono",  param);
        } else {
            data = new Pair<String, String>("nombre",  param);
        }

        String del = dataService.deleteContactos(data);
        return del;
    }

    private void initialiceService(String service) {
        if (service.equals("mongo")) {
            dataService = new MongoConnService();
        } else {
            dataService = new MySqlConnService();
        }
    }
}
