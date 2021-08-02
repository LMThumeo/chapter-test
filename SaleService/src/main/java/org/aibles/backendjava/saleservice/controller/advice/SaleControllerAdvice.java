package org.aibles.backendjava.saleservice.controller.advice;


import lombok.extern.slf4j.Slf4j;
import org.aibles.backendjava.saleservice.exception.common.SaleServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class SaleControllerAdvice {

    @ExceptionHandler(value = SaleServiceException.class)
    public ResponseEntity<String> StudentServiceExceptionHandle(SaleServiceException e) {
        return new ResponseEntity<>(
                e.getSaleServiceError().getErrorMessage(),
                HttpStatus.valueOf(e.getSaleServiceError().getErrorCode())
        );
    }
}
