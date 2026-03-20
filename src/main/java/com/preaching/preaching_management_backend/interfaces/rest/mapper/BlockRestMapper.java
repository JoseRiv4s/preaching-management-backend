package com.preaching.preaching_management_backend.interfaces.rest.mapper;

import com.preaching.preaching_management_backend.domain.model.Block;
import com.preaching.preaching_management_backend.interfaces.rest.dto.block.request.CreateBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.block.request.UpdateBlockRequest;
import com.preaching.preaching_management_backend.interfaces.rest.dto.block.response.BlockResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BlockRestMapper {

    public Block toDomain(CreateBlockRequest request) {
        return Block.builder()
                .blockNumber(request.getBlockNumber())
                .notes(request.getNotes())
                .build();
    }

    public Block toDomain(UpdateBlockRequest request, UUID id) {
        return Block.builder()
                .id(id)
                .blockNumber(request.getBlockNumber())
                .status(request.getStatus())
                .notes(request.getNotes())
                .build();
    }

    public BlockResponse toResponse(Block block) {
        return BlockResponse.builder()
                .id(block.getId())
                .blockNumber(block.getBlockNumber())
                .status(block.getStatus())
                .notes(block.getNotes())
                .build();
    }
}