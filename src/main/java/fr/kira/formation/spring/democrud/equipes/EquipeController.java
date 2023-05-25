package fr.kira.formation.spring.democrud.equipes;

import fr.kira.formation.spring.democrud.equipes.dto.EquipeMinimalMembreDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipes")
public class EquipeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquipeController.class);

    private final EquipeService service;

    public EquipeController(EquipeService service) {
        this.service = service;
        LOGGER.trace("EquipeController TRACE");
        LOGGER.debug("EquipeController DEBUG");
        LOGGER.info("EquipeController INFO");
        LOGGER.warn("EquipeController WARN");
        LOGGER.error("EquipeController ERROR");
    }

    @GetMapping("")
    public List<EquipeMinimalMembreDTO> findAll() {
        return service.findAll();
    }

    @PostMapping("")
    public Equipe save(@RequestBody Equipe entity) {
        return service.save(entity);
    }

    @GetMapping("{id}")
    public Equipe findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public Equipe update(@PathVariable Long id, @RequestBody Equipe entity) {
        return service.update(id, entity);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{idEquipe}/membres/{idPersonne}")
    public void addMembre(@PathVariable Long idEquipe, @PathVariable Long idPersonne){
        this.service.addMembre(idEquipe, idPersonne);
    }

    @DeleteMapping("{idEquipe}/membres/{idPersonne}")
    public void removeMembre(@PathVariable Long idEquipe, @PathVariable Long idPersonne){
        this.service.removeMembre(idEquipe, idPersonne);
    }
}
