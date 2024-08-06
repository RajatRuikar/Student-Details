package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentRepo;
import com.dao.SubjectRepo;
import com.model.Student;
import com.model.Subject;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	SubjectRepo subjectRepo;

	@Transactional
	@Override
	public Student newStudent(Student student) {

		List<Subject> existingSubjects = new ArrayList<>();

		for (Subject subject : student.getSubjects()) {
			Subject existingSubject = subjectRepo.findBySubjectName(subject.getSubjectName());
			if (existingSubject != null) {
				existingSubjects.add(existingSubject);
			} else {
				existingSubjects.add(subjectRepo.save(subject));
			}
		}

		student.setSubjects(existingSubjects);
		return studentRepo.save(student);

	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public List<Subject> getAllSubject() {
		return subjectRepo.findAll();
	}

	@Override
	public String getListOfAllSubject() {
		String allSubjects = "";
		for (Subject subject : subjectRepo.findAll()) {
			allSubjects = allSubjects + " " + subject.getSubjectName();
		}
		return allSubjects;
	}
}
