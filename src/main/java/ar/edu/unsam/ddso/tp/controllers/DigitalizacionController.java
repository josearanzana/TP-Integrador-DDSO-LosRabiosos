package ar.edu.unsam.ddso.tp.controllers;

import ar.edu.unsam.ddso.tp.models.Digitalizacion;
import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.services.DigitalizacionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piezas")
public class DigitalizacionController {

    private final DigitalizacionService digitalizacionService;

    public DigitalizacionController(DigitalizacionService digitalizacionService) {
        this.digitalizacionService = digitalizacionService;
    }

    @PostMapping("/{piezaId}/digitalizaciones")
    public Digitalizacion crearDigitalizacion(
            @PathVariable Long piezaId, @RequestBody Digitalizacion digitalizacion) {
        return digitalizacionService.crear(piezaId, digitalizacion);
    }

    @PostMapping("/digitalizaciones/{digitalizacionId}/tags/{tagId}")
    public Digitalizacion agregarTag(
            @PathVariable Long digitalizacionId, @PathVariable Long tagId) {
        return digitalizacionService.agregarTag(digitalizacionId, tagId);
    }

    @GetMapping("/digitalizaciones/buscar")
    public List<Digitalizacion> buscarPorTag(@RequestParam String tag) {
        return digitalizacionService.buscarPorTag(tag);
    }

    @GetMapping("/buscarPiezasPorTag")
    public List<Pieza> buscarPiezasPorTag(@RequestParam String tag) {
        return digitalizacionService.buscarPiezasPorTag(tag);
    }

    @GetMapping("/digitalizaciones")
    public List<Digitalizacion> obtenerDigitalizaciones() {
        return digitalizacionService.obtenerTodas();
    }
}