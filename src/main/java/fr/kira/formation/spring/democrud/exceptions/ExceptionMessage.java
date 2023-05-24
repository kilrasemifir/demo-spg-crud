package fr.kira.formation.spring.democrud.exceptions;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExceptionMessage {
    private String message;
    private int status;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ExceptionMessage(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
