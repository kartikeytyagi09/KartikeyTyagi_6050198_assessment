package com.example.emo.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class EmpDto {

    private Integer empId;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 25, message = "Name must be 3-25 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets allowed")
    private String empName;

    @NotNull(message = "Salary is required")
    @Min(value = 1000, message = "Minimum salary is 1000")
    @Max(value = 500000, message = "Maximum salary is 500000")
    private Double empSal;

    @NotNull(message = "DOJ is required")
    @FutureOrPresent(message = "DOJ must be today or future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate empDoj;

    @NotBlank(message = "Department is required")
    @Pattern(regexp = "^(hr|production)$", message = "Dept must be 'hr' or 'production'")
    private String deptName;

    // ✅ Default constructor
    public EmpDto() {}

    // ✅ Parameterized constructor
    public EmpDto(Integer empId, String empName, Double empSal, LocalDate empDoj, String deptName) {
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
        this.empDoj = empDoj;
        this.deptName = deptName;
    }

    // ✅ Getters & Setters

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public LocalDate getEmpDoj() {
        return empDoj;
    }

    public void setEmpDoj(LocalDate empDoj) {
        this.empDoj = empDoj;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}