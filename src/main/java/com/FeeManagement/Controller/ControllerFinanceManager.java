package com.FeeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FeeManagement.entity.Student;
import com.FeeManagement.service.StudentService;

public class ControllerFinanceManager {
	@RestController
	@RequestMapping
	public class ControllerStudent {
		@Autowired
		private StudentService studentService;

		@PutMapping("/updatestudent/{id}")
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
		
		@PostMapping("/updatestudent/{id}")
		Student addStudent(@PathVariable Integer id,@RequestBody Student student) {
			Student savedStudent = studentService.save(student,id );
			return savedStudent;
		}

		@GetMapping("/updatestudent/{id}")
		Student getStudent(@PathVariable Integer id) {
			System.out.println("Inside get method()");
			return studentService.findById(id).get();
		}

		@DeleteMapping("/updatestudent/{id}")
		private void delete(@PathVariable Integer id) {
			studentService.delete(id);
		}
}
}
