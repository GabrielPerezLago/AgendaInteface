package com.gabriel.agenda.agnedainterface.services.thread;

import com.gabriel.agenda.agnedainterface.instances.ContactosInstance;
import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.services.MongoConnService;
import com.gabriel.agenda.agnedainterface.services.interfaces.ThreadServiceImpl;

import java.util.List;
import java.util.function.Consumer;

public class MongoThreadService extends Thread implements ThreadServiceImpl {
    private List<Contacto> contactos;
    private ContactosInstance instance = ContactosInstance.getInstance();
    private MongoConnService service= new MongoConnService();

    private Consumer<List<Contacto>> callback;

    public MongoThreadService(Consumer<List<Contacto>> callback) {
        this.callback = callback;
    }


    @Override
    public void run() {
        try {
            if (!instance.getContactos().isEmpty()) {
                instance.cleanContactos();
            }

            contactos = instanceContactos();
            instance.setContactos(contactos);
            callback.accept(contactos);

        } catch (Exception ex) {
            ex.printStackTrace();
            callback.accept(null);
        }
    }


    @Override
    public List<Contacto> instanceContactos() throws Exception {
        List<Contacto> contact = service.getContactos();
        return contact;
    }
}
