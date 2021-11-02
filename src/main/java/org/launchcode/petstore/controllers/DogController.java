package org.launchcode.petstore.controllers;

import org.launchcode.petstore.data.DogData;
import org.launchcode.petstore.data.DogRepository;
import org.launchcode.petstore.data.OwnerRepository;
import org.launchcode.petstore.models.Dog;
import org.launchcode.petstore.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("dog")
public class DogController {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("create")
    public String createDog(Model model) {
        model.addAttribute("dog", new Dog(null));
        model.addAttribute("owners", ownerRepository.findAll());
        return "dog/create";
    }

    @PostMapping("create")
    public String saveADog(@ModelAttribute @Valid Dog dog, int ownerId, Errors errors) {

        Optional<Owner> owner = ownerRepository.findById(ownerId);
        if (owner.isEmpty()) {
            return "dog/create";
        }
        if (errors.hasErrors()) {
            return "dog/create";
        }
        dog.setOwner(owner.get());
        owner.get().getDogs().add(dog);
        // DogData.addDog(dog);
        dogRepository.save(dog);
        return "redirect:/";
        // return "redirect:/show";
    }



}
