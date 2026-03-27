package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantAlreadyExistsException;
import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantInvalidDataException;
import com.preaching.preaching_management_backend.domain.model.PreachingParticipant;
import com.preaching.preaching_management_backend.domain.repository.PreachingParticipantRepository;
import com.preaching.preaching_management_backend.domain.repository.PreachingDayRepository;
import com.preaching.preaching_management_backend.domain.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreachingParticipantService {

    private final PreachingParticipantRepository preachingParticipantRepository;
    private final PreachingDayRepository preachingDayRepository;
    private final PublisherRepository publisherRepository;

    public PreachingParticipant createPreachingParticipant(PreachingParticipant participant) {

        // Validación IDs
        validatePreachingDay(participant.getPreachingDayId());
        validatePublisher(participant.getPublisherId());

        // Validar duplicado
        if (preachingParticipantRepository.existsByPreachingDayIdAndPublisherId(
                participant.getPreachingDayId(), participant.getPublisherId())) {
            throw new ParticipantAlreadyExistsException(
                    String.format("Publisher %s is already registered in preaching day %s",
                            participant.getPublisherId(), participant.getPreachingDayId()));
        }

        return preachingParticipantRepository.save(participant);
    }

    public PreachingParticipant updatePreachingParticipant(UUID id, PreachingParticipant participant) {

        PreachingParticipant existing = preachingParticipantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(
                        String.format("Participant with ID %s not found in preaching session", id)));

        // Validar IDs actualizados
        validatePreachingDay(participant.getPreachingDayId());
        validatePublisher(participant.getPublisherId());

        // Validar duplicado si se cambia preachingDay o publisher
        if (!existing.getPreachingDayId().equals(participant.getPreachingDayId()) ||
                !existing.getPublisherId().equals(participant.getPublisherId())) {

            if (preachingParticipantRepository.existsByPreachingDayIdAndPublisherId(
                    participant.getPreachingDayId(), participant.getPublisherId())) {
                throw new ParticipantAlreadyExistsException(
                        String.format("Publisher %s is already registered in preaching day %s",
                                participant.getPublisherId(), participant.getPreachingDayId()));
            }
        }

        PreachingParticipant updated = PreachingParticipant.builder()
                .id(existing.getId())
                .preachingDayId(participant.getPreachingDayId())
                .publisherId(participant.getPublisherId())
                .build();

        return preachingParticipantRepository.save(updated);
    }

    public List<PreachingParticipant> getAllPreachingParticipants() {
        return preachingParticipantRepository.findAll();
    }

    public PreachingParticipant getPreachingParticipantById(UUID id) {
        return preachingParticipantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(
                        String.format("Participant with ID %s not found in preaching session", id)));
    }

    public void deletePreachingParticipant(UUID id) {
        PreachingParticipant participant = preachingParticipantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(
                        String.format("Participant with ID %s not found in preaching session", id)) );

        preachingParticipantRepository.deleteById(participant.getId());
    }

    // ----------------------------
    // Métodos privados de validación
    // ----------------------------

    private void validatePreachingDay(UUID preachingDayId) {
        if (preachingDayId == null) {
            throw new ParticipantInvalidDataException("PreachingDay ID cannot be null");
        }
        if (!preachingDayRepository.existsById(preachingDayId)) {
            throw new ParticipantNotFoundException(
                    String.format("Preaching day with ID %s not found", preachingDayId));
        }
    }

    private void validatePublisher(UUID publisherId) {
        if (publisherId == null) {
            throw new ParticipantInvalidDataException("Publisher ID cannot be null");
        }
        if (!publisherRepository.existsById(publisherId)) {
            throw new ParticipantNotFoundException(
                    String.format("Publisher with ID %s not found", publisherId));
        }
    }
}