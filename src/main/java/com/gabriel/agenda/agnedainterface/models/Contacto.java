package com.gabriel.agenda.agnedainterface.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contacto {
    @JsonProperty("_id")
    String id = null;
    String nombre = null;
    String apellidos = null;
    String email = null;
    String telefono = null;
    String direccion = null;

    public Contacto(){}
    public Contacto( String nombre, String apellidos, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", Apellidos: " + getApellidos() + ", Email: " + getEmail() + ", Telefono: " + getTelefono() + ", Direccion: " + getDireccion();
    }
}
