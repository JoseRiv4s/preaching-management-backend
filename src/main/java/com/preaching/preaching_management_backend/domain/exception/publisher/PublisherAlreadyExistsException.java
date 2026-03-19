package com.preaching.preaching_management_backend.domain.exception.publisher;

public class PublisherAlreadyExistsException extends RuntimeException {

    public PublisherAlreadyExistsException(String message) {
        super(message);
    }
}
