package fr.kira.formation.spring.democrud.personnes.dto;

import lombok.Data;

import java.util.List;

@Data
public class MinimalPersonneDTO {
    private long id;
    private String nom;
    private String prenom;
    private List<String> nomEquipes;
}
