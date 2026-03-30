package com.preaching.preaching_management_backend.infrastructure.persistence.repository;

import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachedBlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaPreachedBlockRepository extends JpaRepository<PreachedBlockEntity, UUID> {
    boolean existsByPreachingDay_IdAndBlock_Id(UUID preachingDayId, UUID blockId);
}
