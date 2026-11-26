package ar.edu.unsam.ddso.tp.services;

import ar.edu.unsam.ddso.tp.models.*;
import ar.edu.unsam.ddso.tp.repositories.DigitalizacionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitalizacionServiceTest {

    @Test
    void agregaTagADigitalizacion() {

        DigitalizacionRepository repository = Mockito.mock(DigitalizacionRepository.class);

        DigitalizacionService service = new DigitalizacionService(repository);

        Digitalizacion digitalizacion =
                new Digitalizacion(
                        "https://archivo.com/foto.jpg",
                        "Foto histórica"
                );

        Tag tag = new Tag("Historia");

        Mockito.when(
                repository.findById(1L)
        ).thenReturn(Optional.of(digitalizacion));

        Mockito.when(
                repository.save(Mockito.any())
        ).thenAnswer(invocation -> invocation.getArgument(0));

        Digitalizacion resultado = service.agregarTag(1L, tag);

        assertEquals(
                1,
                resultado.getTags().size()
        );
    }
}