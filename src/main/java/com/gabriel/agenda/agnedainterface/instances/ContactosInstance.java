package com.gabriel.agenda.agnedainterface.instances;

import com.gabriel.agenda.agnedainterface.models.Contacto;

import java.util.List;

public class ContactosInstance {
    private static ContactosInstance instance;
    private List<Contacto> contactos;
    public static ContactosInstance getInstance() {
        if (instance == null) {
            instance = new ContactosInstance();
        }
        return instance;
    }

    public List<Contacto> getContactos() {
        if(contactos == null){
            return List.of();
        }
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void cleanContactos() {
        contactos.clear();
    }
}
