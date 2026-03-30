package com.preaching.preaching_management_backend.domain.repository;

import com.preaching.preaching_management_backend.domain.model.PreachedBlock;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PreachedBlockRepository {
    PreachedBlock save (PreachedBlock preachedBlock);
    Optional<PreachedBlock> findById(UUID id);
    List<PreachedBlock> findAll();
    void deleteById(UUID id);

    boolean existsByPreachingDayIdAndBlockId(UUID preachingDayId, UUID blockId);
}
