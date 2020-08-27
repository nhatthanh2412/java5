package com.example.demoJ5springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoJ5springboot.entity.Users;



public interface UsersRepository extends JpaRepository<Users, String>{

}
