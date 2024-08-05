package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentRepo;
import com.dao.SubjectRepo;
import com.model.Student;
import com.model.Subject;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepo sr;

	@Autowired
	SubjectRepo sub;

	@Override
	public Student newStudent(Student s) {
		
		
		return sr.save(s);
	}

	
//	List<Subject> s1 = s.getSubject();
//	if (s1 != null) {
//		for (Subject x : s1) {
//			if (sub.findBySubjectName(x.getSubjectName()) == null) {
//				sub.save(new Subject(x.getSubjectName()));
//			}
//		}
//	}

//	if(sub.findBySubjectName(getListOfAllSubject()))
	
	
//	for (Subject x : s.getSubject()) {
//		Subject subject = sub.findBySubjectName(x.getSubjectName());
//		if (subject == null) {
//			continue;
//		}else {
//			sub.save(subject);
//		}
//	}
	
	
	@Override
	public List<Student> getAllStudent() {
		return sr.findAll();
	}

	@Override
	public List<Subject> getAllSubject() {
		return sub.findAll();
	}

	@Override
	public String getListOfAllSubject() {
		String allSubjects = null;
		for (Subject x : sub.findAll()) {
			allSubjects = allSubjects + " " + x.getSubjectName();
		}
		return allSubjects;
	}
}
