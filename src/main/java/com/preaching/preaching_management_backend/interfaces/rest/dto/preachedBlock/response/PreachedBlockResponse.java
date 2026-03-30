package com.preaching.preaching_management_backend.interfaces.rest.dto.preachedBlock.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class PreachedBlockResponse {
    private UUID id;
    private UUID preachingDayId;
    private UUID blockId;
}
