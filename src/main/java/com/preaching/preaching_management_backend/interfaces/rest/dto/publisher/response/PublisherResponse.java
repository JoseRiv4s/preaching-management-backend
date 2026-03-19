package com.preaching.preaching_management_backend.interfaces.rest.dto.publisher.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PublisherResponse {
    private UUID id;
    private String name;
    private String phone;
}
