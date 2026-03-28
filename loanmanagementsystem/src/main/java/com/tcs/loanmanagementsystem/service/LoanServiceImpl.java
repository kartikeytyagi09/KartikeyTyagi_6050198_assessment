package com.tcs.loanmanagementsystem.service;

import com.tcs.loanmanagementsystem.entity.Loan;
import com.tcs.loanmanagementsystem.exception.*;
import com.tcs.loanmanagementsystem.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repo;

    // ✅ Manual constructor (fix)
    public LoanServiceImpl(LoanRepository repo) {
        this.repo = repo;
    }

    @Override
    public Loan createLoan(Loan loan) {

        if (loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 5000000) {
            throw new InvalidLoanAmountException("Loan amount must be between 1 and 5000000");
        }

        repo.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING")
                .ifPresent(l -> {
                    throw new DuplicateLoanApplicationException("User already has a pending loan");
                });

        loan.setStatus("PENDING");
        return repo.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return repo.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found with id: " + id));
    }

    @Override
    public Loan updateLoanStatus(Long id, String status) {

        Loan loan = getLoanById(id);

        if (!status.equals("APPROVED") && !status.equals("REJECTED")) {
            throw new RuntimeException("Invalid status value");
        }

        loan.setStatus(status);
        return repo.save(loan);
    }
}