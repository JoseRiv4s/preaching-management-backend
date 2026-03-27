package com.preaching.preaching_management_backend.infrastructure.persistence.repository;

import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachingParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaPreachingParticipantRepository extends JpaRepository<PreachingParticipantEntity, UUID> {
    boolean existsByPreachingDay_IdAndPublisher_Id(UUID preachingDayId, UUID publisherId);
}