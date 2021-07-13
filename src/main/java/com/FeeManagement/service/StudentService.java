package com.FeeManagement.service;

import java.util.Optional;

import com.FeeManagement.entity.Student;

public interface StudentService {
	Optional<Student> findById(Integer id);
	void delete(Student student);
	Student  save(Student student,Integer id);
	void delete(Integer id);
}
