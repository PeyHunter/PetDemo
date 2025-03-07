package com.example.petdemo.controller;

import com.example.petdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetController {

    @Autowired
    private AnimalManager animalManager;

    @PostMapping("/pet-added")
    public String createPet(
            @RequestParam String petName,
            @RequestParam int age,
            @RequestParam String species,
            Model model) {

        Animal pet = null;

        switch (species) {
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

        animalManager.addAnimail(pet);
        model.addAttribute("pet", pet);
        model.addAttribute("animals", animalManager.getAnimals());
        return "pet-added";
    }


    @GetMapping("/pet-added")
    public String showAddedPets(Model model) {
        model.addAttribute("animals", animalManager.getAnimals());
        return "pet-added";
    }
}