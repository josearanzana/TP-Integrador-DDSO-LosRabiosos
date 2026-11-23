package ar.edu.unsam.ddso.tp.repositories;

import ar.edu.unsam.ddso.tp.models.Pieza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PiezaRepository extends JpaRepository<Pieza, Long> {

    List<Pieza> findByNombreContainingIgnoreCase(String nombre);
}