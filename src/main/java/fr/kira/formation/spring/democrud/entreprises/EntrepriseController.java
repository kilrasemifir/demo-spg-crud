package fr.kira.formation.spring.democrud.entreprises;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("entreprises")
public class EntrepriseController {

    private final EntrepriseService service;

    public EntrepriseController(EntrepriseService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody Entreprise entreprise) {
        service.save(entreprise);
    }

    @GetMapping("{id}")
    public Entreprise findById(@PathVariable long id) {
        return service.findById(id);
    }
}
