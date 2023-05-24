package fr.kira.formation.spring.democrud.equipes.dto;

import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import lombok.Data;

import java.util.List;

@Data
public class EquipeMinimalMembreDTO {
    private long id;
    private String nom;
    private List<MinimalPersonneDTO> membres;
}
