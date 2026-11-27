package ar.edu.unsam.ddso.tp.services;

import ar.edu.unsam.ddso.tp.models.*;
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

    public Digitalizacion buscarPorId(Long id) {
        return digitalizacionRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Digitalizacion no encontrada"));
    }

    public Digitalizacion agregarTag(
        Long digitalizacionId,
        Tag tag) {
        Digitalizacion digitalizacion =
                buscarPorId(digitalizacionId);
        digitalizacion.agregarTag(tag);
        return digitalizacionRepository.save(digitalizacion);
    }
    
    public List<Digitalizacion> buscarPorTag(String tag) {
        return digitalizacionRepository
                .findByTagsNombre(tag);
    }

    public List<Pieza> buscarPiezasPorTag(String nombreTag) {
        return digitalizacionRepository
                .findByTagsNombre(nombreTag)
                .stream()
                .map(Digitalizacion::getPieza)
                .distinct()
                .toList();
    }
}