package com.preaching.preaching_management_backend.interfaces.rest.dto.captain.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CaptainResponse {
    private UUID id;
    private String name;
    private String phone;
    private String email;
}
