package fr.kira.formation.spring.democrud.personnes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonneNotFoundException extends RuntimeException {
    public PersonneNotFoundException(Long id) {
        super("Impossible de trouver la personne portant l'id " + id);
    }
}
