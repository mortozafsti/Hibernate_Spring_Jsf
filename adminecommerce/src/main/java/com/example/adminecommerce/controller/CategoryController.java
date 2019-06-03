package com.example.adminecommerce.controller;


import com.example.adminecommerce.entity.Category;
import com.example.adminecommerce.entity.Role;
import com.example.adminecommerce.repo.CategoryRepo;
import com.example.adminecommerce.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {


    @Autowired
    public CategoryRepo categoryRepo;

    @GetMapping(value = "/listcategory")
    public String index(Category category, Model model){
        model.addAttribute("categorylist",this.categoryRepo.findAll());
        return "category/catlist";
    }

    @GetMapping(value = "/addcategorye")
    public String addCategory(Category category){
        return "category/addcategory";
    }

    @PostMapping(value = "/addcategorye")
    public String saveCategory(@Valid Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "category/addcategory";
        }else{
            if (category != null){
                Category category1 = this.categoryRepo.findByCatName(category.getCatName());
                if (category1 != null){
                    model.addAttribute("exitMsg","CategoryName is Allready Exist");
                }else{
                    this.categoryRepo.save(category);
                    model.addAttribute("category",new Category());
                    model.addAttribute("syccessMsg","Category Data Successfully Saved");
                }
            }
        }
        return "category/addcategory";
    }
}
