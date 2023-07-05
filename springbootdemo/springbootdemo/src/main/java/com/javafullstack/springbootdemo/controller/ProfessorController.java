package com.javafullstack.springbootdemo.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstack.springbootdemo.exception.ResourceNotFoundException;
import com.javafullstack.springbootdemo.model.Professor;

import com.javafullstack.springbootdemo.repository.ProfessorRespository;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2")
public class ProfessorController {

	@Autowired
	private ProfessorRespository proRepository;

	// get all employees
	@GetMapping("/professors")
	public List<Professor> getAllProfessor() {
		return proRepository.findAll();
	}

	// create employee rest api
	@PostMapping("/professors")
	public Professor createProfessor(@RequestBody Professor professors) {
//		students.setTotal(students.getTel()+students.getHindi()+students.getEng()+students.getMaths()+students.getSci()+students.getSocial());
		return proRepository.save(professors);
	}
	// create employee rest api
		@PostMapping("/professorsAll")
		public List<Professor> createProfessor(@RequestBody List<Professor> professors) {
//			students.setTotal(students.getTel()+students.getHindi()+students.getEng()+students.getMaths()+students.getSci()+students.getSocial());
			return proRepository.saveAll(professors);
		}

	// get employee by id rest api
	@GetMapping("/professors/{id}")
	public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
		Professor professors = proRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor not exist with id :" + id));
		return ResponseEntity.ok(professors);
	}

	// update employee rest api

	@PutMapping("/professors/{id}")
	public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professorDetails) {
		Professor professors = proRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor not exist with id :" + id));

		professors.setProfessorName(professorDetails.getProfessorName());
		professors.setSubject(professorDetails.getSubject());
		professors.setProfessorId(professorDetails.getProfessorId());
		professors.setCollege(professorDetails.getCollege());
		Professor updatedProfessor = proRepository.save(professors);
		return ResponseEntity.ok(updatedProfessor);
	}
	
	

	// delete employee rest api
	@DeleteMapping("/professors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProfession(@PathVariable Long id) {
		Professor professors = proRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("professor not exist with id :" + id));

		proRepository.delete(professors);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}