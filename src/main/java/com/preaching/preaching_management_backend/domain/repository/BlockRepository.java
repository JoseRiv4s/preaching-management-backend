package com.preaching.preaching_management_backend.domain.repository;

import com.preaching.preaching_management_backend.domain.model.Block;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlockRepository {
    Block save (Block block);
    Optional<Block> findById(UUID id);
    List<Block> findAll();
    void deleteById(UUID id);

    boolean existsById(UUID id);
}
