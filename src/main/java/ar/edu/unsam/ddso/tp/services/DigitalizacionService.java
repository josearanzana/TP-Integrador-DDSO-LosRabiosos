package ar.edu.unsam.ddso.tp.services;

import ar.edu.unsam.ddso.tp.models.Digitalizacion;
import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.repositories.DigitalizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigitalizacionService {

    private final DigitalizacionRepository digitalizacionRepository;

    public DigitalizacionService(
            DigitalizacionRepository digitalizacionRepository) {
        this.digitalizacionRepository = digitalizacionRepository;
    }

    public Digitalizacion guardar(
            Digitalizacion digitalizacion,
            Pieza pieza) {

        digitalizacion.setPieza(pieza);

        return digitalizacionRepository.save(digitalizacion);
    }

    public List<Digitalizacion> obtenerTodas() {
        return digitalizacionRepository.findAll();
    }
}