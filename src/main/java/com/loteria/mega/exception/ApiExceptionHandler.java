package com.loteria.mega.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().
                forEach(error->errors.put("error", error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PessoaNaoEncontrada.class)
    public ResponseEntity<Object> handlePessoaNaoEncontradaException(
            PessoaNaoEncontrada ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PessoaPossuiApostas.class)
    public ResponseEntity<Object> handlePessoaPossuiApostasException(
            PessoaPossuiApostas ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }

}


