package ar.edu.unsam.ddso.tp.controllers;

import ar.edu.unsam.ddso.tp.models.Pieza;
import ar.edu.unsam.ddso.tp.models.Tag;
import ar.edu.unsam.ddso.tp.services.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public Tag crearTag(@RequestBody Tag tag) {
        return tagService.guardar(tag);
    }

    @GetMapping
    public List<Tag> obtenerTags() {
        return tagService.obtenerTodos();
    }
}