package br.com.cesurgmarau.trabalho_final.infra.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MensagemResponse> handleBadRequest(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemResponse(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensagemResponse> handleInternalServerError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MensagemResponse("Erro inesperado: " + e.getMessage()));
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<MensagemResponse> handleNotFound(ClassNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemResponse(e.getMessage()));
    }
}
