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
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("")
public class StudentController {

	@Autowired
	StudentService studentService;
	
//	http://localhost:8080/
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome Page";
	}
	
//	http://localhost:8080/addstudent
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student s) {
		return studentService.newStudent(s);
	}
	
//	http://localhost:8080/getstudents
	@GetMapping("/getstudents")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
//	http://localhost:8080/getallsubject
	@GetMapping("/getallsubject")
	public List<Subject> getAllSubject() {
		return studentService.getAllSubject();
	}
	
//	http://localhost:8080/listofallsubjects
	@GetMapping("/listofallsubjects")
	public String getAllSubjectName() {
		return studentService.getListOfAllSubject();
	}
	
}
