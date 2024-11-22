package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.Student_Repo;
@Service
public class StudentServiceImpl implements Student_Service{
	@Autowired
	Student_Repo repo;

	@Override
	public List<Student> getStudentalldetails() {
		
		return repo.findAll();
	}

	@Override
	public Student addstudentvalues(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		
		return repo.findById(id);
	}
	public Optional<Student> getStudentById(Integer id) {
		return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id)));
	}



}
