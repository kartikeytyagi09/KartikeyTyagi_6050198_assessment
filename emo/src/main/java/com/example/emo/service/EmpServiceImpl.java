package com.example.emo.service;

import com.example.emo.dto.EmpDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    // ✅ In-memory data store
    private static List<EmpDto> list = new ArrayList<>();

    // ✅ ID counter (important to avoid duplicate IDs)
    private static int counter = 4;

    // ✅ Static data initialization
    static {
        list.add(new EmpDto(1, "rama", 45000.0, LocalDate.of(2025, 2, 19), "hr"));
        list.add(new EmpDto(2, "samuel", 65000.0, LocalDate.of(2025, 2, 19), "production"));
        list.add(new EmpDto(3, "akbar", 85000.0, LocalDate.of(2025, 2, 19), "hr"));
    }

    // ✅ Get all employees
    @Override
    public List<EmpDto> getAll() {
        return list;
    }

    // ✅ Get employee by ID
    @Override
    public EmpDto getById(Integer id) {
        return list.stream()
                .filter(e -> e.getEmpId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // ✅ Save OR Update
    @Override
    public void update(EmpDto dto) {

        // 🔴 If ID is null → ADD new employee
        if (dto.getEmpId() == null) {
            dto.setEmpId(counter++);
            list.add(dto);
            return;
        }

        // 🟡 If ID exists → UPDATE
        list.removeIf(e -> e.getEmpId().equals(dto.getEmpId()));
        list.add(dto);
    }

    // ✅ Delete employee
    @Override
    public void delete(Integer id) {
        list.removeIf(e -> e.getEmpId().equals(id));
    }
}