package ar.edu.unsam.ddso.tp.services;

import ar.edu.unsam.ddso.tp.exception.ResourceNotFoundException;
import ar.edu.unsam.ddso.tp.models.Digitalizacion;
import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.models.Tag;
import ar.edu.unsam.ddso.tp.repositories.DigitalizacionRepository;
import ar.edu.unsam.ddso.tp.repositories.PiezaRepository;
import ar.edu.unsam.ddso.tp.repositories.TagRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DigitalizacionService {

    private final DigitalizacionRepository digitalizacionRepository;
    private final PiezaRepository piezaRepository;
    private final TagRepository tagRepository;

    public DigitalizacionService(
            DigitalizacionRepository digitalizacionRepository,
            PiezaRepository piezaRepository,
            TagRepository tagRepository) {
        this.digitalizacionRepository = digitalizacionRepository;
        this.piezaRepository = piezaRepository;
        this.tagRepository = tagRepository;
    }

    // ---------- Operaciones ----------

    @Transactional
    public Digitalizacion crear(Long piezaId, Digitalizacion digitalizacion) {
        Pieza pieza = piezaRepository.findById(piezaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pieza no encontrada"));
        digitalizacion.setPieza(pieza);
        return digitalizacionRepository.save(digitalizacion);
    }

    @Transactional
    public Digitalizacion agregarTag(Long digitalizacionId, Long tagId) {
        Digitalizacion digitalizacion = buscarPorId(digitalizacionId);
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new ResourceNotFoundException("Tag no encontrado"));
        digitalizacion.agregarTag(tag);
        return digitalizacionRepository.save(digitalizacion);
    }

    // ---------- Consultas ----------

    public List<Digitalizacion> obtenerTodas() {
        return digitalizacionRepository.findAll();
    }

    public List<Digitalizacion> buscarPorTag(String tag) {
        return digitalizacionRepository.findByTagsNombre(tag);
    }

    public List<Pieza> buscarPiezasPorTag(String nombreTag) {
        return digitalizacionRepository.findByTagsNombre(nombreTag).stream()
                .map(Digitalizacion::getPieza)
                .distinct()
                .toList();
    }

    // ---------- Privados ----------

    private Digitalizacion buscarPorId(Long id) {
        return digitalizacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Digitalizacion no encontrada"));
    }
}