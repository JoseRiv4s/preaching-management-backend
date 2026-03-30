package com.preaching.preaching_management_backend.domain.exception.preachedBlock;

public class PreachedBlockAlreadyExistsException extends RuntimeException {
    public PreachedBlockAlreadyExistsException(String message) {
        super(message);
    }
}
