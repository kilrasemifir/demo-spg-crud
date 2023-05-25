package fr.kira.formation.spring.democrud.personnes;

import fr.kira.formation.spring.democrud.personnes.dto.mapper.PersonneMapper;
import fr.kira.formation.spring.democrud.personnes.services.impl.PersonneServiceImpl;
import fr.kira.formation.spring.democrud.personnes.repositories.PersonneRepository;
import fr.kira.formation.spring.democrud.personnes.services.PersonneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PersonneConfiguration {

    @Bean
    public PersonneService personneService(
            PersonneRepository repository,
            PersonneMapper mapper
    ){
        return new PersonneServiceImpl(repository, mapper);
    }
}
