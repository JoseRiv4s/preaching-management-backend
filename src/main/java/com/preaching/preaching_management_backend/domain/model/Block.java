package com.preaching.preaching_management_backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Block {
    private UUID id;
    private String blockNumber;
    private BlockStatus status;
    private String notes;
}
