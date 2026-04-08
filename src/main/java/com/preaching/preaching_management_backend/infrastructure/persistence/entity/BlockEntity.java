package com.preaching.preaching_management_backend.infrastructure.persistence.entity;

import com.preaching.preaching_management_backend.domain.model.BlockStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

import java.util.UUID;

@Entity
@Table(name = "blocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 20)
    private String blockNumber;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "status", columnDefinition = "block_status")
    private BlockStatus status;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "territory_id", nullable = false)
    private TerritoriesEntity territories;
}
