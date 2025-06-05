package com.pharmacy.pharbrief.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler( value = {ResourceNotFoundException.class} )
    public ResponseEntity<?> handleResourceNotFoundException (
            ResourceNotFoundException ex,
            WebRequest req
    ) {
        // create the payload with the error message
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("message", ex.getMessage());

        //  return the response body
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> hancleValidationException (
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach(err -> {
//                    FieldError fieldError = (FieldError) err;
//                    String fieldName = fieldError.getField();

                    String fieldName = ((FieldError) err).getField();
                    String errorMsg = err.getDefaultMessage();

                    errors.put(fieldName, errorMsg);

                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
