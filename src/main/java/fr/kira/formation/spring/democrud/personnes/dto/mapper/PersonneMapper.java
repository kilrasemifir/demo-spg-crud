package fr.kira.formation.spring.democrud.personnes.dto.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.spring.democrud.equipes.Equipe;
import fr.kira.formation.spring.democrud.personnes.model.Personne;
import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonneMapper {

    private final ObjectMapper mapper;

    public PersonneMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public MinimalPersonneDTO convertToMinimalPersonneDTO(Personne personne){
        MinimalPersonneDTO dto = mapper.convertValue(personne, MinimalPersonneDTO.class);
        List<String> nomEquipes = personne.getEquipes()
                .stream().map(Equipe::getNom)
                .toList();
        dto.setNomEquipes(nomEquipes);
        return dto;
    }
}
