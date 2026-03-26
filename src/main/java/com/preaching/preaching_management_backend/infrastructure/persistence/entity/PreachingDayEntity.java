package com.preaching.preaching_management_backend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "preaching_days")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreachingDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "captain_id", nullable = false)
    private UUID captainId;

    private String notes;
}
