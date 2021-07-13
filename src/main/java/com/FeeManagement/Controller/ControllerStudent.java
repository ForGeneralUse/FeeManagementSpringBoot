package com.FeeManagement.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FeeManagement.entity.Student;
import com.FeeManagement.service.StudentService;

@RestController
@RequestMapping
public class ControllerStudent {
	@Autowired
	private StudentService studentService;

	@PutMapping("/student/{id}")
	Student updateEmployee(@PathVariable Integer id, @RequestBody Student student) {
		Student existingStudent = studentService.findById(id).get();
		if (student.getBranch() != null && student.getBranch().equals("")) {
			existingStudent.setBranch(student.getBranch());
		}
		if (student.getYearOfJoin() != 0) {
			existingStudent.setYearOfJoin(student.getYearOfJoin());
		}
		Student updatedStudent = studentService.save(existingStudent, id);
		return updatedStudent;
	}
	
	@PostMapping("/student/{id}")
	Student addStudent(@PathVariable Integer id,@RequestBody Student student) {
		Student savedStudent = studentService.save(student,id );
		return savedStudent;
	}

	@GetMapping("/student/{id}")
	Student getStudent(@PathVariable Integer id) {
		System.out.println("Inside get method()");
		return studentService.findById(id).get();
	}

	@DeleteMapping("/student/{id}")
	private void delete(@PathVariable Integer id) {
		studentService.delete(id);
	}

	/*
	 * @DeleteMapping("/student/{id}") Map<String, String>
	 * deleteEmployee(@RequestParam Integer id) { Map<String, String> status = new
	 * HashMap<>(); Optional<Student> student = studentService.findById(id); if
	 * (student.isPresent()) { studentService.delete(student.get());
	 * status.put("Status", "student deleted successfully"); } else {
	 * status.put("Status", "Student not exist"); } return status; }
	 */

}
