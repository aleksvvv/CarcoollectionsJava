package com.example.carcoollectionsjava;

import java.util.Objects;

public class CarOwner {
    private int key;
    private String name;
    private String lastName;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CarOwner(int key, String name, String lastName) {
        this.key = key;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOwner carOwner = (CarOwner) o;
        return key == carOwner.key && Objects.equals(name, carOwner.name) && Objects.equals(lastName, carOwner.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, lastName);
    }
}
