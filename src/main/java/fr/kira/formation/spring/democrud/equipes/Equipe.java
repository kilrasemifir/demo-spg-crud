package fr.kira.formation.spring.democrud.equipes;

import fr.kira.formation.spring.democrud.personnes.model.Personne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nom;
    private String description;

    @ManyToMany
    @JoinTable(
            name="est_membre",
            joinColumns = @JoinColumn(name="equipe_id"),
            inverseJoinColumns = @JoinColumn(name="membre_id")
    ) // Décrit la table de jointure pour la relation entre les équipes et les personnes
    private Set<Personne> membres;

    public Equipe(String nom, String description, Set<Personne> membres) {
        this.nom = nom;
        this.description = description;
        this.membres = membres;
    }
}
