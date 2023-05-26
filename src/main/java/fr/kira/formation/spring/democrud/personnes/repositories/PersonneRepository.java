package fr.kira.formation.spring.democrud.personnes.repositories;

import fr.kira.formation.spring.democrud.personnes.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    /**
     * Retourne la liste des personnes ayant comme nom "nom"
     * "find" = SELECT
     * "by" = WHERE
     * @param nom à rechercher
     * @return liste des personnes avec ce nom
     */
    List<Personne> findByNom(String nom);
    List<Personne> findByDateNaissanceBefore(LocalDate date_naissance);
//    @Query(nativeQuery = true, value="SELECT * FROM personne WHERE nom=?")
//    List<Personne> custom(String nom);
    List<Personne> findByNomAndPrenomAndDateNaissanceBetween(
            String nom, String prenom, LocalDate before, LocalDate after);

    boolean existsByNomAndPrenom(String nom, String prenom);
}
