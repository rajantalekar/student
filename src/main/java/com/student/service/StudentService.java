package com.student.service;

import java.util.List;

import com.student.entity.Student;


public interface StudentService {
	void saveStudent(Student user);
	List<Student> getStudents(String name);
	Student getStudent(String usn);
}