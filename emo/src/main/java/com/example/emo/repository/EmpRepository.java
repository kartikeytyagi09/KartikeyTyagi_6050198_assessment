package com.example.emo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.emo.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp , Integer> {
	
}