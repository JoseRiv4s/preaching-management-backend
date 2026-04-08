package com.preaching.preaching_management_backend.interfaces.rest.dto.block.response;

import com.preaching.preaching_management_backend.domain.model.BlockStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class BlockResponse {

    private UUID id;
    private String blockNumber;
    private BlockStatus status;
    private String notes;
    private UUID territoryId;
}