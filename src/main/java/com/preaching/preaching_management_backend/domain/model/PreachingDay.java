package com.preaching.preaching_management_backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreachingDay {
    private UUID id;
    private LocalDate date;
    private UUID captainId;
    private String notes;
}
