package com.example.petdemo.model;

public class Horse extends Animal
{
    public Horse(String name, int age)
    {
        super(name, age);
    }

    @Override
    public String getType() {
        return "Horse";
    }
}
