package fr.kira.formation.spring.democrud.equipes;

import fr.kira.formation.spring.democrud.equipes.exceptions.DuplicateMembreException;
import fr.kira.formation.spring.democrud.equipes.exceptions.EquipeNotFoundException;
import fr.kira.formation.spring.democrud.equipes.exceptions.MembreNotFoundException;
import fr.kira.formation.spring.democrud.personnes.Personne;
import fr.kira.formation.spring.democrud.personnes.PersonneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {
    private final EquipeRepository repository;
    private final PersonneService personneService;

    public EquipeService(EquipeRepository repository, PersonneService personneService) {
        this.repository = repository;
        this.personneService = personneService;
    }

    public List<Equipe> findAll() {
        return repository.findAll();
    }

    public Equipe save(Equipe entity) {
        return repository.save(entity);
    }

    public Equipe findById(Long id) {
        return repository.findById(id).orElseThrow(()->new EquipeNotFoundException(id));
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public Equipe update(Long id, Equipe entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    /**
     * Ajoute un membre à l'équipe portant l'id idEquipe et dont l'id est idPersonne.
     * @param idEquipe id de l'équipe
     * @param idPersonne id de la personne à ajouter à l'équipe
     */
    public void addMembre(long idEquipe, long idPersonne){
        Equipe equipe = this.findById(idEquipe);
        Personne personne = this.personneService.findById(idPersonne);
        if (equipe.getMembres().contains(personne)){
            throw new DuplicateMembreException(idPersonne);
        }
        equipe.getMembres().add(personne);
        this.save(equipe);
    }

    public void removeMembre(long idEquipe, long idPersonne){
        Equipe equipe = this.findById(idEquipe);
        Personne personne = this.personneService.findById(idPersonne);
        if (!equipe.getMembres().contains(personne)){
            throw new MembreNotFoundException("La personne d'id "+idPersonne+" n'est pas membre de l'équipe d'id "+idEquipe);
        }
        equipe.getMembres().remove(personne);
        this.save(equipe);
    }
}
