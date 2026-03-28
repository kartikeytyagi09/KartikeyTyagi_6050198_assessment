package com.tcs.loanmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tcs.loanmanagementsystem.entity.Loan;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByApplicantNameAndStatus(String applicantName, String status);
}