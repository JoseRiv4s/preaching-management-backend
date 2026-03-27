package com.preaching.preaching_management_backend.infrastructure.persistence.adapter;

import com.preaching.preaching_management_backend.domain.model.PreachingParticipant;
import com.preaching.preaching_management_backend.domain.repository.PreachingParticipantRepository;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachingParticipantEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.mapper.PreachingParticipantMapper;
import com.preaching.preaching_management_backend.infrastructure.persistence.repository.JpaPreachingParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PreachingParticipantRepositoryAdapter implements PreachingParticipantRepository {

    private final JpaPreachingParticipantRepository jpaRepository;
    private final PreachingParticipantMapper mapper;

    @Override
    public PreachingParticipant save(PreachingParticipant participant) {
        PreachingParticipantEntity entity = mapper.toEntity(participant);
        PreachingParticipantEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<PreachingParticipant> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<PreachingParticipant> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByPreachingDayIdAndPublisherId(UUID preachingDayId, UUID publisherId) {
        return jpaRepository.existsByPreachingDay_IdAndPublisher_Id(preachingDayId, publisherId);
    }
}
