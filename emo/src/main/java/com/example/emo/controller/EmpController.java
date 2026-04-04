package com.example.emo.controller;

import com.example.emo.dto.EmpDto;
import com.example.emo.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpController {

    private final EmpService service;

    public EmpController(EmpService service) {
        this.service = service;
    }

    @GetMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("emps", service.getAll());
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("emp", service.getById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("emp") EmpDto dto,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            return "edit";
        }

        service.update(dto);
        model.addAttribute("msg", "Employee Edited Successfully");
        model.addAttribute("emps", service.getAll());
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        service.delete(id);
        model.addAttribute("msg", "Employee Deleted Successfully");
        model.addAttribute("emps", service.getAll());
        return "view";
    }
}