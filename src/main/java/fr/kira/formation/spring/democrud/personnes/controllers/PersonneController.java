package fr.kira.formation.spring.democrud.personnes.controllers;

import fr.kira.formation.spring.democrud.personnes.model.Personne;
import fr.kira.formation.spring.democrud.personnes.services.PersonneService;
import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService service;

    public PersonneController(PersonneService service) {
        this.service = service;
        log.trace("PersonneController TRACE");
        log.debug("PersonneController DEBUG");
        log.info("PersonneController INFO");
        log.warn("PersonneController WARN");
        log.error("PersonneController ERROR");
    }

    @Operation(description = "Retourne la liste des personnes dans un format minimal")
    @GetMapping("")
    public List<MinimalPersonneDTO> findAll() {
        return service.findAll();
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Personne save(@RequestBody Personne entity) {
        return service.save(entity);
    }

    @GetMapping("{id}")
    public Personne findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("nom/{nom}")
    public List<Personne> findByNom(@PathVariable String nom) {
        return service.findByNom(nom);
    }
}


