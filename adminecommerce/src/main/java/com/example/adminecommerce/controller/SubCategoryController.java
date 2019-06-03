package com.example.adminecommerce.controller;


import com.example.adminecommerce.entity.Subcategory;
import com.example.adminecommerce.repo.CategoryRepo;
import com.example.adminecommerce.repo.SubcategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/scategory")
public class SubCategoryController {

    @Autowired
    private SubcategoryRepo subcategoryRepo;

    @Autowired
    public CategoryRepo categoryRepo;

    @GetMapping(value = "/slistcategory")
    public String index(Subcategory subcategory, Model model){
        model.addAttribute("scategorylist",this.subcategoryRepo.findAll());
        return "subcategory/subcatlist";
    }

    @GetMapping(value = "/addsubcategorye")
    public String addCategory(Subcategory subcategory){
        return "subcategory/addsubcategory";
    }

    @PostMapping(value = "/addsubcategorye")
    public String saveCategory(@Valid Subcategory subcategory, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "subcategory/addsubcategory";
        }else{
            if (subcategory != null){
                Subcategory subcategory1 = this.subcategoryRepo.findBySubcatName(subcategory.getSubcatName());
                if (subcategory1 != null){
                    model.addAttribute("exitMsg","SubCategoryName is Allready Exist");
                }else{
                    this.subcategoryRepo.save(subcategory);
                    model.addAttribute("subcategory",new Subcategory());
                    model.addAttribute("syccessMsg","SubCategory Data Successfully Saved");
                }
            }
        }
        return "subcategory/addsubcategory";
    }
}
