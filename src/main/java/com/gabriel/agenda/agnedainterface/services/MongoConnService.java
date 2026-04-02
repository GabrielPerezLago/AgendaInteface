package com.gabriel.agenda.agnedainterface.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.models.NameDTO;
import com.gabriel.agenda.agnedainterface.models.TelefonoDTO;
import com.gabriel.agenda.agnedainterface.models.errors.CreateErrorsModel;
import com.gabriel.agenda.agnedainterface.models.errors.DeleteErrorsModel;
import com.gabriel.agenda.agnedainterface.services.interfaces.DataServiceImpl;
import com.gabriel.agenda.agnedainterface.utils.DataUtils;
import javafx.util.Pair;

import java.net.http.HttpResponse;
import java.util.List;

public class MongoConnService implements DataServiceImpl {
    private static final String URI = "http://localhost:3000/mongo";
    private static HTTPService service = new HTTPService();
    private ObjectMapper mapper = new ObjectMapper();
    private DataUtils utils = new DataUtils();


    @Override
    public List<Contacto> getContactos() throws Exception {
        HttpResponse<String> response = service.getContactos(URI);
        List<Contacto> contactos = mapper.readValue(response.body(), new TypeReference<List<Contacto>>(){});
        return contactos;
    }

    @Override
    public String createContactos(Contacto contacto) throws Exception {
        String json = mapper.writeValueAsString(contacto);
        HttpResponse<String> response = service.createContactos(URI, json);
        if(response.statusCode() == 201){
            return "Contacto creado correctamente";
        } else {
            CreateErrorsModel mdl = mapper.readValue(response.body(), CreateErrorsModel.class);
            return mdl.toString();
        }
    }

    @Override
    public String deleteContactos(Pair<String, String> params) throws Exception {
        Object obj = null;
        if (params.getKey().equals("telefono")) {
            System.out.println(utils.cleanWhite(params.getValue()));
            obj = new TelefonoDTO(utils.cleanWhite(params.getValue()));
        } else if (params.getKey().equals("nombre")) {
            obj = new NameDTO(params.getValue());
        }

        String json = mapper.writeValueAsString(obj);

        HttpResponse<String> response = service.deleteContactos(URI, json);

        if(response.statusCode() == 400) {
            DeleteErrorsModel data = mapper.readValue(response.body(), DeleteErrorsModel.class);
            return data.toString();
        } else {
            return "Contacto Eliminado corectamente";
        }
    }
}
