package ar.edu.unsam.ddso.tp.controllers;

import ar.edu.unsam.ddso.tp.models.Digitalizacion;
import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.services.DigitalizacionService;
import ar.edu.unsam.ddso.tp.services.PiezaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/piezas")
public class DigitalizacionController {

    private final DigitalizacionService digitalizacionService;
    private final PiezaService piezaService;

    public DigitalizacionController(
            DigitalizacionService digitalizacionService,
            PiezaService piezaService) {

        this.digitalizacionService = digitalizacionService;
        this.piezaService = piezaService;
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
}
