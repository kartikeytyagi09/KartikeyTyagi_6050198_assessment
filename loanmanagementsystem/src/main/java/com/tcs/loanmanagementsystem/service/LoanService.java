package com.tcs.loanmanagementsystem.service;

import com.tcs.loanmanagementsystem.entity.Loan;
import java.util.List;

public interface LoanService {

    Loan createLoan(Loan loan);

    List<Loan> getAllLoans();

    Loan getLoanById(Long id);

    Loan updateLoanStatus(Long id, String status);
}