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

    // This method handles displaying the "Pet Added" page after the pet is created
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

        animalManager.addAnimail(pet); // Add the pet to the list of animals
        model.addAttribute("pet", pet);
        model.addAttribute("animals", animalManager.getAnimals()); // Pass the list of animals to the view
        return "pet-added"; // Thymeleaf template for pet added page
    }

    // This method renders the page that displays added pets (after a successful POST request)
    @GetMapping("/pet-added")
    public String showAddedPets(Model model) {
        model.addAttribute("animals", animalManager.getAnimals()); // Pass the list of animals to the view
        return "pet-added"; // Display the page with the added pets
    }
}