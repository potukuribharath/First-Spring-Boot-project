package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;
import com.example.demo.Service.Student_Service;

@RestController
@RequestMapping
public class Student_Controller  {
	@Autowired
	Student_Service std_repo;
	
	@GetMapping("/stud")
	public List<Student> getStudentalldetails() {
		return std_repo.getStudentalldetails();
	}
	@GetMapping("/detail")
	public ResponseEntity<?> getStudentById(@RequestParam int id) { 
		Optional<Student> student = std_repo.getStudentById(id);
		if (student.isPresent()) { 
		System.out.println("Found student: " + student); 
		return ResponseEntity.ok(student); 
		} 
		else { 
			System.out.println("Student with id " + id + " not found."); 
		return ResponseEntity.status(404).body("Student not found Id is"+id);
		}
		}
	@PostMapping("/stud/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String addstudent(@RequestBody Student student) {
		std_repo.addstudentvalues(student);

		return "Created";
		
	}
	
	
}
