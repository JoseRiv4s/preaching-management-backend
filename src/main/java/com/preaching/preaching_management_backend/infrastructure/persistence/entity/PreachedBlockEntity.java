package com.preaching.preaching_management_backend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "preached_blocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreachedBlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "preaching_day_id", nullable = false)
    private PreachingDayEntity preachingDay;

    @ManyToOne
    @JoinColumn(name = "block_id", nullable = false)
    private BlockEntity blockId;
}
