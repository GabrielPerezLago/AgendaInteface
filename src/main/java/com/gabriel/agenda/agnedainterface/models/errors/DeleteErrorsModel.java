package com.gabriel.agenda.agnedainterface.models.errors;

import org.apache.commons.lang3.ArrayUtils;

public class DeleteErrorsModel {
    private String telefono;
    private String nombre;

    public DeleteErrorsModel() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        String[] str = {};
        if(getTelefono()!=null) str = ArrayUtils.add(str, getTelefono());
        if(getNombre()!=null) str = ArrayUtils.add(str, getNombre());

        return "Error: " + String.join(", ", str);

    }
}
