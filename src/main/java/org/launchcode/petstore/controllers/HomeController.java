package org.launchcode.petstore.controllers;

import org.launchcode.petstore.data.CatData;
import org.launchcode.petstore.data.CatRepository;
import org.launchcode.petstore.data.DogData;
import org.launchcode.petstore.data.DogRepository;
import org.launchcode.petstore.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    CatRepository catRepository;



    @GetMapping()
    public String createHomePage(Model model) {
        model.addAttribute("dogs", dogRepository.findAll());
        model.addAttribute("cats", catRepository.findAll());
        return "index";
    }
}
