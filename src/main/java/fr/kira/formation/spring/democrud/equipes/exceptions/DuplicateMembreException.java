package fr.kira.formation.spring.democrud.equipes.exceptions;


public class DuplicateMembreException extends RuntimeException {
    public DuplicateMembreException(long id){
        super("Une équipe ne peux pas avoir deux fois le même membre portant l'id "+id);
    }
}
