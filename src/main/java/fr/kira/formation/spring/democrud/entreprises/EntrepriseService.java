package fr.kira.formation.spring.democrud.entreprises;

import fr.kira.formation.spring.democrud.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EntrepriseService {

    private final EntrepriseRepository repository;

    public EntrepriseService(EntrepriseRepository repository) {
        this.repository = repository;
    }

    public void save(Entreprise entreprise) {
        repository.save(entreprise);
    }

    public Entreprise findById(long id) {
        return repository.findById(id).orElseThrow(()->new NotFoundException("entreprise", id));
    }
}
