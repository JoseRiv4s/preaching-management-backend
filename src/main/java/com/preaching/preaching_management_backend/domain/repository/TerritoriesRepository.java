package com.preaching.preaching_management_backend.domain.repository;

import com.preaching.preaching_management_backend.domain.model.Territories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TerritoriesRepository {
    Territories save (Territories territories);
    Optional<Territories> findById(UUID id);
    List<Territories> findAll();
    void deleteById(UUID id);

    boolean existsById(UUID id);
}
