package com.preaching.preaching_management_backend.domain.exception.publisher;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException(String message) {
        super(message);
    }
}
