package com.gabriel.agenda.agnedainterface.models.errors;

public class DeleteErrorsModel {
    private String telefono;
    private String email;

    public DeleteErrorsModel() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
