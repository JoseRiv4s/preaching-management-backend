package com.preaching.preaching_management_backend.domain.exception.captain;

public class CaptainAlreadyExistsException extends RuntimeException {

    public CaptainAlreadyExistsException(String message) {
        super(message);
    }
}
