package com.example.chaining.controller;

import com.example.chaining.entity.City;
import com.example.chaining.entity.Country;
import com.example.chaining.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private CityRepo cityRepo;

    static List<City> cityList;

    @GetMapping(value = "/city")
    public List<City> countrySingle(Model model, @RequestParam("id")  Long id){
        System.out.println("ID: "+ id);
        List<City> list = this.cityRepo.findAllByCountry(new Country(id));
        return list;
    }
}
