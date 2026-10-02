package com.elpoli.proteccion_amenazas.modelo;

public class Amenaza {
    private String tipo;
    private Integer nivelPeligro;

    public Amenaza(String tipo, Integer nivelPeligro) {
        this.tipo = tipo;
        this.nivelPeligro = nivelPeligro;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getNivelPeligro() {
        return nivelPeligro;
    }
}