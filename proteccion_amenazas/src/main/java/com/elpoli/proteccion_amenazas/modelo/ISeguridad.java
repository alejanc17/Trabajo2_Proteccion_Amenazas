package com.elpoli.proteccion_amenazas.modelo;

import java.util.List;

public interface ISeguridad {
    String verificarSeguridad(List<Amenaza> amenazas);
}