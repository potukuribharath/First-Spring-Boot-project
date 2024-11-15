package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stud")
public class Student {
	
	@Id
	private int id;
	@Column(name="Std_name")
	private String student_name;
	@Column(name="std_data")
	private String student_data;
	
	public Student(int id, String student_name, String student_data) {
		this.id = id;
		this.student_name = student_name;
		this.student_data = student_data;
	}
	
	public Student() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_data() {
		return student_data;
	}
	public void setStudent_data(String student_data) {
		this.student_data = student_data;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", student_name=" + student_name + ", student_data=" + student_data + "]";
	}
	
	
	
}
