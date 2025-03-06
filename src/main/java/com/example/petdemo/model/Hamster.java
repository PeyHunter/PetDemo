package com.example.petdemo.model;

public class Hamster extends Animal
{
    public Hamster(String name, int age)
    {
        super(name, age);
    }

    @Override
    public String getType() {
        return "Hamster";
    }
}
