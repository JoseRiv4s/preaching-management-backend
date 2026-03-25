package com.preaching.preaching_management_backend.domain.exception.preachingDay;

public class PreachingDayAlreadyExistsException extends RuntimeException {
    public PreachingDayAlreadyExistsException(String message) {
        super(message);
    }
}
