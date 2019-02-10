package com.example.mvccrud.Controller;

import com.example.mvccrud.Entity.Student;
import com.example.mvccrud.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/add")
    public String showForm( Student student){
        return "add";
    }
    @GetMapping("/edit/{id}")
    public String editView(Model model,@PathVariable("id") Long id){
        model.addAttribute("student",this.studentRepo.getOne(id));
        return "edit";
    }
    @PostMapping("/add")
    public String doSave(@Valid Student student, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add";
        }
        this.studentRepo.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("msg","Data Saved Successfully");
        return "add";
    }
    @PostMapping("/edit/{id}")
    public String doEdit(@Valid Student student, BindingResult bindingResult, Model model,@PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "edit";
        }
        this.studentRepo.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("msg","Data Edit Successfully");
        return "redirect:/";
    }
    @GetMapping("/result")
    public String showResult(){
        return "result";
    }

    @GetMapping(value = "/")
    public String index(Model  model){
        model.addAttribute("list",this.studentRepo.findAll());
        return "index";
    }
    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
       if (id != null){
           this.studentRepo.deleteById(id);
           model.addAttribute("delmsg","Delete A Student Successfully");
       }
        return "redirect:/";
    }

//    @GetMapping(value = "/")
//    public ModelAndView index(){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("student", new Student());
//        mv.setViewName("index");
//        return mv;
//
//    }
//
//    @PostMapping(value = "/")
//    public ModelAndView doSave(@Valid Student student){
//        ModelAndView model = new ModelAndView();
//        if (student != null){
//            this.studentRepo.save(student);
//            model.addObject("student", new Student());
//            model.addObject("msg","Saved Successfully");
//
//        }
//        model.setViewName("index");
//        return model;
//    }
}
