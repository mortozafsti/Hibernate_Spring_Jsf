package com.coderbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderbd.entity.Student;
import com.coderbd.exception.ResourceNotFoundException;
import com.coderbd.repository.StudentRepo;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/list")
	public String listStudent(Model model) {
		model.addAttribute("studentlist", this.repo.findAll());
		return "student-list";
	}
	
	
	@GetMapping("/showForm")
	public String saveStuView(Model model) {
		Student thestudent = new Student();
		model.addAttribute("student", thestudent);
		return "student-form";
	}
	
	@PostMapping("/showForm")
	public String saveStu(@ModelAttribute("student") Student thestudent) {
		this.repo.save(thestudent);
		return "redirect:/student/list";
		
	}	
	
	@GetMapping(value="/updateForm")
	public String edit(@RequestParam("studentId") Long id, Model model) throws ResourceNotFoundException {
		Student thestudent = repo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
		this.repo.save(thestudent);
		model.addAttribute("student",thestudent);
		return "/student-form";
	}
	
	@GetMapping(value="/delete")
	public String del(@RequestParam("studentId") Long id) throws ResourceNotFoundException {
		repo.deleteById(id); 
		return "redirect:/student/list";
	}
}
