package fr.kira.formation.spring.democrud;

import fr.kira.formation.spring.democrud.personnes.PersonneNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class NotFoundControllerAdvice{

    @ExceptionHandler({PersonneNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(PersonneNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
                new ExceptionMessage(ex.getMessage(), 404),
                HttpStatus.NOT_FOUND);
    }
}
