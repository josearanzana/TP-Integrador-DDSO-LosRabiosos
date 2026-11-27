package ar.edu.unsam.ddso.tp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import ar.edu.unsam.ddso.tp.exception.ResourceNotFoundException;
import ar.edu.unsam.ddso.tp.models.Digitalizacion;
import ar.edu.unsam.ddso.tp.models.Tag;
import ar.edu.unsam.ddso.tp.repositories.DigitalizacionRepository;
import ar.edu.unsam.ddso.tp.repositories.PiezaRepository;
import ar.edu.unsam.ddso.tp.repositories.TagRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DigitalizacionServiceTest {

    @Mock private DigitalizacionRepository digitalizacionRepository;
    @Mock private PiezaRepository piezaRepository;
    @Mock private TagRepository tagRepository;

    @Test
    void agregaTagADigitalizacion() {
 
        DigitalizacionService service =
                new DigitalizacionService(digitalizacionRepository, piezaRepository, tagRepository);
        Digitalizacion digitalizacion =
                new Digitalizacion("https://archivo.com/foto.jpg", "Foto histórica");
        when(digitalizacionRepository.findById(1L)).thenReturn(Optional.of(digitalizacion));
        when(tagRepository.findById(2L)).thenReturn(Optional.of(new Tag("Historia")));
        when(digitalizacionRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        Digitalizacion resultado = service.agregarTag(1L, 2L);

        assertEquals(1, resultado.getTags().size());
    }

    @Test
    void agregarTagFallaSiLaDigitalizacionNoExiste() {
        DigitalizacionService service =
                new DigitalizacionService(digitalizacionRepository, piezaRepository, tagRepository);
        when(digitalizacionRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.agregarTag(99L, 1L));
    }
}