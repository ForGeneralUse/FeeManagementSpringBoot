package com.FeeManagement.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.FeeManagement.entity.Student;

public class ControllerRegister {
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("student", new Student());
	     
	    return "RegistrationForm";
	}
	
	@PutMapping("/register")
	public String porcessRegister()

}
