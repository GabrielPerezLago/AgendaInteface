package com.gabriel.agenda.agnedainterface.services.thread;

import com.gabriel.agenda.agnedainterface.instances.ContactosInstance;
import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.services.MySqlConnService;
import com.gabriel.agenda.agnedainterface.services.interfaces.ThreadServiceImpl;

import java.util.List;
import java.util.function.Consumer;

public class MySqlThreadService extends Thread implements ThreadServiceImpl {
    List<Contacto> contactos;
    private ContactosInstance instance = ContactosInstance.getInstance();
    private MySqlConnService service = new MySqlConnService();
    private Consumer<List<Contacto>> callback;

    public MySqlThreadService(Consumer<List<Contacto>> callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Contacto> instanceContactos() throws Exception {
        List<Contacto> contact = service.getContactos();
        return contact;
    }
}
