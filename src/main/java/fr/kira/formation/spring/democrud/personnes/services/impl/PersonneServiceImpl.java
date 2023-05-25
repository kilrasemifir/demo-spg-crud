package fr.kira.formation.spring.democrud.personnes.services.impl;

import fr.kira.formation.spring.democrud.exceptions.NotFoundException;
import fr.kira.formation.spring.democrud.personnes.model.Personne;
import fr.kira.formation.spring.democrud.personnes.repositories.PersonneRepository;
import fr.kira.formation.spring.democrud.personnes.services.PersonneService;
import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import fr.kira.formation.spring.democrud.personnes.dto.mapper.PersonneMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;
    private final PersonneMapper mapper;

    public PersonneServiceImpl(PersonneRepository personneRepository, PersonneMapper mapper) {
        this.personneRepository = personneRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MinimalPersonneDTO> findAll() {
        return personneRepository.findAll()
                .stream().map(mapper::convertToMinimalPersonneDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    @Override
    public Personne findById(Long id) {
        Optional<Personne> personne = personneRepository.findById(id);
        return personne.orElseThrow(() -> new NotFoundException("personne", id));
    }

    @Override
    public void deleteById(Long aLong) {
        personneRepository.deleteById(aLong);
    }

    @Override
    public List<Personne> findByNom(String nom) {
        return this.personneRepository.findByNom(nom);
    }
}
