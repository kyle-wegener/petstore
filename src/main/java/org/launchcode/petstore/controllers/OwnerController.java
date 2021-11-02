package org.launchcode.petstore.controllers;

import org.launchcode.petstore.data.DogRepository;
import org.launchcode.petstore.data.OwnerRepository;
import org.launchcode.petstore.models.Dog;
import org.launchcode.petstore.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("create")
    public String createDog(Model model) {
        model.addAttribute("owner", new Owner(null));
        return "owner/create";
    }

    @PostMapping("create")
    public String saveADog(@ModelAttribute @Valid Owner dog, Errors errors) {
        if (errors.hasErrors()) {
            return "owner/create";
        }
        // DogData.addDog(dog);
        ownerRepository.save(dog);
        return "redirect:/";
        // return "redirect:/show";
    }



}
