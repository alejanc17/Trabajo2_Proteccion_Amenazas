package com.elpoli.proteccion_amenazas.modelo;

import java.util.List;

public class Guardia implements InterfaceProteccion {
    private String nombre;
    private List<Amenaza> amenazas;

    public Guardia(String nombre, List<Amenaza> amenazas) {
        this.nombre = nombre;
        this.amenazas = amenazas;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public List<Amenaza> getListaAmenazas() {
        return this.amenazas;
    }

    @Override
    public String activarEscudo(List<Amenaza> amenazas) {
        return "El Guardia " + nombre + " activó su escudo táctico. Amenazas bloqueadas: " + amenazas.size();
    }

    @Override
    public String repelerAmenaza(List<Amenaza> amenazas) {
        return "El Guardia " + nombre + " repelió a los atacantes físicamente.";
    }

    @Override
    public String verificarSeguridad(List<Amenaza> amenazas) {
        return "El Guardia " + nombre + " terminó su patrulla. Sector seguro.";
    }
}