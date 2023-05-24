package fr.kira.formation.spring.democrud.equipes.dto.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.spring.democrud.equipes.Equipe;
import fr.kira.formation.spring.democrud.equipes.dto.EquipeMinimalMembreDTO;
import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import org.springframework.stereotype.Component;

@Component
public class EquipeMapper {

    private final ObjectMapper mapper;

    public EquipeMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public EquipeMinimalMembreDTO convertToEquipeMinimalMembre(Equipe equipe){
        EquipeMinimalMembreDTO dto = new EquipeMinimalMembreDTO();
        dto.setId(equipe.getId());
        dto.setNom(equipe.getNom());
        dto.setMembres(equipe.getMembres()
                .stream()
                .map(membre->mapper.convertValue(membre, MinimalPersonneDTO.class))
                .toList());
        return dto;
    }
}
