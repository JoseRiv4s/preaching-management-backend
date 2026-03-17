package com.preaching.preaching_management_backend.infrastructure.persistence.repository;

import com.preaching.preaching_management_backend.infrastructure.persistence.entity.CaptainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCaptainRepository extends JpaRepository<CaptainEntity, UUID> {
    boolean existsByEmail(String email);
}
