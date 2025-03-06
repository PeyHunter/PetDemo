package com.example.petdemo.controller;

import com.example.petdemo.model.Animal;
import com.example.petdemo.model.Horse;
import com.example.petdemo.model.Dog;
import com.example.petdemo.model.Cat;
import com.example.petdemo.model.Hamster;
import com.example.petdemo.model.Rabbit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetController
{

    @GetMapping("/pet-added")
    public String showPetAdded() {
        return "pet-added";  // This should match the filename in src/main/resources/templates/
    }

    @PostMapping("/pet-added")
    public String createPet(
            @RequestParam String petName,
            @RequestParam int age,
            @RequestParam String species,
            Model model)
    {
        Animal pet = null;

        switch (species)
        {
            case "Dog":
                pet = new Dog(petName, age);
                break;
            case "Cat":
                pet = new Cat(petName, age);
                break;
            case "Horse":
                pet = new Horse(petName, age);
                break;
            case "Hamster":
                pet = new Hamster(petName, age);
                break;
            case "Rabbit":
                pet = new Rabbit(petName, age);
                break;
            default:
                throw new IllegalArgumentException("Unknown species: " + species);
        }

        model.addAttribute("pet", pet);
        return "pet-added"; // Direct return, no redirect
    }


}
