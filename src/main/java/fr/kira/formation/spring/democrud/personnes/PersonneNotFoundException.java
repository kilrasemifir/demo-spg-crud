package fr.kira.formation.spring.democrud.personnes;

import fr.kira.formation.spring.democrud.exceptions.NotFoundException;

//@ResponseStatus(HttpStatus.NOT_FOUND) inutile car on utilise un controller advice
public class PersonneNotFoundException extends NotFoundException {
    public PersonneNotFoundException(Long id) {
        super("personne", id);
    }
}
