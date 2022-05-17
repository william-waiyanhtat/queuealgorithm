package com.celestial.myapplication;

public class Patient {

    private static int count;

    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
