package com.tcs.loanmanagementsystem.controller;

import com.tcs.loanmanagementsystem.entity.Loan;
import com.tcs.loanmanagementsystem.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService service;

    
    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return service.createLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return service.getLoanById(id);
    }

    @PutMapping("/{id}/status")
    public Loan updateStatus(@PathVariable Long id,
                             @RequestBody Loan request) {
        return service.updateLoanStatus(id, request.getStatus());
    }
}