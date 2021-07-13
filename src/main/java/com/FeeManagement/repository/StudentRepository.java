package com.FeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FeeManagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
