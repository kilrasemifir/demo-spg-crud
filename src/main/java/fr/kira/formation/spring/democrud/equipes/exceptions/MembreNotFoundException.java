package fr.kira.formation.spring.democrud.equipes.exceptions;

import fr.kira.formation.spring.democrud.exceptions.NotFoundException;

public class MembreNotFoundException extends RuntimeException {
    public MembreNotFoundException(String message) {
        super(message);
    }
}
