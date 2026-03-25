package com.preaching.preaching_management_backend.infrastructure.persistence.repository;

import com.preaching.preaching_management_backend.infrastructure.persistence.entity.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaBlockRepository extends JpaRepository<BlockEntity, UUID> {
}
