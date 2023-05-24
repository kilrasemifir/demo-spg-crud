package fr.kira.formation.spring.democrud.exceptions;

import fr.kira.formation.spring.democrud.equipes.exceptions.DuplicateMembreException;
import fr.kira.formation.spring.democrud.equipes.exceptions.MembreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class OtherControllerAdvice {

    @ExceptionHandler({DuplicateMembreException.class})
    public ResponseEntity<ExceptionMessage> duplicateMembre(
            DuplicateMembreException ex,
            WebRequest request){
        return new ResponseEntity<>(
                new ExceptionMessage(ex.getMessage(), 406), HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler({MembreNotFoundException.class})
    public ResponseEntity<ExceptionMessage> membreNotFound(
            MembreNotFoundException ex,
            WebRequest request){
        return new ResponseEntity<>(
                new ExceptionMessage(ex.getMessage(), 406), HttpStatus.NOT_ACCEPTABLE
        );
    }
}
