package com.preaching.preaching_management_backend.application.service;

import com.preaching.preaching_management_backend.domain.exception.block.BlockInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.block.BlockNotFoundException;
import com.preaching.preaching_management_backend.domain.model.Block;
import com.preaching.preaching_management_backend.domain.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockRepository blockRepository;

    public Block createBlock(Block block) {

        if (block.getBlockNumber() == null || block.getBlockNumber().isBlank()){
            throw new BlockInvalidDataException("El número del bloque es obligatorio");
        }

        return blockRepository.save(block);
    }

    public Block updateBlock (UUID id, Block block) {

        Block existing = blockRepository.findById(id)
                .orElseThrow(() -> new BlockNotFoundException("El bloque no encontrado"));

        if (block.getBlockNumber() == null || block.getBlockNumber().isBlank()){
            throw new BlockInvalidDataException("El número del bloque es obligatorio");
        }

        Block updated = Block.builder()
                .id(existing.getId())
                .blockNumber(block.getBlockNumber())
                .status(block.getStatus())
                .notes(block.getNotes())
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
}
