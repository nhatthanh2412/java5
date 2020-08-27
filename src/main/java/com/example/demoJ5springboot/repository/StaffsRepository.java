package com.example.demoJ5springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demoJ5springboot.entity.Staffs;



public interface StaffsRepository extends JpaRepository<Staffs, String>{
	
}
