package com.gabriel.agenda.agnedainterface.services.interfaces;

import com.gabriel.agenda.agnedainterface.models.Contacto;

import java.util.List;

public interface ThreadServiceImpl {
    public abstract List<Contacto> instanceContactos() throws Exception;
}
