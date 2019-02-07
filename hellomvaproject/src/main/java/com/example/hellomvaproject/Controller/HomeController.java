package com.example.hellomvaproject.Controller;

import com.example.hellomvaproject.Entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

   static List<User> list;

    static {
        list =  new ArrayList<>();
        list.add(new User(1L,"Mortoza","123562"));
        list.add(new User(2L,"Shakil","52639633"));
        list.add(new User(3L,"Mahabub","9494555"));
        list.add(new User(4L,"Munna","6369"));
    }

    @GetMapping(value = "/")
    public String home(){
        return "Home MVC";
    }
    @GetMapping(value = "/test")
    public String test(){
        return " Hello Home Mortoza MVC";
    }
    @GetMapping(value = "/list")
    public List<User> getLis(){

        return this.list;
    }

    @GetMapping(value = "/user")
    public User getUser(){

        return new User(1L,"Mortoza","123562");
//        User user = new User();
//        user.setId(123L);
//        user.setUsername("Mortoza");
//        user.setPassword("12333333");
//
//        return user;
    }
    @GetMapping(value = "user/{id}/{password}")
    public User getUserById(@PathVariable("id") Long id, @PathVariable("password") String m){
        User user = null;
        for(User u : this.list){
            if (id == u.getId() && m.equalsIgnoreCase(u.getPassword())){
                user = new User();
              user = new User(u.getId(),u.getUsername(), u.getPassword());
            }
        }
        return user;
    }
    @GetMapping(value = "/adduser")
    public List<User> addListToList(){
        list.add(new User(1L,"G M Mortoza Ahmed","123562"));
        return list;
    }

    long id = list.size();
    @GetMapping(value = "/add/{username}/{password}")
    public List<User> addListToListDunamically(@PathVariable("username") String name,@PathVariable("password") String p){
        id++;
        list.add(new User( id, name, p));
        return list;
    }

    @GetMapping(value = "/del/{id}")
    public List<User> removeafromListDunamically(@PathVariable("id") Long id){

        list.remove(id);
        return list;
    }

    ///////////////////////Extra Helper Method////////////////////////
    public User getUserByI(Long id){
        User user = null;
        for(User u : this.list){
            if (id == u.getId()){
                user = new User();
                user = new User(u.getId(),u.getUsername(), u.getPassword());
            }
        }
        return user;
    }

}
