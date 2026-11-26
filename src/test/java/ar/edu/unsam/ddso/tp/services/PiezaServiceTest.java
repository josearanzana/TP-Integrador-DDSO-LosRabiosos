package ar.edu.unsam.ddso.tp.services;

import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.repositories.PiezaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiezaServiceTest {

    @Test
    void buscaPiezasPorNombre() {

        PiezaRepository repository = Mockito.mock(PiezaRepository.class);

        PiezaService service = new PiezaService(repository);

        Pieza pieza = new Pieza("Diario La Nación", "Edición 1950");

        Mockito.when(
                repository.findByNombreContainingIgnoreCase("diario")
        ).thenReturn(List.of(pieza));

        List<Pieza> resultado = service.buscarPorNombre("diario");

        assertEquals(1, resultado.size());
        assertEquals(
                "Diario La Nación",
                resultado.get(0).getNombre()
        );
    }
}