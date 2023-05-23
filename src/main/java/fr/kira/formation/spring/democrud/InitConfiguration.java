package fr.kira.formation.spring.democrud;

import fr.kira.formation.spring.democrud.equipes.Equipe;
import fr.kira.formation.spring.democrud.equipes.EquipeRepository;
import fr.kira.formation.spring.democrud.equipes.EquipeService;
import fr.kira.formation.spring.democrud.personnes.Personne;
import fr.kira.formation.spring.democrud.personnes.PersonneRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class InitConfiguration {

    private final EquipeRepository equipeRepository;
    private final PersonneRepository personneRepository;

    public InitConfiguration(EquipeRepository equipeRepository, PersonneRepository personneRepository) {
        this.equipeRepository = equipeRepository;
        this.personneRepository = personneRepository;
    }

    @PostConstruct()
    public void init(){
        this.personneRepository.deleteAll();
        this.equipeRepository.deleteAll();
        Personne p1 = this.personneRepository.save(new Personne("Doe","John", LocalDate.now()));
        Personne p2 = this.personneRepository.save(new Personne("Doe","Lea", LocalDate.now()));
        Equipe e = this.equipeRepository.save(new Equipe("Equipe 1", "", List.of(p1,p2)));
    }

}
