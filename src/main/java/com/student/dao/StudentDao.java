package com.student.dao;

import java.util.List;

import com.student.entity.Student;

public interface StudentDao {
	void saveStudent(Student student);
	List<Student> getStudents(String name);
	Student getStudent(String usn);
}
