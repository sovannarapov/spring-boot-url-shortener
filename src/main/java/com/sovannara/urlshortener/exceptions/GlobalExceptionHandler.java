package com.sovannara.urlshortener.exceptions;

import com.sovannara.urlshortener.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<Response<Object>> handleUrlNotFoundException(UrlNotFoundException ex) {
        Response<Object> response = new Response<>(
                false,
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null,
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<Response<Object>> handleInvalidUrlException(InvalidUrlException ex) {
        Response<Object> response = new Response<>(
                false,
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null,
                null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> handleGlobalException(Exception ex) {
        Response<Object> response = new Response<>(
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An error occurred",
                null,
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
