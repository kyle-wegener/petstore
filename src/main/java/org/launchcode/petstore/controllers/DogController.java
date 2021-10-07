package org.launchcode.petstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DogController {

    // GET /dog

    @GetMapping("dog")
    @ResponseBody
    public String bark() {
        return "<html><body>" +
                "<h2>My Dog Page</h2>" +
                "<form action='add' method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Add!' />" +
                "</form>" +
                "</body></html>";
    }

    @PostMapping("add")
    @ResponseBody
    public String respondBack() {
        return "You're here!";
    }

    @GetMapping("dog/{name}")
    @ResponseBody
    public String barkWithName(@PathVariable String name) {
        return name + " Barked!";
    }

    /*@GetMapping("dog")
    @ResponseBody
    public String barkWithNameAsParameter(@RequestParam String name, @RequestParam int age) {
        return name + " Barked and is " + age + " years old!";
    }*/



}
