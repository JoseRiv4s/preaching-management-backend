package com.preaching.preaching_management_backend.domain.exception.block;

public class BlockNotFoundException extends RuntimeException {
    public BlockNotFoundException(String message) {
        super(message);
    }
}
