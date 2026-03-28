package com.tcs.loanmanagementsystem.exception;

public class DuplicateLoanApplicationException extends RuntimeException {
    public DuplicateLoanApplicationException(String msg) {
        super(msg);
    }
}