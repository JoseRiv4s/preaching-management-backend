package com.preaching.preaching_management_backend.infrastructure.persistence.mapper;

import com.preaching.preaching_management_backend.domain.model.PreachedBlock;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.BlockEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachedBlockEntity;
import com.preaching.preaching_management_backend.infrastructure.persistence.entity.PreachingDayEntity;
import org.springframework.stereotype.Component;

@Component
public class PreachedBlockMapper {

    public PreachedBlockEntity toEntity(PreachedBlock preachedBlock){

        PreachingDayEntity preachingDay = new PreachingDayEntity();
        preachingDay.setId(preachedBlock.getPreachingDayId());

        BlockEntity block = new BlockEntity();
        block.setId(preachedBlock.getBlockId());

        return PreachedBlockEntity.builder()
                .id(preachedBlock.getId())
                .preachingDay(preachingDay)
                .block(block)
                .build();
    }

    public PreachedBlock toDomain(PreachedBlockEntity entity) {
        return PreachedBlock.builder()
                .id(entity.getId())
                .preachingDayId(entity.getPreachingDay().getId())
                .blockId(entity.getBlock().getId())
                .build();
    }
}
