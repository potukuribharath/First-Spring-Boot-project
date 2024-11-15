package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Student;

public interface Student_Repo extends JpaRepository<Student, Integer> {

}
