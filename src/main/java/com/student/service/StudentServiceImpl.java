package com.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.entity.Student;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	@Override
	public List<Student> getStudents(String name) {
		return studentDao.getStudents(name);
	}

	@Override
	public Student getStudent(String usn) {
		return studentDao.getStudent(usn);
	}

}
