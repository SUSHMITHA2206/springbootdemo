package com.javafullstack.springbootdemo.repository;

//import java.util.List;

//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafullstack.springbootdemo.model.Professor;
//import com.javafullstack.springbootdemo.model.Student;

@Repository
public interface ProfessorRespository extends JpaRepository<Professor, Long> {

	
}