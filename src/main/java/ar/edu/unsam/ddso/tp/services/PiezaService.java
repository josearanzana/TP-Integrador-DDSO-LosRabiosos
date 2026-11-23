package ar.edu.unsam.ddso.tp.services;

import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.repositories.PiezaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PiezaService {

    private final PiezaRepository piezaRepository;

    public PiezaService(PiezaRepository piezaRepository) {
        this.piezaRepository = piezaRepository;
    }

    public Pieza guardar(Pieza pieza) {
        return piezaRepository.save(pieza);
    }

    public List<Pieza> obtenerTodas() {
        return piezaRepository.findAll();
    }

    public Pieza buscarPorId(Long id) {
        return piezaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pieza no encontrada"));
    }

    public List<Pieza> buscarPorNombre(String nombre) {
        return piezaRepository
            .findByNombreContainingIgnoreCase(nombre);
    }

    public List<Pieza> buscarPorDescripcion(String descripcion) {
        return piezaRepository
            .findByDescripcionContainingIgnoreCase(descripcion);
    }

    public List<Pieza> buscarPorFecha(LocalDate fecha) {
        return piezaRepository.findByFechaAlta(fecha);
    }
    
}
