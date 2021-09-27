package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import java.util.List;

@RestController
public class StudentController {
	
	@Autowired
	public StudentRepository studentRepository;
	
	
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		
		
		return studentRepository.findAll();
	}
	
	@PostMapping("/create")
	public String createStudent(@RequestBody Student student) {
		
		Student insertedStudent = studentRepository.insert(student);
		
		return "student created succesfully..."+insertedStudent.getName();
	}

}
