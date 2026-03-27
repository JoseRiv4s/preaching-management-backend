package com.preaching.preaching_management_backend.domain.exception.preachingParticipants;

public class ParticipantNotFoundException extends RuntimeException {
    public ParticipantNotFoundException(String message) {
        super(message);
    }
}
