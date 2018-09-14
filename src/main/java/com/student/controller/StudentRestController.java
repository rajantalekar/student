package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/student", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String saveStudent(@RequestBody Student body){
		studentService.saveStudent(body);
		return "Done!";
	}
	
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getStudents(@PathVariable("name") String name){
		return studentService.getStudents(name);
	}
	
	@RequestMapping(value = "/student/{usn}", method = RequestMethod.GET)
	@ResponseBody
	public Student getStudent(@PathVariable("usn") String usn){
		return studentService.getStudent(usn);
	}
}
