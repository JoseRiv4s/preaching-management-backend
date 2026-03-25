package com.preaching.preaching_management_backend.infrastructure.persistence.adapter;

import com.preaching.preaching_management_backend.domain.model.Block;
import com.preaching.preaching_management_backend.domain.repository.BlockRepository;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.BlockEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.mapper.BlockMapper;
import com.preaching.preaching_management_backend.infrastructure.persistence.repository.JpaBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BlockRepositoryAdapter implements BlockRepository {

    private final JpaBlockRepository jpaRepository;
    private final BlockMapper mapper;

    @Override
    public Block save(Block block) {
        BlockEntity entity = mapper.toEntity(block);
        BlockEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Block> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Block> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
