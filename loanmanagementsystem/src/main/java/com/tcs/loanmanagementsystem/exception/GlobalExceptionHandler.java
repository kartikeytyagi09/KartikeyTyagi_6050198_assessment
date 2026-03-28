package com.tcs.loanmanagementsystem.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLoanAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidAmount(InvalidLoanAmountException ex) {
        return new ErrorResponse("InvalidLoanAmountException", ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(DuplicateLoanApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDuplicate(DuplicateLoanApplicationException ex) {
        return new ErrorResponse("DuplicateLoanApplicationException", ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(LoanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(LoanNotFoundException ex) {
        return new ErrorResponse("LoanNotFoundException", ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneral(Exception ex) {
        return new ErrorResponse("Exception", ex.getMessage(), LocalDateTime.now());
    }
}