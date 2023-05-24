package fr.kira.formation.spring.democrud.equipes.exceptions;

import fr.kira.formation.spring.democrud.exceptions.NotFoundException;

public class EquipeNotFoundException extends NotFoundException {

    public EquipeNotFoundException(long id){
        super("equipe", id);
    }
}
