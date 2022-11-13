package com.cst.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst.crud.entity.Student;
import com.cst.crud.model.StudentModel;
import com.cst.crud.repository.StudentRepo;
import com.cst.crud.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepo srepo;
	
	@Autowired
	StudentService service;

	@PostMapping("/saveStudent")
	public String saveStudnet(@RequestBody StudentModel model) {
		
		service.saveStudent(model);
		
		return "success";
	}
	
	@GetMapping("/viewStudent")
	public List<Student> viewStudent() {
		
		List<Student> student = srepo.findAll();
		
		return student;
	}
	
	@DeleteMapping("/deleteStudent/{sid}") 
	public List<Student> deleteStudent(@PathVariable Long sid) {
		
		service.deleteStudnet(sid);
		
        List<Student> student = srepo.findAll();
		
		return student;
	}
	
	@PutMapping("/updateStudent")
	
	public String updateStudent(@RequestBody StudentModel model) {
		
		service.updateStudent(model);
		
		Optional<Student> student = srepo.findById(model.getSid());
		
		return "updated record is" + student;
		
	}
}
