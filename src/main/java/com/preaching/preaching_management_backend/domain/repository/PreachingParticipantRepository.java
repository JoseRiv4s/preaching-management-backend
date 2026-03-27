package com.preaching.preaching_management_backend.domain.repository;

import com.preaching.preaching_management_backend.domain.model.PreachingParticipant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PreachingParticipantRepository {
    PreachingParticipant save (PreachingParticipant preachingParticipant);
    Optional<PreachingParticipant> findById();
    List<PreachingParticipant> findAll();
    void deleteById(UUID id);

}
