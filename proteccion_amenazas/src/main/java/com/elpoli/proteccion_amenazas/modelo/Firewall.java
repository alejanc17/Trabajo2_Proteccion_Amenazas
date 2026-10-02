package com.elpoli.proteccion_amenazas.modelo;

import java.util.List;

public class Firewall implements InterfaceProteccion {
    private String nombre;
    private List<Amenaza> amenazas;

    public Firewall(String nombre, List<Amenaza> amenazas) {
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
        return "El Firewall " + nombre + " bloqueó todos los puertos vulnerables de la red.";
    }

    @Override
    public String repelerAmenaza(List<Amenaza> amenazas) {
        return "El Firewall " + nombre + " bloqueó " + amenazas.size() + " IPs sospechosas.";
    }

    @Override
    public String verificarSeguridad(List<Amenaza> amenazas) {
        return "El Firewall " + nombre + " finalizó el escaneo de paquetes de datos exitosamente.";
    }
}