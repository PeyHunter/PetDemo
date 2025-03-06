package com.example.petdemo.model;

public class Dog extends Animal
{
    public Dog(String name, int age)
    {
        super(name, age);
    }

    @Override
    public String getType() {
        return "Dog";
    }
}
