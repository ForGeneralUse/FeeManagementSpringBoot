package com.FeeManagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FeeManagement.entity.Student;
import com.FeeManagement.repository.StudentRepository;
import com.FeeManagement.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	 @Autowired
	 StudentRepository studentRepository;
	 
	 public Student updateStudent(Student student,Integer id) {
	        student.setId(id);
	        return studentRepository.save(student);
	        
	    }
	 public void delete(Student student) {
         studentRepository.delete(student);
    }
	@Override
	public Optional<Student> findById(Integer id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}
	//@Override
	//public Student updateStudent(Student student, Integer id) {
		// TODO Auto-generated method stub
		//return null;
	//}
	@Override
	public Student save(Student student, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Integer id) {
		 studentRepository.deleteById(id);
		
	}
}
