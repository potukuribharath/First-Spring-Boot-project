package com.example.demo.Repository;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Student;

import java.util.Optional;

public interface Student_Repo extends JpaRepository<Student, Integer> {

    Optional<Object> findById(int id, Limit limit);
}
