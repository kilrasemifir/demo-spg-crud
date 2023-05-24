package fr.kira.formation.spring.democrud.personnes;

import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService service;

    public PersonneController(PersonneService service) {
        this.service = service;
    }

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


