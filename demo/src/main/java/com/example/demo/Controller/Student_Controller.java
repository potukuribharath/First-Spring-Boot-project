package com.example.demo.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ui.Model;

import com.example.demo.Model.Student;
import com.example.demo.Service.Student_Service;


@Controller
@RequestMapping
public class Student_Controller  {
	@Autowired
	Student_Service std_repo;
	
	@GetMapping("/stud")
	public String getStudentalldetails(Model model) {
		List<Student> students = std_repo.getStudentalldetails(); 
		model.addAttribute("students",students);
		return "Studentview";
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
