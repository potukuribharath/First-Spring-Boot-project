package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Student;

public interface Student_Service {
	List<Student> getStudentalldetails();
	Student addstudentvalues(Student student);
	Optional<Student> getStudentById(int id);
	
	

}
