package com.example.classtest2.controller;

import com.example.classtest2.entity.Role;
import com.example.classtest2.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;
//
    @GetMapping(value = "/rolelist")
    public String index(Model model){
        model.addAttribute("rolelist",this.roleRepo.findAll());
        return "role/listrole";
    }

    @GetMapping(value = "/addrolee")
    public String addRole(Role role){
        return "role/addrole";
    }

    @PostMapping(value = "/addrolee")
    public String roleSave(@Valid Role role, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "role/addrole";
        }else {
            if (role != null){
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null){
                    model.addAttribute("exitMsg","RoleName is Already Exist");
                }else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("syccessMsg","A Success");
                }
            }

        }
        return "role/addrole";
    }
    @GetMapping(value = "/roleedit/{id}")
    public String editViewr(@PathVariable("id") Long id, Model model){
        model.addAttribute("role",this.roleRepo.getOne(id));
        return "role/roleedit";
    }

    @PostMapping(value = "/roleedit/{id}")
    public String roleEdit(@Valid Role role, BindingResult bindingResult,Model model,@PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "role/roleedit";
        }else {
            if (role != null){
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null){
                    model.addAttribute("exitMsg","RoleName is Already Exist");
                }else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("syccessMsg","A Updated");
                }
            }

        }
        return "role/roleedit";
    }
    @GetMapping(value = "/delr/{id}")
    public String deleterole(Model model, @PathVariable("id") Long id){
        if (id != null){
            this.roleRepo.deleteById(id);
        }
        return "redirect:/role/rolelist";
    }


//    @GetMapping(value = "role-save")
//    public String saveRole(){
//
//        Role role = new Role();
//        role.setRoleName("SUPERADMIN");
//        roleRepo.save(role);
//
//        Role role1 = new Role();
//        role1.setRoleName("ADMIN");
//        roleRepo.save(role1);
//
//        Role role2 = new Role();
//        role2.setRoleName("USER");
//        roleRepo.save(role2);
//
//       return "success";
//
//    }
}
