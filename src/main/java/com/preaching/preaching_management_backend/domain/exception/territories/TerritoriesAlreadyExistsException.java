package com.preaching.preaching_management_backend.domain.exception.territories;

public class TerritoriesAlreadyExistsException extends RuntimeException {
    public TerritoriesAlreadyExistsException(String message) {
        super(message);
    }
}
