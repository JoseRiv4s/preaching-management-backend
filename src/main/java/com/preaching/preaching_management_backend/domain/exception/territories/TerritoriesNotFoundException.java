package com.preaching.preaching_management_backend.domain.exception.territories;

public class TerritoriesNotFoundException extends RuntimeException {
    public TerritoriesNotFoundException(String message) {
        super(message);
    }
}
