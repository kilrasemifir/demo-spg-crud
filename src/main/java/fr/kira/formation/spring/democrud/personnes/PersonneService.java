package fr.kira.formation.spring.democrud.personnes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    public Personne findById(Long id) {
        Optional<Personne> personne = personneRepository.findById(id);
        return personne.orElseThrow(() -> new PersonneNotFoundException(id));
    }

    public void deleteById(Long aLong) {
        personneRepository.deleteById(aLong);
    }

    public List<Personne> findByNom(String nom) {
        return this.personneRepository.findByNom(nom);
    }
}
