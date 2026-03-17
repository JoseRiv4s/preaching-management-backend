package com.preaching.preaching_management_backend.domain.exception;

public class CaptainAlreadyExistsException extends RuntimeException {

    public CaptainAlreadyExistsException(String message) {
        super(message);
    }
}
