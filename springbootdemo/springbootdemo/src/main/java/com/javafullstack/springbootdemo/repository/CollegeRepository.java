package com.javafullstack.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafullstack.springbootdemo.model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

	
}