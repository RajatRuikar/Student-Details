package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String studentName;
	private String studentAddress;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Subject> subject;

	public Student() {
		super();
	}

	public Student(String studentName, String studentAddress, List<Subject> subject) {
		super();
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.subject = subject;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

}
