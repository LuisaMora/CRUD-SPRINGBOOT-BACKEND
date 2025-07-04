package com.example.crud.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// Extiende ResponseEntityExceptionHandler para un manejo de errores más fácil de Spring MVC
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Manejador para ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleExceptionNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "NOT FOUND"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Nuevo manejador para errores de validación de @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        // También puedes construir un ErrorDetails personalizado si prefieres
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                "Validation Failed", // Un mensaje general para la validación
                request.getDescription(false),
                "BAD_REQUEST" // O VALIDATION_ERROR, o el que prefieras
        );

        // Podrías agregar los 'errors' (mapa) dentro de ErrorDetails si modificas la clase ErrorDetails
        // Por ahora, devolveremos un ResponseEntity con el mapa de errores en el cuerpo
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        // O si quieres mantener el formato de ErrorDetails y incluir los mensajes,
        // tendrías que modificar ErrorDetails para que acepte un mapa o lista de errores.
        // Por ejemplo, añadiendo List<String> details; o Map<String, String> validationErrors;
    }

    // Manejador genérico para cualquier otra excepción no controlada
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest webRequest) {
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL SERVER ERROR"
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}