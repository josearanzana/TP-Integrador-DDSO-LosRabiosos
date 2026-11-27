package ar.edu.unsam.ddso.tp.controllers;

import ar.edu.unsam.ddso.tp.models.Digitalizacion;
import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.services.DigitalizacionService;
import ar.edu.unsam.ddso.tp.services.PiezaService;
import org.springframework.web.bind.annotation.*;

import ar.edu.unsam.ddso.tp.models.Tag;
import ar.edu.unsam.ddso.tp.services.TagService;

import java.util.List;

@RestController
@RequestMapping("/piezas")
public class DigitalizacionController {

    private final DigitalizacionService digitalizacionService;
    private final PiezaService piezaService;
    private final TagService tagService;

    public DigitalizacionController(
            DigitalizacionService digitalizacionService,
            PiezaService piezaService,
            TagService tagService) {

        this.digitalizacionService = digitalizacionService;
        this.piezaService = piezaService;
        this.tagService = tagService;
    }

    @PostMapping("/{piezaId}/digitalizaciones")
    public Digitalizacion crearDigitalizacion(
            @PathVariable Long piezaId,
            @RequestBody Digitalizacion digitalizacion) {

        Pieza pieza = piezaService.buscarPorId(piezaId);

        return digitalizacionService.guardar(
                digitalizacion,
                pieza
        );
    }

    @PostMapping("/digitalizaciones/{digitalizacionId}/tags/{tagId}")
    public Digitalizacion agregarTag(
            @PathVariable Long digitalizacionId,
            @PathVariable Long tagId) {

        Tag tag = tagService.buscarPorId(tagId);

        return digitalizacionService.agregarTag(
                digitalizacionId,
                tag
        );
    }

    @GetMapping("/digitalizaciones/buscar")
    public List<Digitalizacion> buscarPorTag(
            @RequestParam String tag) {
        return digitalizacionService.buscarPorTag(tag);
    }

    @GetMapping("/buscarPiezasPorTag")
    public List<Pieza> buscarPiezasPorTag(
            @RequestParam String tag) {
        return digitalizacionService
                .buscarPiezasPorTag(tag);
    }

    @GetMapping("/digitalizaciones")
    public List<Digitalizacion> obtenerDigitalizaciones() {
        return digitalizacionService.obtenerTodas();
    }
}
