package fr.kira.formation.spring.democrud.personnes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.kira.formation.spring.democrud.equipes.Equipe;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/***
 * Représente une personne dans notre application.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "personne") // nom de la table dans la base de données
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", length = 32, nullable = false)
    private String nom;
    @Column(name = "prenom", length = 32, nullable = false)
    private String prenom;
    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column
    private String password;

//    @JsonIgnore
    @ManyToMany(mappedBy = "membres") // Définit le nom de la propriété dans la classe Equipe
    private List<Equipe> equipes;

    public Personne(String nom, String prenom, LocalDate date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = date_naissance;
    }
}
