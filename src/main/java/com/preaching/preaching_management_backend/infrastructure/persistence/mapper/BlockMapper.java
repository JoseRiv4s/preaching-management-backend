package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.Block;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.BlockEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.TerritoriesEntity;
import org.springframework.stereotype.Component;

@Component
public class BlockMapper {

    public BlockEntity toEntity(Block block) {
        TerritoriesEntity territories = new TerritoriesEntity();
        territories.setId(block.getTerritoryId());

        return BlockEntity.builder()
                .id(block.getId())
                .blockNumber(block.getBlockNumber())
                .status(block.getStatus())
                .notes(block.getNotes())
                .territories(territories)
                .build();
    }

    public Block toDomain(BlockEntity entity) {

        return Block.builder()
                .id(entity.getId())
                .blockNumber(entity.getBlockNumber())
                .status(entity.getStatus())
                .notes(entity.getNotes())
                .territoryId(entity.getTerritories().getId())
                .build();
    }
}
