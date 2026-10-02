package com.elpoli.proteccion_amenazas.controlador;

import com.elpoli.proteccion_amenazas.modelo.Amenaza;
import com.elpoli.proteccion_amenazas.modelo.InterfaceProteccion;
import com.elpoli.proteccion_amenazas.repositories.ProteccionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PeticionesController {

    private final ProteccionRepository repository;

    // Inyección de dependencias
    public PeticionesController(ProteccionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String menuPrincipal() {
        return "index";
    }

    // PUNTO 1: Mostrar los nombres de todas las clases concretas en una sola línea, separados por coma.
    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        String nombres = repository.getTodos().stream()
                .map(InterfaceProteccion::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("nombresStr", nombres);
        return "peticion1";
    }
    // PUNTO 2: Mostrar datos estadísticos (conteo, suma, promedio, min, max) del atributo de tipo lista.
    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        DoubleSummaryStatistics estadisticas = repository.getTodos().stream()
                .flatMap(obj -> obj.getListaAmenazas().stream())
                .mapToDouble(Amenaza::getNivelPeligro)
                .summaryStatistics();

        // Extraemos los valores uno por uno y los enviamos como números simples (100% seguro)
        model.addAttribute("conteo", estadisticas.getCount());
        model.addAttribute("suma", estadisticas.getSum());
        model.addAttribute("promedio", estadisticas.getAverage());
        model.addAttribute("minimo", estadisticas.getMin());
        model.addAttribute("maximo", estadisticas.getMax());

        return "peticion2";
    }
    // PUNTO 3: Obtener lista de todos los objetos, y sacar otra lista que muestre el atributo String.
    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<String> listaTiposString = repository.getTodos().stream()
                .flatMap(obj -> obj.getListaAmenazas().stream())
                .map(Amenaza::getTipo)
                .collect(Collectors.toList());

        model.addAttribute("tipos", listaTiposString);
        return "peticion3";
    }

    // PUNTO 4: Consultar con anyMatch() (2 veces) y noneMatch() (1 vez).
    @GetMapping("/peticion4")
    public String peticion4(Model model) {
        boolean hayPeligroCritico = repository.getTodos().stream()
                .flatMap(obj -> obj.getListaAmenazas().stream())
                .anyMatch(a -> a.getNivelPeligro() > 90);

        boolean hayTroyanos = repository.getTodos().stream()
                .flatMap(obj -> obj.getListaAmenazas().stream())
                .anyMatch(a -> a.getTipo().equalsIgnoreCase("Troyano"));

        boolean sinAmenazasBajas = repository.getTodos().stream()
                .flatMap(obj -> obj.getListaAmenazas().stream())
                .noneMatch(a -> a.getNivelPeligro() < 10);

        model.addAttribute("critico", hayPeligroCritico);
        model.addAttribute("troyano", hayTroyanos);
        model.addAttribute("sinBajas", sinAmenazasBajas);
        return "peticion4";
    }

    // PUNTO 5: Mostrar el objeto con el mayor valor del dato de tipo Integer.
    @GetMapping("/peticion5")
    public String peticion5(Model model) {
        Amenaza mayorPeligro = repository.getTodos().stream()
                .flatMap(obj -> obj.getListaAmenazas().stream())
                .max(Comparator.comparing(Amenaza::getNivelPeligro))
                .orElse(null);

        model.addAttribute("amenazaMayor", mayorPeligro);
        return "peticion5";
    }
}