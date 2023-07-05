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
import com.javafullstack.springbootdemo.model.College;

import com.javafullstack.springbootdemo.repository.CollegeRepository;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v3")
public class 	CollegeController {

	@Autowired
	private CollegeRepository clgRepository;

	// get all colleges
	@GetMapping("/colleges")
	public List<College> getAllCollege() {
		return clgRepository.findAll();
	}

	// create college rest api
	@PostMapping("/colleges")
	public College createCollege(@RequestBody College colleges) {
		return clgRepository.save(colleges);
	}

	// get college by id rest api
	@GetMapping("/colleges/{id}")
	public ResponseEntity<College> getProfessorById(@PathVariable Long id) {
		College colleges = clgRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("College not exist with id :" + id));
		return ResponseEntity.ok(colleges);
	}

	// update college rest api

	@PutMapping("/colleges/{id}")
	public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College collegeDetails) {
		College colleges = clgRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("College not exist with id :" + id));

		colleges.setCollegeName(collegeDetails.getCollegeName());
		colleges.setDepartment(collegeDetails.getDepartment());
		College updatedCollege = clgRepository.save(colleges);
		return ResponseEntity.ok(updatedCollege);
	}
	
	

	// delete college rest api
	@DeleteMapping("/colleges/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCollege(@PathVariable Long id) {
		College colleges = clgRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("College not exist with id :" + id));

		clgRepository.delete(colleges);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}