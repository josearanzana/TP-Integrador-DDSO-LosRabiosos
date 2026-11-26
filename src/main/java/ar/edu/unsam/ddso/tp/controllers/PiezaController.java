package ar.edu.unsam.ddso.tp.controllers;

import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.services.PiezaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piezas")
public class PiezaController {

    private final PiezaService piezaService;

    public PiezaController(PiezaService piezaService) {
        this.piezaService = piezaService;
    }

    @PostMapping
    public Pieza crearPieza(@RequestBody Pieza pieza) {
        return piezaService.guardar(pieza);
    }

    @GetMapping
    public List<Pieza> obtenerPiezas() {
        return piezaService.obtenerTodas();
    }

    @GetMapping("/buscar")
    public List<Pieza> buscarPorNombre(
            @RequestParam String nombre) {
        return piezaService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscarPorDescripcion")
    public List<Pieza> buscarPorDescripcion(
            @RequestParam String descripcion) {
        return piezaService.buscarPorDescripcion(descripcion);
    }

    @GetMapping("/buscarPorFecha")
    public List<Pieza> buscarPorFecha(
            @RequestParam String fecha) {
        return piezaService.buscarPorFecha(
                java.time.LocalDate.parse(fecha)
        );
    }
}