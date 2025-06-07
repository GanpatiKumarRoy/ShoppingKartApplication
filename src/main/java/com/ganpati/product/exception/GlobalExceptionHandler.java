package com.ganpati.product.exception;

import com.ganpati.product.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Explicitly handling the exception error for CategoryAlreadyExistsException:-
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException e, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
    }

    // Explicitly handling the exception error for CategoryNotFoundException:-
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryNotExistsException(CategoryNotFoundException e, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }

    // Explicitly handling the exception error for ProductNotFoundException:-
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleProductNotFoundException(ProductNotFoundException e, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }

    // If any lines give the exception which is not explicitly handled as above then this will catch and through the error details in response.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleGlobalException(Exception e, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
    }
}