package ar.edu.unsam.ddso.tp.services;

import ar.edu.unsam.ddso.tp.models.Tag;
import ar.edu.unsam.ddso.tp.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag guardar(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> obtenerTodos() {
        return tagRepository.findAll();
    }

    public Tag buscarPorId(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag no encontrado"));
    }
}