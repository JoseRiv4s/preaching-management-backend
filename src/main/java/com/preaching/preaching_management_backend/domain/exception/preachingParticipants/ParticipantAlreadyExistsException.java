package com.preaching.preaching_management_backend.domain.exception.preachingParticipants;

public class ParticipantAlreadyExistsException extends RuntimeException {
    public ParticipantAlreadyExistsException(String message) {
        super(message);
    }
}
