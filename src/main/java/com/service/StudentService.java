package com.service;

import java.util.List;

import com.model.Student;
import com.model.Subject;

public interface StudentService {
	public Student newStudent(Student s);
	
	public List<Student> getAllStudent();
	
	public List<Subject> getAllSubject();
	
	public String getListOfAllSubject();
}
