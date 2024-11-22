package com.example.demo.Controller;

import java.util.List;

import java.util.Optional;

import com.example.demo.Exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.demo.Model.Student;
import com.example.demo.Service.Student_Service;


@RestController
@RequestMapping
public class Student_Controller  {
	@Autowired
	Student_Service std_repo;
	
	@GetMapping("/stud")
	public List<Student> getStudentalldetails(Model model) {
		List<Student> students = std_repo.getStudentalldetails();
		if(students.isEmpty()) {
			throw new StudentNotFoundException("No Data found in DB");
		}
		else {
//		model.addAttribute("students",students);
			return students;
		}
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id) {
		Optional<Student> student = std_repo.getStudentById(id);
		if (student.isPresent()) {
		System.out.println("Found student: " + student);
		return ResponseEntity.ok(student);
		}
		else {
			System.out.println("Student with id " + id + " not found.");
		throw new StudentNotFoundException("Student with id " + id + " not found.");
		}
		}
	@PostMapping("/stud/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String addstudent(@RequestBody Student student) {
		std_repo.addstudentvalues(student);

		return "Created";
		
	}
	
	
}
