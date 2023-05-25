package fr.kira.formation.spring.democrud.personnes.services;

import fr.kira.formation.spring.democrud.personnes.dto.MinimalPersonneDTO;
import fr.kira.formation.spring.democrud.personnes.model.Personne;

import java.util.List;

public interface PersonneService {

    /**
     * Retourne la liste des personnes
     * @return liste des personnes
     */
    List<MinimalPersonneDTO> findAll();

    /**
     * Sauvegarde ou remplace une personne dans la base de données.
     * Si l'entity porte un id, cela remplace les valeurs de l'entité qui porte le même id.
     * Si l'entity ne porte pas d'id, cela crée une nouvelle personne dans la base de données.
     * @param entity personne à sauvegarder
     * @return personne sauvegardée avec son id
     */
    Personne save(Personne entity);

    /**
     * Retourne la personne qui porte l'id passé en paramètre
     * @param id id de la personne à retourner
     * @return personne qui porte l'id passé en paramètre
     */
    Personne findById(Long id);

    /**
     * Supprime la personne qui porte l'id passé en paramètre
     * @param id id de la personne à supprimer
     */
    void deleteById(Long id);

    /**
     * Retourne la liste des personnes qui portent le nom passé en paramètre
     * @param nom nom à rechercher
     * @return liste des personnes qui portent le nom passé en paramètre
     */
    List<Personne> findByNom(String nom);
}
