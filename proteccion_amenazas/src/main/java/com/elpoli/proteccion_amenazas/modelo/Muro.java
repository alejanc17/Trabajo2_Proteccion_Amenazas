package com.elpoli.proteccion_amenazas.modelo;

import java.util.List;

public class Muro implements InterfaceProteccion {
    private String nombre;
    private List<Amenaza> amenazas;

    public Muro(String nombre, List<Amenaza> amenazas) {
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
        return "El Muro " + nombre + " desplegó barreras metálicas adicionales.";
    }

    @Override
    public String repelerAmenaza(List<Amenaza> amenazas) {
        return "El Muro " + nombre + " resistió el impacto frontal de " + amenazas.size() + " amenazas.";
    }

    @Override
    public String verificarSeguridad(List<Amenaza> amenazas) {
        return "El Muro " + nombre + " no presenta grietas ni daños en su estructura.";
    }
}