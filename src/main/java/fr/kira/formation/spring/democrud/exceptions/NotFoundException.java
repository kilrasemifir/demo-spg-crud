package fr.kira.formation.spring.democrud.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String ressource, long id) {
        super("Aucune ressource de type "+ressource+" ne porte l'id "+id);
    }
}
