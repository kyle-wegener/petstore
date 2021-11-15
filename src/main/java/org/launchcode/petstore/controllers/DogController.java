package org.launchcode.petstore.controllers;

import org.launchcode.petstore.data.DogData;
import org.launchcode.petstore.data.DogRepository;
import org.launchcode.petstore.data.OwnerRepository;
import org.launchcode.petstore.data.ToyRepository;
import org.launchcode.petstore.data.dtos.DogToyDTO;
import org.launchcode.petstore.models.Dog;
import org.launchcode.petstore.models.Owner;
import org.launchcode.petstore.models.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("dog")
public class DogController {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    ToyRepository toyRepository;

    @GetMapping("create")
    public String createDog(Model model) {
        model.addAttribute("dog", new Dog(null));
        model.addAttribute("owners", ownerRepository.findAll());
        return "dog/create";
    }

    @GetMapping("add-toy")
    public String createToy(@RequestParam Integer dogId, Model model) {
        Optional<Dog> dogOptional = dogRepository.findById(dogId);
        Dog dog = null;
        if (!dogOptional.isEmpty()) {
            dog = dogOptional.get();
        }

        DogToyDTO dogToy = new DogToyDTO();
        dogToy.setToy(new Toy());
        dogToy.setDog(dog);

        model.addAttribute("dogToy", dogToy);
        return "dog/create-toy";
    }

    @PostMapping("add-toy")
    public String saveAToy(@ModelAttribute DogToyDTO dogToy) {

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(dogToy.getDog());
        dogToy.getToy().setDogs(null);

        /* toyRepository.save(toy);
        Dog dog = dogOptional.get();

        // Related them together\
        if (toy.getDogs() == null) {
            ArrayList<Dog> dogs = new ArrayList<>();
            dogs.add(dog);
            toy.setDogs(dogs);
        } else {
            toy.getDogs().add(dog);
        }

        if (dog.getToys() == null) {
            ArrayList<Toy> toys = new ArrayList<>();
            toys.add(toy);
            dog.setToys(toys);
        } else {
            dog.getToys().add(toy);
        } */


        // DogToyDTO dogToy = new DogToyDTO();
        // dogToy.setDog(dog);
        // dogToy.setToy(toy);

        toyRepository.save(dogToy.getToy());
        dogRepository.save(dogToy.getDog());

        return "dog/create-toy";
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
