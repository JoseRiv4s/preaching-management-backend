package com.preaching.preaching_management_backend.shared.exception;

import com.preaching.preaching_management_backend.domain.exception.block.BlockAlreadyExistsException;
import com.preaching.preaching_management_backend.domain.exception.block.BlockInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.block.BlockNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.captain.CaptainAlreadyExistsException;
import com.preaching.preaching_management_backend.domain.exception.captain.CaptainInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.captain.CaptainNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.preachedBlock.PreachedBlockAlreadyExistsException;
import com.preaching.preaching_management_backend.domain.exception.preachedBlock.PreachedBlockInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.preachedBlock.PreachedBlockNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.preachedBlock.PreachedBlockRelatedResourceNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantAlreadyExistsException;
import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.preachingParticipants.ParticipantNotFoundException;
import com.preaching.preaching_management_backend.domain.exception.publisher.PublisherAlreadyExistsException;
import com.preaching.preaching_management_backend.domain.exception.publisher.PublisherInvalidDataException;
import com.preaching.preaching_management_backend.domain.exception.publisher.PublisherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // CAPTAIN
    // NOT FOUND
    @ExceptionHandler(CaptainNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(CaptainNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // BAD REQUEST (datos inválidos)
    @ExceptionHandler(CaptainInvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidData(CaptainInvalidDataException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // BAD REQUEST (duplicados)
    @ExceptionHandler(CaptainAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAlreadyExists(CaptainAlreadyExistsException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // PUBLISHERS
    @ExceptionHandler(PublisherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePublisherNotFound(PublisherNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PublisherInvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePublisherInvalidData(PublisherInvalidDataException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PublisherAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePublisherAlreadyExists(PublisherAlreadyExistsException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // BLOCK
    @ExceptionHandler(BlockNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePublisherNotFound(BlockNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlockInvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePublisherInvalidData(BlockInvalidDataException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlockAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePublisherAlreadyExists(BlockAlreadyExistsException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // PREACHING PARTICIPANT
    @ExceptionHandler(ParticipantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePreachingParticipantNotFound(ParticipantNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParticipantInvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePreachingParticipantInvalidData(ParticipantInvalidDataException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParticipantAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePreachingParticipantAlreadyExists(ParticipantAlreadyExistsException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // PREACHED BLOCK
    @ExceptionHandler(PreachedBlockNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePreachedBlockNotFound(PreachedBlockNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PreachedBlockInvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePreachedBlockInvalidData(PreachedBlockInvalidDataException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PreachedBlockAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePreachedBlockAlreadyExists(PreachedBlockAlreadyExistsException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PreachedBlockRelatedResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePreachedBlockRelatedResourceNotFound(PreachedBlockRelatedResourceNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // VALIDACIONES (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ValidationErrorResponse.builder()
                .message("Error de validación")
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }

    // GENERAL
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneral(Exception ex) {
        return buildResponse("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Método reutilizable
    private ErrorResponse buildResponse(String message, HttpStatus status) {
        return ErrorResponse.builder()
                .message(message)
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .build();
    }
}