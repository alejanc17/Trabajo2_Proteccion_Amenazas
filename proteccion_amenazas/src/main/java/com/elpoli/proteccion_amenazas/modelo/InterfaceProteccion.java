package com.elpoli.proteccion_amenazas.modelo;

import java.util.List;

public interface InterfaceProteccion extends IEscudo, IRepeler, ISeguridad {
    // Para el Punto 1
    String getNombre();
    // Para el Punto 2
    List<Amenaza> getListaAmenazas();
}