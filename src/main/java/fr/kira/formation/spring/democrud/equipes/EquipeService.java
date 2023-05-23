package fr.kira.formation.spring.democrud.equipes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {
    private final EquipeRepository repository;

    public EquipeService(EquipeRepository repository) {
        this.repository = repository;
    }

    public List<Equipe> findAll() {
        return repository.findAll();
    }

    public Equipe save(Equipe entity) {
        return repository.save(entity);
    }

    public Optional<Equipe> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public Equipe update(Long id, Equipe entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
