package com.example.petdemo.model;

public class Rabbit extends Animal
{
    public Rabbit(String name, int age)
    {
        super(name, age);
    }

    @Override
    public String getType() {
        return "Rabbit";
    }
}
