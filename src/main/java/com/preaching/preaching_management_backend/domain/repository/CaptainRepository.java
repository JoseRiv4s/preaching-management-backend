package com.preaching.preaching_management_backend.domain.repository;

import com.preaching.preaching_management_backend.domain.model.Captain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaptainRepository {
    Captain save (Captain captain);
    Optional<Captain> findById(UUID id);
    List<Captain> findAll();
}
