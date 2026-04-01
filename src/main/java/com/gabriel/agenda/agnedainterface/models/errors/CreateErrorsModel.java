package com.gabriel.agenda.agnedainterface.models.errors;

import org.apache.commons.lang3.ArrayUtils;

import java.sql.Array;

public class CreateErrorsModel {

    private String telefono = null;
    private String email = null;

    public CreateErrorsModel() {}

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String[] errArr = {};
        if(telefono!=null){
            errArr = ArrayUtils.add(errArr, getTelefono());
        }

        if (email!=null){
            errArr = ArrayUtils.add(errArr, getEmail());
        }

        return "Error: " + String.join(", ", errArr);
    }
}
