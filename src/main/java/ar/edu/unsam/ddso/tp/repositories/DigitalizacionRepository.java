package ar.edu.unsam.ddso.tp.repositories;

import ar.edu.unsam.ddso.tp.models.Digitalizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DigitalizacionRepository
        extends JpaRepository<Digitalizacion, Long> {
}