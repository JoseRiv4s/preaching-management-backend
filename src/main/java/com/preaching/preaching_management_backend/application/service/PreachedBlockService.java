package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.preachedBlock.PreachedBlockAlreadyExistsException;
import com.preaching.preaching_management_backend.domain.exception.preachedBlock.PreachedBlockNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantNotFoundException;
import com.preaching.preaching_management_backend.domain.model.PreachedBlock;
import com.preaching.preaching_management_backend.domain.repository.BlockRepository;
import com.preaching.preaching_management_backend.domain.repository.PreachedBlockRepository;
import com.preaching.preaching_management_backend.domain.repository.PreachingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreachedBlockService {

    private final PreachedBlockRepository preachedBlockRepository;
    private final PreachingDayRepository preachingDayRepository;
    private final BlockRepository blockRepository;

    // CREATE
    public PreachedBlock createPreachedBlock(PreachedBlock preachedBlock) {

        validatePreachingDay(preachedBlock.getPreachingDayId());
        validateBlock(preachedBlock.getBlockId());

        if (preachedBlockRepository.existsByPreachingDayIdAndBlockId(
                preachedBlock.getPreachingDayId(),
                preachedBlock.getBlockId())) {

            throw new PreachedBlockAlreadyExistsException(
                    String.format(
                            "Block %s is already assigned to preaching day %s",
                            preachedBlock.getBlockId(),
                            preachedBlock.getPreachingDayId()
                    )
            );
        }

        return preachedBlockRepository.save(preachedBlock);
    }

    // UPDATE
    public PreachedBlock updatePreachedBlock(UUID id, PreachedBlock preachedBlock) {

        PreachedBlock existing = preachedBlockRepository.findById(id)
                .orElseThrow(() -> new PreachedBlockNotFoundException(
                        String.format("Preached block with ID %s was not found", id)
                ));

        validatePreachingDay(preachedBlock.getPreachingDayId());
        validateBlock(preachedBlock.getBlockId());

        // Validar duplicado solo si cambian los valores
        if (!existing.getPreachingDayId().equals(preachedBlock.getPreachingDayId()) ||
                !existing.getBlockId().equals(preachedBlock.getBlockId())) {

            if (preachedBlockRepository.existsByPreachingDayIdAndBlockId(
                    preachedBlock.getPreachingDayId(),
                    preachedBlock.getBlockId())) {

                throw new PreachedBlockAlreadyExistsException(
                        String.format(
                                "Block %s is already assigned to preaching day %s",
                                preachedBlock.getBlockId(),
                                preachedBlock.getPreachingDayId()
                        )
                );
            }
        }

        PreachedBlock updated = PreachedBlock.builder()
                .id(existing.getId())
                .preachingDayId(preachedBlock.getPreachingDayId())
                .blockId(preachedBlock.getBlockId())
                .build();

        return preachedBlockRepository.save(updated);
    }

    // GET ALL
    public List<PreachedBlock> getPreachedBlock() {
        return preachedBlockRepository.findAll();
    }

    // GET BY ID
    public PreachedBlock getPreachedBlock(UUID id) {
        return preachedBlockRepository.findById(id)
                .orElseThrow(() -> new PreachedBlockNotFoundException(
                        String.format("Preached block with ID %s was not found", id)
                ));
    }

    // DELETE
    public void deletePreachedBlock(UUID id) {
        PreachedBlock preachedBlock = preachedBlockRepository.findById(id)
                .orElseThrow(() -> new PreachedBlockNotFoundException(
                        String.format("Preached block with ID %s was not found", id)
                ));

        preachedBlockRepository.deleteById(preachedBlock.getId());
    }

    // VALIDATIONS
    private void validatePreachingDay(UUID preachingDayId) {
        if (preachingDayId == null) {
            throw new ParticipantInvalidDataException("Preaching day ID cannot be null");
        }

        if (!preachingDayRepository.existsById(preachingDayId)) {
            throw new ParticipantNotFoundException(
                    String.format("Preaching day with ID %s was not found", preachingDayId)
            );
        }
    }

    private void validateBlock(UUID blockId) {
        if (blockId == null) {
            throw new ParticipantInvalidDataException("Block ID cannot be null");
        }

        if (!blockRepository.existsById(blockId)) {
            throw new ParticipantNotFoundException(
                    String.format("Block with ID %s was not found", blockId)
            );
        }
    }
}