package com.preaching.preaching_management_backend.infrastructure.persistence.adapter;

import com.preaching.preaching_management_backend.domain.model.PreachedBlock;
import com.preaching.preaching_management_backend.domain.repository.PreachedBlockRepository;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachedBlockEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.mapper.PreachedBlockMapper;
import com.preaching.preaching_management_backend.infrastructure.persistence.repository.JpaPreachedBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PreachedBlockRepositoryAdapter implements PreachedBlockRepository {

    private final JpaPreachedBlockRepository jpaRepository;
    private final PreachedBlockMapper mapper;

    @Override
    public PreachedBlock save(PreachedBlock preachedBlock) {
        PreachedBlockEntity entity = mapper.toEntity(preachedBlock);
        PreachedBlockEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<PreachedBlock> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<PreachedBlock> findAll() {
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
    public boolean existsByPreachingDayIdAndBlockId(UUID preachingDayId, UUID blockId){
        return jpaRepository.existsByPreachingDay_IdAndBlock_Id(preachingDayId, blockId);
    }
}
