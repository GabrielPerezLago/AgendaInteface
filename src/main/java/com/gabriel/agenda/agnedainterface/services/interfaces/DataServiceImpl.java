package com.gabriel.agenda.agnedainterface.services.interfaces;

import com.gabriel.agenda.agnedainterface.models.Contacto;
import javafx.util.Pair;

import java.util.List;

public interface DataServiceImpl {
    public abstract List<Contacto> getContactos() throws Exception;
    public abstract String createContactos(Contacto contacto) throws Exception;
    public abstract String deleteContactos(Pair<String, String> params) throws Exception;
}
