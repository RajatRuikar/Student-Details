package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.model.Subject;
import com.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

	@Autowired
	StudentService ss;
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student s) {
		return ss.newStudent(s);
	}
	
	@GetMapping("/getstudents")
	public List<Student> getAllStudent() {
		return ss.getAllStudent();
	}
	
	@GetMapping("/getallsubject")
	public List<Subject> getAllSubject() {
		return ss.getAllSubject();
	}
	
	@GetMapping("/listofallsubjects")
	public String getAllSubjectName() {
		return ss.getListOfAllSubject();
	}
	
}
