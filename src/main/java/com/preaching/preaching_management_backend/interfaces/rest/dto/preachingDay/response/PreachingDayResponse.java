package com.preaching.preaching_management_backend.interfaces.rest.dto.preachingDay.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class PreachingDayResponse {

    private UUID id;
    private LocalDate date;
    private UUID captainId;
    private String notes;
}
