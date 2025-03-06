package com.example.petdemo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AnimalManager {
    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimail(Animal animal) {
        animals.add(animal);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
