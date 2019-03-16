package com.coderbd.controller;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderbd.entity.Student;
import com.coderbd.repository.StudentRepo;

@Controller
public class HomeController {
	

	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/")
	public String index(Model model) {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		Student thestudent = new Student();
		model.addAttribute("student", thestudent);
		return "login";
	}
	
	@PostMapping("/login")
	public String loginadd(@RequestParam("email") String email,Model model) {
		
		if(email != null) {
			try {
				Student thestudent = this.repo.findByEmail(email); 
				if(thestudent.getEmail() != null) {
					return "redirect:/student/list";				
				}else {
					model.addAttribute("rejectMsg","Enter Valid Email");
					return "login";
				}
			} catch (NullPointerException e) {
				model.addAttribute("rejectMsg","Enter Valid Email");
				return "login";
			}
			
		}
		
		return "login";
	}
	
	
}
