package ar.edu.unsam.ddso.tp.repositories;

import ar.edu.unsam.ddso.tp.models.Pieza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PiezaRepository extends JpaRepository<Pieza, Long> {

    List<Pieza> findByNombreContainingIgnoreCase(String nombre);

    List<Pieza> findByDescripcionContainingIgnoreCase(String descripcion);

    List<Pieza> findByFechaAlta(LocalDate fechaAlta);
}