package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {
	public Subject findBySubjectName(String subjectName);
}
