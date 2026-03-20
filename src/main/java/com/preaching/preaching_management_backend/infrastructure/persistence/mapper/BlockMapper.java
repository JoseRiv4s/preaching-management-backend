package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.Block;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.BlockEntity;
import org.springframework.stereotype.Component;

@Component
public class BlockMapper {

    public BlockEntity toEntity(Block block) {
        if (block == null) return null;

        return BlockEntity.builder()
                .id(block.getId())
                .blockNumber(block.getBlockNumber())
                .status(block.getStatus())
                .notes(block.getNotes())
                .build();
    }

    public Block toDomain(BlockEntity entity) {
        if (entity == null) return null;

        return Block.builder()
                .id(entity.getId())
                .blockNumber(entity.getBlockNumber())
                .status(entity.getStatus())
                .notes(entity.getNotes())
                .build();
    }
}
