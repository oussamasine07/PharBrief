package com.pharmacy.pharbrief.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException ( String message ) {
        super(message);
    }
}
