package fr.kira.formation.spring.democrud.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.spring.democrud.equipes.Equipe;
import fr.kira.formation.spring.democrud.exceptions.NotFoundException;
import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import fr.kira.formation.spring.democrud.personnes.dto.mapper.PersonneMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;
    private final PersonneMapper mapper;

    public PersonneService(PersonneRepository personneRepository, PersonneMapper mapper) {
        this.personneRepository = personneRepository;
        this.mapper = mapper;
    }

    public List<MinimalPersonneDTO> findAll() {
        return personneRepository.findAll()
                .stream().map(mapper::convertToMinimalPersonneDTO)
                .collect(Collectors.toList());
    }

    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    public Personne findById(Long id) {
        Optional<Personne> personne = personneRepository.findById(id);
        return personne.orElseThrow(() -> new NotFoundException("personne", id));
    }

    public void deleteById(Long aLong) {
        personneRepository.deleteById(aLong);
    }

    public List<Personne> findByNom(String nom) {
        return this.personneRepository.findByNom(nom);
    }
}
