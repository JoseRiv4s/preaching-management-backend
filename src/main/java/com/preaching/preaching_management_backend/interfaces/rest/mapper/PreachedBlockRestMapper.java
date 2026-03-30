package com.preaching.preaching_management_backend.interfaces.rest.mapper;

import com.preaching.preaching_management_backend.domain.model.PreachedBlock;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.request.CreatePreachedBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.request.UpdatePreachedBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.response.PreachedBlockResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PreachedBlockRestMapper {

    public PreachedBlock toDomain(CreatePreachedBlockRequest request) {
        return PreachedBlock.builder()
                .preachingDayId(request.getPreachingDayId())
                .blockId(request.getBlockId())
                .build();
    }

    public PreachedBlock toDomain(UpdatePreachedBlockRequest request, UUID id) {
        return PreachedBlock.builder()
                .id(id)
                .preachingDayId(request.getPreachingDayId())
                .blockId(request.getBlockId())
                .build();
    }

    public PreachedBlockResponse toResponse(PreachedBlock preachedBlock) {
        return PreachedBlockResponse.builder()
                .id(preachedBlock.getId())
                .preachingDayId(preachedBlock.getPreachingDayId())
                .blockId(preachedBlock.getBlockId())
                .build();
    }
}
