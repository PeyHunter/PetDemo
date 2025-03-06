package com.example.petdemo.model;

public class Cat extends Animal

{
    public Cat(String name, int age)
    {
        super(name, age);
    }

    @Override
    public String getType() {
        return "Cat";
    }
}
