package com.preaching.preaching_management_backend.domain.exception.block;

public class BlockAlreadyExistsException extends RuntimeException {
    public BlockAlreadyExistsException(String message) {
        super(message);
    }
}
