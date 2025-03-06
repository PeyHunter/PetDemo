package com.example.petdemo.model;

public class Animal {
    protected String petName;
    protected int age;

    public Animal(String petName, int age) {
        this.petName = petName;
        this.age = age;
    }

    public String getPetName() {
        return petName;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return "Unknown";
    }
}

