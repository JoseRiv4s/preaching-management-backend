package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.block.BlockInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.block.BlockNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.preachedBlock.PreachedBlockRelatedResourceNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.territories.TerritoriesInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.territories.TerritoriesRelatedResourceNotFoundException;
import com.preaching.preaching_management_backend.domain.model.Block;
import com.preaching.preaching_management_backend.domain.repository.BlockRepository;
import com.preaching.preaching_management_backend.domain.repository.TerritoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockRepository blockRepository;
    private final TerritoriesRepository territoriesRepository;

    public Block createBlock(Block block) {
        validateTerritory(block.getTerritoryId());

        if (block.getBlockNumber() == null || block.getBlockNumber().isBlank()){
            throw new BlockInvalidDataException("El número del bloque es obligatorio");
        }

        return blockRepository.save(block);
    }

    public Block updateBlock (UUID id, Block block) {

        Block existing = blockRepository.findById(id)
                .orElseThrow(() -> new BlockNotFoundException("El bloque no encontrado"));

        validateTerritory(block.getTerritoryId());

        if (block.getBlockNumber() == null || block.getBlockNumber().isBlank()){
            throw new BlockInvalidDataException("El número del bloque es obligatorio");
        }

        Block updated = Block.builder()
                .id(existing.getId())
                .blockNumber(block.getBlockNumber())
                .status(block.getStatus())
                .notes(block.getNotes())
                .territoryId(block.getTerritoryId())
                .build();

        return blockRepository.save(updated);
    }

    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    public Block getBlockById(UUID id) {
        return blockRepository.findById(id)
                .orElseThrow(() -> new BlockNotFoundException("El bloque no encontrado"));
    }

    public void deleteBlock(UUID id) {
        if(!blockRepository.findById(id).isPresent()) {
            throw  new BlockNotFoundException("Block no encontrado");
        }

        blockRepository.deleteById(id);
    }

    private void validateTerritory(UUID territoryId) {
        if (territoryId == null) {
            throw new TerritoriesInvalidDataException("El ID del territorio no puede ser nulo.");
        }
        if(!territoriesRepository.existsById(territoryId)) {
            throw new TerritoriesRelatedResourceNotFoundException(
                    String.format("No se encontró el territorio con ID %s", territoryId)
            );
        }
    }
}
