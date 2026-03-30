package com.gabriel.agenda.agnedainterface;

import com.gabriel.agenda.agnedainterface.models.Contacto;
import com.gabriel.agenda.agnedainterface.services.MongoConnService;
import com.gabriel.agenda.agnedainterface.services.MySqlConnService;
import javafx.util.Pair;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        try {
            Contacto c = new Contacto("test", "test test", "test@example.com", "+34000000000", "test, test, test, test, test");


            MongoConnService mongoService = new MongoConnService();
            MySqlConnService mySqlService = new MySqlConnService();

            //Crear
            System.out.println(mongoService.createContactos(c));
            System.out.println(mySqlService.createContactos(c));

            List<Contacto> contactos = mongoService.getContactos();
            List<Contacto> contactosSql = mySqlService.getContactos();
            for (Contacto contacto : contactos) {
                if (contacto.getNombre().equals("test")) {
                    System.out.println(contacto.toString());
                    Pair<String, String> tlf = new Pair<>("telefono", contacto.getTelefono());
                    System.out.println(mongoService.deleteContactos(tlf));
                }
                System.out.println(contacto.toString());
            }

            for (Contacto contacto : contactosSql) {
                if (contacto.getNombre().equals("test")) {
                    System.out.println(contacto.toString());
                    Pair<String, String> tlf = new Pair<>("telefono", contacto.getTelefono());
                    System.out.println(mySqlService.deleteContactos(tlf));
                }
                System.out.println(contacto.toString());
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
