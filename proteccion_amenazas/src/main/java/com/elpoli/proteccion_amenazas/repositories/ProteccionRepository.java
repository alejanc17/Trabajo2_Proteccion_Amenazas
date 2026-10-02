package com.elpoli.proteccion_amenazas.repositories;

import com.elpoli.proteccion_amenazas.modelo.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProteccionRepository {
    private List<InterfaceProteccion> listaObjetos = new ArrayList<>();

    public ProteccionRepository() {
        List<Amenaza> lista0 = Arrays.asList();
        List<Amenaza> lista1 = Arrays.asList(new Amenaza("Troyano", 50));
        List<Amenaza> lista2 = Arrays.asList(new Amenaza("DDoS", 80), new Amenaza("Phishing", 60));
        List<Amenaza> lista3 = Arrays.asList(new Amenaza("Malware", 70), new Amenaza("Ransomware", 95), new Amenaza("Spyware", 40));
        List<Amenaza> lista4 = Arrays.asList(new Amenaza("Gusano", 30), new Amenaza("Rootkit", 90), new Amenaza("Inyección SQL", 85), new Amenaza("XSS", 45));
        List<Amenaza> lista5 = Arrays.asList(new Amenaza("Botnet", 75), new Amenaza("Adware", 20), new Amenaza("Keylogger", 65), new Amenaza("Spoofing", 55), new Amenaza("Man-in-the-middle", 88));

        // Aquí creo los 12 objetos solicitados y enviando las listas por el constructor
        listaObjetos.add(new Guardia("Guardia Alfa", lista0));
        listaObjetos.add(new Guardia("Guardia Bravo", lista1));
        listaObjetos.add(new Guardia("Guardia Charlie", lista2));
        listaObjetos.add(new Guardia("Guardia Delta", lista3));

        listaObjetos.add(new Muro("Muro Norte", lista4));
        listaObjetos.add(new Muro("Muro Sur", lista5));
        listaObjetos.add(new Muro("Muro Este", lista0));
        listaObjetos.add(new Muro("Muro Oeste", lista1));

        listaObjetos.add(new Firewall("Firewall Principal", lista2));
        listaObjetos.add(new Firewall("Firewall Secundario", lista3));
        listaObjetos.add(new Firewall("Firewall DMZ", lista4));
        listaObjetos.add(new Firewall("Firewall VPN", lista5));

        // Se imprime en consola los 3 mensajes de los 3 métodos para cumplir el requerimiento de la Parte 4
        System.out.println("--- PRUEBA DE LOS 3 MÉTODOS HEREDADOS (Parte 4) ---");
        for (InterfaceProteccion obj : listaObjetos) {
            System.out.println("Objeto: " + obj.getNombre());
            System.out.println("1. " + obj.activarEscudo(obj.getListaAmenazas()));
            System.out.println("2. " + obj.repelerAmenaza(obj.getListaAmenazas()));
            System.out.println("3. " + obj.verificarSeguridad(obj.getListaAmenazas()));
            System.out.println("---------------------------------------------------");
        }
    }

    // Método para acceder a los 12 objetos desde el controlador
    public List<InterfaceProteccion> getTodos() {
        return listaObjetos;
    }
}