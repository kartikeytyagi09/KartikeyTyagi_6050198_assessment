package com.tcs.loanmanagementsystem.exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String msg) {
        super(msg);
    }
}