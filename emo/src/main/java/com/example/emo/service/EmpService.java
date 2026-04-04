package com.example.emo.service;


import java.util.List;
import com.example.emo.dto.EmpDto;

public interface EmpService {
    List<EmpDto> getAll();
    EmpDto getById(Integer id);
    void update(EmpDto dto);
    void delete(Integer id);


}
